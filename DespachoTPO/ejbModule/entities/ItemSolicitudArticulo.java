package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//orden-item-solicitud

@Entity()
@Table(name="ItemSolicitudArticulo")
public class ItemSolicitudArticulo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idItemSolicitudArticulo;
	
	private String codArticulo;//Se envia
	private int cantSolicitada;//Se envia
	private int cantRecibida;
	private boolean estado;//Pendiente-Cubierto
	
	public ItemSolicitudArticulo(){}
	
	public String getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
	}

	public int getCantSolicitada() {
		return cantSolicitada;
	}

	public void setCantSolicitada(int cantSolicitada) {
		this.cantSolicitada = cantSolicitada;
	}

	public int getCantRecibida() {
		return cantRecibida;
	}

	public void setCantRecibida(int cantRecibida) {
		this.cantRecibida = cantRecibida;
	}

	@Column(name="estado", columnDefinition="bit")
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	

}
