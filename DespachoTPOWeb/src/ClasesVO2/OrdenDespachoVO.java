package ClasesVO2;

import java.io.Serializable;
import java.util.ArrayList;

import ClasesVO.ItemSolicitudArticuloVO;


//Esto nos llega de logistica
public class OrdenDespachoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codOrden;
	private String nombreUsuario;
	private int codVenta;
	private int codPortal;
	private ArrayList<ItemSolicitudArticuloVO> articulos;
	private String estado;
	public OrdenDespachoVO() {
		super();
	}
	public int getCodOrden() {
		return codOrden;
	}
	public void setCodOrden(int codOrden) {
		this.codOrden = codOrden;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getCodVenta() {
		return codVenta;
	}
	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}
	public int getCodPortal() {
		return codPortal;
	}
	public void setCodPortal(int codPortal) {
		this.codPortal = codPortal;
	}
	public ArrayList<ItemSolicitudArticuloVO> getArticulos() {
		return articulos;
	}
	public void setArticulos(ArrayList<ItemSolicitudArticuloVO> articulos) {
		this.articulos = articulos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
