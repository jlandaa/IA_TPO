package webservice;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ClasesVO.UsuarioVO;
import interfaces.local.administradores.AdministradorUsuarios;
import interfaces.local.implementacion.AdministradorUsuariosBean;
import entities.Usuario;

public class UsuariosBusinessDelegate implements AdministradorUsuarios {
	
	static UsuariosBusinessDelegate instancia = null;
	AdministradorUsuarios adm;
	
	public static UsuariosBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new UsuariosBusinessDelegate();
		}
		
		return instancia;
	}
	
	private UsuariosBusinessDelegate() throws NamingException {
		
		//Como se ingresa a un contenedor para acceder a los EJB solo se puede
		//hacer a traves de un lookup por eso se realiza de esta manera
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
			final String beanName = "AdministradorUsuariosBean";
			final String viewClassName = AdministradorUsuarios.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			adm = (AdministradorUsuarios) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
		}
	}

	@Override
	public void agregar(UsuarioVO usuario) {
		this.adm.agregar(usuario);
	}

	@Override
	public List<UsuarioVO> listar() {
		return this.adm.listar();
	}

	@Override
	public void actualizar(UsuarioVO usuario) {
		this.adm.actualizar(usuario);
	}

	@Override
	public UsuarioVO get(String username) {
		return this.adm.get(username);
	}

	@Override
	public void eliminar(String username) {
		this.adm.eliminar(username);
	}
}

