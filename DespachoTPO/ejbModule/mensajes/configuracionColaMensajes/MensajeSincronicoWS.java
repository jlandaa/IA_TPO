package mensajes.configuracionColaMensajes;

import iaPortalWeb.PortalWeb;
import iaPortalWeb.PortalWebServiceLocator;

import java.net.URL;

import sessionBeans.AdminAuditoriaBean;
import sessionBeans.AdminAuditoriaBeanServiceLocator;
import sessionBeans.MensajeLogVO;
import ws.ObtenerEstado;
import ws.ObtenerEstadoServiceLocator;
import entities.OrdenDespacho;

public class MensajeSincronicoWS {
	
	public static void informarOrdenListaEntrega(OrdenDespacho orden, String nombrePortal) throws Exception {
		String url = Configuracion.getInstancia().get().get(nombrePortal + "-OrdenDespachoListaWS-Url");
		
		try {
			if (nombrePortal.equalsIgnoreCase("PortalC")) {
				ObtenerEstado port = new ObtenerEstadoServiceLocator().getObtenerEstadoPort(new URL(url));
				port.cambioEstadoEntrega(orden.getCodVenta(), orden.getEstado());
			}
			else if (nombrePortal.equalsIgnoreCase("PortalA")) {
				PortalWeb port = new PortalWebServiceLocator().getPortalWebPort(new URL(url));
				port.cambioEstadoEntrega(orden.getCodVenta(), orden.getEstado());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void loguearEvento(MensajeLogVO mensajeLog) {
		String url = Configuracion.getInstancia().get().get("Auditoria-LoguearEventoWS-Url");
		
		try {
			AdminAuditoriaBean port = new AdminAuditoriaBeanServiceLocator().getAdminAuditoriaBeanPort(new URL(url));
			port.recepcionarInformes(mensajeLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
