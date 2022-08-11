package webservice;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ClasesVO.OrdenDespachoVO;
import entities.OrdenDespacho;

@Path("/ordenes")
public class AdministradorOrdenesDespacho {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public List<OrdenDespachoVO> getOrdenes() throws NamingException {
		//La clase en teoria tendria que tener seteado todo lo que aparece
		//en el JSON del Drive. Con eso el metodo tendria que buscar en la b.datos
		//todas las ordenes a eso convertirlo en JSON y luego en String para recien
		//ahi enviarlo al deposito cuando sea llamado el WS o bien si tenemos
		//una cola tendriamos que hacer el mismo proceso y al final colocar el
		//String dentro de la cola como mensaje
		return OrdenesDespachoAdminBusinessDelegate.getInstance().listar();
	}
	
	@POST
	@Produces (MediaType.TEXT_PLAIN)
	public String crearOrden(String orden){
		return OrdenesDespachoAdminBusinessDelegate.getInstance().agregar(orden);
	}
}
