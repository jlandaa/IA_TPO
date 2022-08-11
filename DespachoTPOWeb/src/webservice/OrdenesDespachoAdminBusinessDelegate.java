package webservice;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ClasesVO.OrdenDespachoVO;
import interfaces.local.administradores.AdministradorOrdenesDespacho;
import entities.OrdenDespacho;

public class OrdenesDespachoAdminBusinessDelegate implements AdministradorOrdenesDespacho {
	
	static OrdenesDespachoAdminBusinessDelegate instancia = null;
	AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	public static OrdenesDespachoAdminBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new OrdenesDespachoAdminBusinessDelegate();
		}
		
		return instancia;
	}
	
	private OrdenesDespachoAdminBusinessDelegate() throws NamingException {

		try {
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
			jndiProperties.put("remote.connections", "default");
			jndiProperties.put("remote.connection.default.host", "localhost");
			jndiProperties.put("remote.connection.default.port", "8080");
			jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");

			final Context context = new InitialContext(jndiProperties);

			final String earAppName = "DespachoTPOEAR";
			final String ejbModuleName = "DespachoTPO";
			final String distinctName = "";
			final String beanName = "AdministradorOrdenesDespachoBean";
			final String viewClassName = AdministradorOrdenesDespacho.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			administradorOrdenesDespacho = (AdministradorOrdenesDespacho) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
		}
	}

	@Override
	public void agregar(String ordenDespacho) {
		this.administradorOrdenesDespacho.agregar(ordenDespacho);
	}

	@Override
	public List<OrdenDespachoVO> listar() {
		return this.administradorOrdenesDespacho.listar();
	}

	@Override
	public List<OrdenDespacho> listarPorEstado(String estado) {
		return null;
	}

	@Override
	public void actualizar(OrdenDespacho ordenDespacho) {
		
	}

	@Override
	public OrdenDespacho get(int id) {
		return null;
	}
	
}
