package interfaces.remota.administradoresServicios;

import java.util.List;

import javax.ejb.*;

import ClasesVO.UsuarioVO;
import entities.Usuario;

@Local
public interface ServicioUsuarios {
	
	void crearUsuario(UsuarioVO usuario);
	
	List<UsuarioVO> listarUsuarios();
	
	void actualizarUsuario(UsuarioVO usuario);
}
