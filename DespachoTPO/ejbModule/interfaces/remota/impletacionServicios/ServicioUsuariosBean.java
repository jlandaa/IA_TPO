package interfaces.remota.impletacionServicios;


import java.util.List;

import javax.ejb.*;

import ClasesVO.UsuarioVO;
import interfaces.remota.administradoresServicios.ServicioUsuarios;
import interfaces.local.administradores.AdministradorUsuarios;
import entities.Usuario;

@Stateless
public class ServicioUsuariosBean implements ServicioUsuarios {

	@EJB
	private AdministradorUsuarios administradorUsuarios;
	
	@Override
	public void crearUsuario(UsuarioVO usuario) {
		this.administradorUsuarios.agregar(usuario);
	}

	@Override
	public List<UsuarioVO> listarUsuarios() {
		return this.administradorUsuarios.listar();
	}

	public void actualizarUsuario(UsuarioVO usuario) {
		this.administradorUsuarios.actualizar(usuario);
	}

}
