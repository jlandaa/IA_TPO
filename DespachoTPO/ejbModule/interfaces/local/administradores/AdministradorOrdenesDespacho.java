package interfaces.local.administradores;

import java.util.List;

import javax.ejb.*;

import ClasesVO.OrdenDespachoVO;
import entities.*;

@Remote
public interface AdministradorOrdenesDespacho {
	
	void agregar(String ordenDespacho);
	
	List<OrdenDespachoVO> listar();
	
	List<OrdenDespacho> listarPorEstado(String estado);
	
	void actualizar(OrdenDespacho ordenDespacho);
	
	OrdenDespacho get(int id);
}
