package webservice;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ClasesVO.ArticuloVO;

@Path("/articulos")
public class AdministradorArticulos {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<ArticuloVO> getArticulos() throws NamingException {
		return SolicitudArticulosBusinessDelegate.getInstance().listar();
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/agregar")
	public void agregarArticulo(String art) throws NamingException{
		//ArticulosBusinessDelegate.getInstance().ingresarArticulo(art);
		System.out.println(""+art);
	}
}
