package webservice;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ClasesVO.UsuarioVO;

@Path("/usuarios")
public class AdministradorUsuarios {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioVO> getUsuarios() throws NamingException {
		return UsuariosBusinessDelegate.getInstance().listar();
	}
	
	@GET
	@Path("{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioVO getUsuario(@PathParam("username") String username) throws NamingException {
		return UsuariosBusinessDelegate.getInstance().get(username);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(UsuarioVO usuario) throws NamingException {
		if (usuario == null || usuario.getUsername() == null) {
			return Response.status(400).build();
		}
		
		if (UsuariosBusinessDelegate.getInstance().get(usuario.getUsername()) == null) {;
			UsuariosBusinessDelegate.getInstance().agregar(usuario);
		}
		else {
			UsuariosBusinessDelegate.getInstance().actualizar(usuario);
		}
		
		return Response.status(200).build();
	}
	
	@PUT
	@Path("{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarUsuario(@PathParam("username") String username, UsuarioVO usuario) throws NamingException {
		if (usuario == null) {
			return Response.status(400).build();
		}
		
		if (UsuariosBusinessDelegate.getInstance().get(username) != null) {;
			UsuariosBusinessDelegate.getInstance().actualizar(usuario);
			return Response.status(200).build();
		}
		else {
			return Response.status(400).build();
		}
	}
	
	@DELETE
	@Path("{username}")
	public void eliminarUsuario(@PathParam("username") String username) throws NamingException {
		UsuariosBusinessDelegate.getInstance().eliminar(username);
	}
}
