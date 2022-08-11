package ClasesVO;

import java.io.Serializable;
import java.util.List;

import entities.SolicitudArticulo;


//Esto nos llega de logistica
public class OrdenDespachoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idOrden;
	private String codOrden;
	private int logistica;
	private String codVenta;
	private int portal;
	private String estado;/*P PENDIENTE, C COMPLETADO,E Entregado*/
	private List <SolicitudArticulo> articulos;
	private String fecha;
	
	public OrdenDespachoVO (){
		super();
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

	public int getPortal() {
		return portal;
	}

	public void setPortal(int portal) {
		this.portal = portal;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
