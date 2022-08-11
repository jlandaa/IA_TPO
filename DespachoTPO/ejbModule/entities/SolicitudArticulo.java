package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ClasesVO.SolicitudArticuloVO;

@Entity
@Table(name = "SOLICITUD_ARTICULOS")
public class SolicitudArticulo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="codigoArticulo")
	private Articulo articulo;
	private float recibidos;
	private float solicitados;
	private String estado;/*P Pendiente, E enviado, C Completado*/
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="idSolicitudArticulo")
	List<ItemSolicitudArticulo> items;

	public SolicitudArticulo() {
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
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
	
	public List<ItemSolicitudArticulo> getItems() {
		return items;
	}

	public void setItems(List<ItemSolicitudArticulo> items) {
		this.items = items;
	}

	public SolicitudArticuloVO getArticuloVO() {
		
		SolicitudArticuloVO solVO = new SolicitudArticuloVO();
		
		solVO.setArticulo(this.articulo.getArticuloVO());
		solVO.setRecibidos(this.recibidos);
		solVO.setSolicitados(this.solicitados);
		solVO.setEstado(this.estado);
		
		return solVO;
	}
	
}
