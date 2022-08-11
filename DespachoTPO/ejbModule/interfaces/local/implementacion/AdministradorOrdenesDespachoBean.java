package interfaces.local.implementacion;

import interfaces.local.administradores.AdministradorOrdenesDespacho;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;

import ClasesVO.ArticuloVO;
import ClasesVO.OrdenDespachoVO;
import entities.*;

@Stateless
public class AdministradorOrdenesDespachoBean implements AdministradorOrdenesDespacho {
	
	@PersistenceContext(unitName="AdministradorProductosDB")
	private EntityManager em;

	@Override
	public void agregar(String ordenDespacho) {
		
		//Convierto el String en Json y de Json en objeto
		Gson gson = new Gson();

		OrdenDespachoVO ordenVO = gson.fromJson(ordenDespacho, OrdenDespachoVO.class);
		
		OrdenDespacho orden = new OrdenDespacho();
		
		//Habria que adaptar la clase al Json que esta colgado en el DRIVE porque en
		//ese te dice que en una orden hay varios items distintos por lo cual hay que
		//colocar en la clase una lista de items y recien ahi comenzar a guardar la orden
		
		this.em.persist(ordenDespacho);
		
		//Una vez agregado habria que mandarlo a la cola nuestra para que levante el
		//mensaje el deposito correspondiente
	}
	
	@Override
	public List<OrdenDespachoVO> listar() {
		@SuppressWarnings("unchecked")
		List<OrdenDespacho> ordenesDespacho = this.em.createQuery(" FROM OrdenDespacho").getResultList();
		
		List<OrdenDespachoVO> ordenesVO = new ArrayList<OrdenDespachoVO>();
		
		for (int i=0;i<ordenesDespacho.size();i++){
			
			OrdenDespachoVO ord = ordenesDespacho.get(i).getOrdenDespachoVO();
			
			ordenesVO.add(ord);
			
		}
		
		return ordenesVO;
	}
	
	@Override
	public List<OrdenDespacho> listarPorEstado(String estado) {
		@SuppressWarnings("unchecked")
		List<OrdenDespacho> ordenesDespacho = this.em.createQuery(" FROM OrdenDespacho WHERE estado = '" + estado + "' ORDER BY fecha").getResultList();
		return ordenesDespacho;
	}
	
	@Override
	public void actualizar(OrdenDespacho ordenDespacho) {
		// Actualizar los articulos
		for (SolicitudArticulo solicitudArticulo : ordenDespacho.getArticulos()) {
			
			this.em.merge(solicitudArticulo);
		}
		
		this.em.merge(ordenDespacho);
	}
	
	@Override
	public OrdenDespacho get(int id) {
		return this.em.find(OrdenDespacho.class, id);
	}
}

