package interfaces.remota.administradoresServicios;

import javax.ejb.*;

import ClasesVO.OrdenDespachoVO;


@Remote
public interface ServicioOrdenesDespacho {
	void ingresarOrdenDespacho(OrdenDespachoVO ordenDespacho);
	
	void completarOrdenDespacho(int codigo);
}
