package webservice;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ClasesVO.ArticuloVO;
import ClasesVO.SolicitudArticuloVO;
import interfaces.remota.administradoresServicios.ServicioArticulos;
import interfaces.local.administradores.AdministradorArticulos;

public class ArticulosBusinessDelegate implements ServicioArticulos {

	static ArticulosBusinessDelegate instancia = null;
	ServicioArticulos servicioArticulos;
	AdministradorArticulos adm;
	
	public static ArticulosBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new ArticulosBusinessDelegate();
		}
		
		return instancia;
	}
	
	private ArticulosBusinessDelegate() throws NamingException {

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

			adm = (AdministradorArticulos) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
			System.out.println("Entro en exception");
		}
	}
	
	public void ingresarArticulo(String art) {
		
		//Convertir String (que contiene un JSON) en ArticuloVO
		
		
		//servicioArticulos.ingresarArticulo(articulo);
		servicioArticulos.ingresarArticulo(art);
	}

	@Override
	public Boolean recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo) {
		return servicioArticulos.recepcionArticulosParaDespachar(solicitudArticulo);
	}
	
	public List<ArticuloVO> listar (){
		
		List<ArticuloVO> articulos = adm.listar();
		
		return articulos;
	
	}

	@Override
	public void ingresarArticulo(ArticuloVO articulo) {
		servicioArticulos.ingresarArticulo(articulo);
		
	} 

}
