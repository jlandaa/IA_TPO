package webservice;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ClasesVO.ArticuloVO;
import ClasesVO.SolicitudArticuloVO;
import interfaces.local.administradores.AdministradorArticulos;
import entities.Articulo;
import entities.SolicitudArticulo;


public class SolicitudArticulosBusinessDelegate implements AdministradorArticulos {
	
	static SolicitudArticulosBusinessDelegate instancia = null;
	AdministradorArticulos administradorArticulos;
	
	public static SolicitudArticulosBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new SolicitudArticulosBusinessDelegate();
		}
		
		return instancia;
	}
	
	private SolicitudArticulosBusinessDelegate() throws NamingException {

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
			final String beanName = "AdministradorArticulosBean";
			final String viewClassName = AdministradorArticulos.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			administradorArticulos = (AdministradorArticulos) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
		}
	}

	@Override
	public void agregar(ArticuloVO articulo) {
		
	}

	@Override
	public void guardarSolicitud(SolicitudArticulo solicitud) {
	}

	@Override
	public Articulo get(String id) {
		return null;
	}

	@Override
	public List<ArticuloVO> listar() {
		return this.administradorArticulos.listar();
	}

	@Override
	public List<SolicitudArticuloVO> listarSolicitudes() {
		return this.administradorArticulos.listarSolicitudes();
	}
	
}

