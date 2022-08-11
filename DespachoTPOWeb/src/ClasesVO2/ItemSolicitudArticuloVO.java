package ClasesVO2;

import java.io.Serializable;

public class ItemSolicitudArticuloVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String idArticulo;

	private int cantSolicitada;
	
	public ItemSolicitudArticuloVO(){}

	public String getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getCantSolicitada() {
		return cantSolicitada;
	}

	public void setCantSolicitada(int cantSolicitada) {
		this.cantSolicitada = cantSolicitada;
	}

	

}
