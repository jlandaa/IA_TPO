package entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import ClasesVO.OrdenDespachoVO;

@Entity
@Table(name = "ORDEN_DESPACHOS")
public class OrdenDespacho implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idOrden;
	private String codOrden;
	private int logistica;
	private String codVenta;
	private int portal;
	private String estado;/*P PENDIENTE, C COMPLETADO,E Entregado*/
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="idOrden")
	private List <SolicitudArticulo> articulos;
	private String fecha;
	
	public OrdenDespacho() {
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<SolicitudArticulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<SolicitudArticulo> articulos) {
		this.articulos = articulos;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public String getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(String codOrden) {
		this.codOrden = codOrden;
	}

	public int getLogistica() {
		return logistica;
	}

	public void setLogistica(int logistica) {
		this.logistica = logistica;
	}

	public String getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(String codVenta) {
		this.codVenta = codVenta;
	}

	public void setPortal(int portal) {
		this.portal = portal;
	}


	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public OrdenDespachoVO getOrdenDespachoVO (){
		
		OrdenDespachoVO ordVO = new OrdenDespachoVO();
		
		ordVO.setCodOrden(this.codOrden);
		ordVO.setCodVenta(this.codVenta);
		ordVO.setArticulos(this.articulos);
		ordVO.setPortal(this.portal);
		ordVO.setFecha(this.fecha);
		ordVO.setLogistica(this.logistica);
		ordVO.setEstado(this.estado);
		
		return ordVO;
	}
	
}
