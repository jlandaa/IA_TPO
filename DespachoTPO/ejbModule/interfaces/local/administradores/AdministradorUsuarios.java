package interfaces.local.administradores;

import java.util.List;

import javax.ejb.*;

import ClasesVO.UsuarioVO;

@Remote
public interface AdministradorUsuarios {
	
	void agregar(UsuarioVO usuario);
	
	List<UsuarioVO> listar();
	
	void actualizar(UsuarioVO usuario);
	
	UsuarioVO get(String username);
	
	void eliminar(String username);
}
