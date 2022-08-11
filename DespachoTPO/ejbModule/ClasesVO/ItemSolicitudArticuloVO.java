package ClasesVO;

import java.io.Serializable;

public class ItemSolicitudArticuloVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idItemSolicitudArticulo;
	private String codArticulo;//Se envia
	private int cantSolicitada;//Se envia
	private int cantRecibida;
	private boolean estado;//Pendiente-Cubierto
	
	public ItemSolicitudArticuloVO(){
		
	}


	public int getIdItemSolicitudArticulo() {
		return idItemSolicitudArticulo;
	}


	public void setIdItemSolicitudArticulo(int idItemSolicitudArticulo) {
		this.idItemSolicitudArticulo = idItemSolicitudArticulo;
	}


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


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	

}
