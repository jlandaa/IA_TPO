package ClasesVO2;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ClasesVO.ItemSolicitudArticuloVO;


//Representa la solicitud que hay que hacerle a cada deposito
//de cada articulo que cubra. Se parte de la base de que un articulo
//solo lo satisface un deposito especifico por lo que, se enviara una
//solicitud por cada articulo dentro de una orden a cada deposito que cubra
//ese articulo
public class SolicitudArticuloVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idSolicitudArticulo;

	private Date fecha;

	private String idDespacho;

	private List<ItemSolicitudArticuloVO> articulos;
	
	private String estado;
	
	
	public SolicitudArticuloVO(){}


	public String getIdSolicitudArticulo() {
		return idSolicitudArticulo;
	}


	public void setIdSolicitudArticulo(String idSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getIdDespacho() {
		return idDespacho;
	}


	public void setIdDespacho(String idDespacho) {
		this.idDespacho = idDespacho;
	}


	public List<ItemSolicitudArticuloVO> getArticulos() {
		return articulos;
	}


	public void setArticulos(List<ItemSolicitudArticuloVO> articulos) {
		this.articulos = articulos;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
