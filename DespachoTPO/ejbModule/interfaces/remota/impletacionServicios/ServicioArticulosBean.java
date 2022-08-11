package interfaces.remota.impletacionServicios;

import interfaces.local.administradores.AdministradorArticulos;
import interfaces.local.administradores.AdministradorOrdenesDespacho;
import interfaces.local.administradores.AdministradorUsuarios;
import interfaces.remota.administradoresServicios.ServicioArticulos;
import interfaces.remota.administradoresServicios.ServicioOrdenesDespacho;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import mensajes.configuracionColaMensajes.Logger;
import ClasesVO.ArticuloVO;
import ClasesVO.ItemSolicitudArticuloVO;
import ClasesVO.SolicitudArticuloVO;
import entities.Articulo;
import entities.OrdenDespacho;
import entities.SolicitudArticulo;

@Stateless
public class ServicioArticulosBean implements ServicioArticulos {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private ServicioOrdenesDespacho servicioOrdenesDespacho;
	
	@Override
	// DCH01.Recibir nuevo Artículo
	public void ingresarArticulo(ArticuloVO articulo) {
		try {
			if (articulo == null) {
				return;
			}
			
			Logger.info("DCH01", "Nuevo articulo ingresado: " + articulo.getCodigo() + " - Deposito: " + articulo.getDeposito());
			
			// Persistir el articulo
			
			//Articulo nuevoArticulo = new Articulo();
			//nuevoArticulo.setIdArticulo(articulo.getIdarticulo());
			//nuevoArticulo.setDeposito(articulo.getDeposito());
			//nuevoArticulo.setNombre(articulo.getNombre());
			//nuevoArticulo.setCodigo(articulo.getCodigo());
			
			this.administradorArticulos.agregar(articulo);
			
			Logger.info("DCH01", "Listo (DCH01 - Recibir nuevo Artículo)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH01", e.getMessage());
		}
	}
	
	@Override
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public Boolean recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo) {
		try {
			Logger.info("DCH03", "Recepcion solicitud articulo: " + solicitudArticulo.getArticulo().getCodigo());
			
			/*Se recibe una respuesta a una solicitud hecha de una Orden de Despacho
			 * si la cantidad recibida en esa solicitud es >= a la cantidad solicitada
			 * originalmente en dicha solicitud se debera cambiar el estado actual de la
			 * solicitud de PENDIENTE a LISTO. Cuando todas las solicitudes que posee
			 * una orden estan en estado LISTO recien ahi se enviara al modulo del
			 * PORTAL WEB la entrega del pedido*/
			
			
			for (ItemSolicitudArticuloVO itemSolicitud : solicitudArticulo.getArticulos()) {
				
				int cantidad = itemSolicitud.getCantSolicitada();
				
				// Obtengo las ordenes PENDIENTES DE ENTREGA (ordenadas por la mas antigua)
				List<OrdenDespacho> ordenesPendientes = this.administradorOrdenesDespacho.listarPorEstado("PendienteEntrega");
				
				for (OrdenDespacho ordenPendiente : ordenesPendientes) {
					
					// Proceso la orden que contenga el articulo en cuestion
					for (SolicitudArticulo solicitudArticuloOrden : ordenPendiente.getArticulos()) {
						
						if (itemSolicitud.getCodArticulo().equalsIgnoreCase(solicitudArticuloOrden.getArticulo().getCodigo())) {
							
							//Redefinir
							if (solicitudArticuloOrden.getCantidad() <= cantidad) {
								
								solicitudArticuloOrden.setEstado("Lista");
								cantidad = cantidad - solicitudArticuloOrden.getCantidad();
							}
						}
					}
					
					// Actualizo la orden
					this.administradorOrdenesDespacho.actualizar(ordenPendiente);
					
					// Si todos los articulos de la orden estan listos para entrega, se llama a DCH04
					Boolean ordenListaParaEntrega = true;
					
					for (SolicitudArticulo solicitudArticuloOrden : ordenPendiente.getArticulos()) {
						
						if (!solicitudArticuloOrden.getEstado().equalsIgnoreCase("Lista")) {
							
							ordenListaParaEntrega = false;
							break;
						}
					}
					
					if (ordenListaParaEntrega) {
						this.servicioOrdenesDespacho.completarOrdenDespacho(ordenPendiente.getCodOrden());
					}
				}
			}
			
			Logger.info("DCH03", "Listo (DCH03 - Recepción y Procesamiento de Artículos a Despachar)");
			return true;
		}
		catch (Throwable e) {
			e.printStackTrace();
			Logger.error("DCH03", e.getMessage());
			return false;
		}
	}
}
