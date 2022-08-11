package interfaces.remota.impletacionServicios;


import java.util.*;
import javax.ejb.*;
import javax.jws.*;

import mensajes.configuracionColaMensajes.Configuracion;
import mensajes.configuracionColaMensajes.Logger;
import mensajes.configuracionColaMensajes.MensajeAsincronico;
import mensajes.configuracionColaMensajes.MensajeSincronicoRest;
import mensajes.configuracionColaMensajes.MensajeSincronicoWS;
import vo.EstadoDespachoVO;
import ClasesVO.ItemSolicitudArticuloVO;
import ClasesVO.OrdenDespachoVO;
import ClasesVO.SolicitudArticuloVO;
import interfaces.local.administradores.AdministradorArticulos;
import interfaces.local.administradores.AdministradorOrdenesDespacho;
import interfaces.remota.administradoresServicios.ServicioOrdenesDespacho;
import entities.*;

@Stateless
@WebService(name = Configuracion.IngresoOrdenDespachoServiceName)
public class ServicioOrdenesDespachoBean implements ServicioOrdenesDespacho {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AdministradorArticulos administradorArticulos;

	@WebMethod
	// DCH02. Logistica ingresa nuevas ordenes de despacho
	public void ingresarOrdenDespacho(OrdenDespachoVO ordenDespacho) {
		try {
			if (ordenDespacho == null) {
				return;
			}
			
			Logger.info("DCH02", "Nueva Orden de despacho con codigo: " + ordenDespacho.getCodOrden());
			
			List<SolicitudArticulo> articulos = new ArrayList<SolicitudArticulo>();
			
			// Por cada articulo de la orden, se debe obtener el Deposito que lo administra y solicitarlo asincronicamente
			List<ItemSolicitudArticuloVO> articulosOrden = ordenDespacho.getArticulos();
			
			if (articulosOrden != null) {
				for (ItemSolicitudArticuloVO articuloOrden : articulosOrden) {
					String codigoArticulo = articuloOrden.getIdArticulo();
					Articulo articulo = this.administradorArticulos.get(codigoArticulo);
					
					if (articulo == null) {
						Logger.error("DCH02", "El articulo con codigo " + codigoArticulo + " no existe.");
						break;
					}
					
					// Obtengo el deposito asociado al articulo
					String nombreDeposito = articulo.getDeposito();
					
					// Solicitar articulo
					Logger.info("DCH02", "Solicitando articulo " + articulo.getIdArticulo() + " al deposito " + nombreDeposito + "...");
				
					// El id de la solicitud es "{CodigoOrden}-{IdArticulo}"
					String idSolicitudArticulo = ordenDespacho.getCodOrden() + "-" + articuloOrden.getIdArticulo();
					
					List<ItemSolicitudArticuloVO> articulosSolicitud = new ArrayList<ItemSolicitudArticuloVO>();
					articulosSolicitud.add(articuloOrden);
					
					SolicitudArticuloVO solicitudDeposito = new SolicitudArticuloVO();
					solicitudDeposito.setEstado("Solicitado");
					solicitudDeposito.setIdDespacho(Configuracion.getInstancia().get().get("NombreDespacho"));
					solicitudDeposito.setIdSolicitudArticulo(idSolicitudArticulo);
					solicitudDeposito.setArticulos(articulosSolicitud);
					
					// Solicitar articulo al deposito
					MensajeAsincronico.enviarObjeto(
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Url"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Nombre"), 
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Usuario"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Password"), 
							solicitudDeposito);
					
					// Guardar la solicitud por Deposito
					SolicitudArticulo solicitud = new SolicitudArticulo();
					solicitud.setId(idSolicitudArticulo);
					solicitud.setEstado("Solicitado");
					solicitud.setArticulo(articulo);
					
					articulos.add(solicitud);
				}
			}
			
			// Guardar la orden. Se deben registrar como pendientes de entrega
			OrdenDespacho nuevaOrdenDespacho = new OrdenDespacho();
			nuevaOrdenDespacho.setEstado("PendienteEntrega");
			nuevaOrdenDespacho.setCodOrden(ordenDespacho.getCodOrden());
			nuevaOrdenDespacho.setPortal(ordenDespacho.getPortal());
			nuevaOrdenDespacho.setCodVenta(ordenDespacho.getCodVenta());
			nuevaOrdenDespacho.setFecha(new Date());
			nuevaOrdenDespacho.setArticulos(articulos);
			this.administradorOrdenesDespacho.agregar(nuevaOrdenDespacho);
			
			Logger.info("DCH02", "Listo (DCH02 - Logistica ingresa nuevas ordenes de despacho)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH02", e.getMessage());
		}
	}
	
	@Override
	// DCH04. Envío Cambio de Estado de Despacho (Entrega)
	public void completarOrdenDespacho(int codigo) {
		try {
			Logger.info("DCH04", "Completar Orden de Despacho: " + codigo);
			
			OrdenDespacho orden = this.administradorOrdenesDespacho.get(codigo);
			
			if (orden == null) {
				Logger.error("DCH04", "La orden de despacho con codigo " + codigo + " no existe.");
				return;
			}
			
			orden.setEstado("Entregada");
			
			// Informar a los portales que todos los articulos de una Orden de Despacho estén listos para Entrega
			for (String nombrePortal: Configuracion.getInstancia().getPortales()) {
				Logger.info("DCH04", "Informando al portal " + nombrePortal + " que la orden de despacho fue completada...");
				
				try {
					MensajeSincronicoWS.informarOrdenListaEntrega(orden, nombrePortal);
				}
				catch (Throwable ex) {
					Logger.error("DCH04", ex.getMessage());
				}
			}
			
			// Informar en comunicación sincrónica (REST) al módulo Logística
			Logger.info("DCH04", "Informando a Logistica que la orden de despacho fue completada...");
			
			EstadoDespachoVO estadoDespacho = new EstadoDespachoVO();
			estadoDespacho.setCodigoOD(codigo);
			estadoDespacho.setEstado(orden.getEstado());
			estadoDespacho.setCodigoSalida(0);
			estadoDespacho.setErrorDescripcion("");
			
			try {
				MensajeSincronicoRest.post(
						Configuracion.getInstancia().get().get("Auditoria-OrdenDespachoListaRest-Url"), 
						estadoDespacho);
			}
			catch (Throwable ex) {
				Logger.error("DCH04", ex.getMessage());
			}
			
			// El sistema debe registrar y cambiar de estado a la Orden de Despacho y marcarla como entregada
			this.administradorOrdenesDespacho.actualizar(orden);
			
			Logger.info("DCH04", "Listo (DCH04 - Envío Cambio de Estado de Despacho (Entrega))");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH04", e.getMessage());
		}
	}
}
