package interfaces.remota.administradoresServicios;

import javax.ejb.*;

import ClasesVO.ArticuloVO;
import ClasesVO.SolicitudArticuloVO;

@Remote
public interface ServicioArticulos {
	
	//ORIGINAL
	void ingresarArticulo(String articulo);
	
	//PRUEBA DE LO QUE MANDO DAMIAN
	void ingresarArticulo(ArticuloVO articulo);
	
	Boolean recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo);
}
