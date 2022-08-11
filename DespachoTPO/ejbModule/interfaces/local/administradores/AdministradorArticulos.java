package interfaces.local.administradores;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import ClasesVO.ArticuloVO;
import ClasesVO.SolicitudArticuloVO;
import entities.Articulo;
import entities.SolicitudArticulo;

@Remote
public interface AdministradorArticulos {
	
	List<ArticuloVO> listar();
	
	List<SolicitudArticuloVO> listarSolicitudes();
	
	void agregar(ArticuloVO articulo);
	
	void guardarSolicitud(SolicitudArticulo solicitud);
	
	Articulo get(String id);
}

