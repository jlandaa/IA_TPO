package webservice;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ClasesVO.SolicitudArticuloVO;

@Path("/json")
public class AdministradorSolicitudArticulos {
	
	@POST
	@Path("/solicitudArticulo")
	@Consumes(MediaType.APPLICATION_JSON)
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public Response recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo) throws NamingException {
		
		if (solicitudArticulo == null || solicitudArticulo.getIdSolicitudArticulo() == null) {
			return Response.status(400).build(); // HTTP 400: BadRequest
		}
		
		Boolean success = ArticulosBusinessDelegate.getInstance().recepcionArticulosParaDespachar(solicitudArticulo);
		return Response.status(success ? 201 : 500).build();
	}
}
