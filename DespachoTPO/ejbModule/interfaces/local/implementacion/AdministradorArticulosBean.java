package interfaces.local.implementacion;

import interfaces.local.administradores.AdministradorArticulos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ClasesVO.ArticuloVO;
import ClasesVO.OrdenDespachoVO;
import ClasesVO.SolicitudArticuloVO;
import entities.Articulo;
import entities.SolicitudArticulo;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {

	@PersistenceContext(unitName="AdministradorProductosDB")
	private EntityManager em;
	
	@Override
	public List<ArticuloVO> listar() {
		
		@SuppressWarnings("unchecked")
		List<Articulo> articulos = this.em.createQuery(" FROM Articulo").getResultList();
		List<ArticuloVO> artVO = new ArrayList<ArticuloVO>();
		
		for (int i=0;i<articulos.size();i++){
			
			ArticuloVO art = articulos.get(i).getArticuloVO();
			
			artVO.add(art);
			
		}
		
		return artVO;
	}
	
	@Override
	public List<SolicitudArticuloVO> listarSolicitudes() {
		@SuppressWarnings("unchecked")
		List<SolicitudArticulo> solicitudes = this.em.createQuery(" FROM SolicitudArticulo").getResultList();
		
		List<SolicitudArticuloVO> solVO = new ArrayList<SolicitudArticuloVO>();
		
		for (int i=0;i<solicitudes.size();i++){
			
			SolicitudArticuloVO sol = solicitudes.get(i).getArticuloVO();
			
			solVO.add(sol);
			
		}
		
		return solVO;
		
	}
	
	@Override
	public void agregar(ArticuloVO articulo) {
		
		//Se comprueba si el articulo existe en el sistema
		if (this.em.find(Articulo.class, articulo.getCodigo()) == null){
			
			Articulo art = new Articulo();
			
			art.setCodigo(articulo.getCodigo());
			art.setDeposito(articulo.getDeposito());
			art.setNombre(art.getNombre());
			art.setDescripcion(art.getDescripcion());
			
			this.em.persist(art);
		
		}
	}
	
	@Override
	public void guardarSolicitud(SolicitudArticulo solicitud) {
		this.em.persist(solicitud);
	}
	
	public Articulo get(int i) {
		return this.em.find(Articulo.class, i);
	}

	@Override
	public Articulo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
