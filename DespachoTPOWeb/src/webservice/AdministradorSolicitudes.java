package webservice;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ClasesVO.SolicitudArticuloVO;
import entities.SolicitudArticulo;

@Path("/solicitudes")
public class AdministradorSolicitudes {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<SolicitudArticuloVO> getSolicitudes() throws NamingException {
		return SolicitudArticulosBusinessDelegate.getInstance().listarSolicitudes();
	}
}
