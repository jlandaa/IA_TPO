package ClasesVO;

import java.io.Serializable;
import java.util.List;

import entities.ItemSolicitudArticulo;


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

	private int id;
	private ArticuloVO articulo;
	private float recibidos;
	private float solicitados;
	private String estado;/*P Pendiente, E enviado, C Completado*/
	List<ItemSolicitudArticuloVO> items;
	
	public SolicitudArticuloVO(){
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public ArticuloVO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}

	public float getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(float recibidos) {
		this.recibidos = recibidos;
	}

	public float getSolicitados() {
		return solicitados;
	}

	public void setSolicitados(float solicitados) {
		this.solicitados = solicitados;
	}

	public List<ItemSolicitudArticuloVO> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudArticuloVO> items) {
		this.items = items;
	}
	

}
