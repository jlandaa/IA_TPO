package webservice;

import java.util.Map.Entry;
import java.util.Set;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mensajes.configuracionColaMensajes.Configuracion;

@Path("/configuracion")
public class AdministradorConfiguracion {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Entry<String, String>> getConfiguracion() throws NamingException {
		return Configuracion.getInstancia().get().entrySet();
	}
}
