package vo;

import java.io.Serializable;

public class EstadoDespachoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoSalida;
	private String errorDescripcion;
	private int codigoOD;
	private String estado;
	public EstadoDespachoVO() {
	}
	public int getCodigoSalida() {
		return codigoSalida;
	}
	public void setCodigoSalida(int codigoSalida) {
		this.codigoSalida = codigoSalida;
	}
	public String getErrorDescripcion() {
		return errorDescripcion;
	}
	public void setErrorDescripcion(String errorDescripcion) {
		this.errorDescripcion = errorDescripcion;
	}
	public int getCodigoOD() {
		return codigoOD;
	}
	public void setCodigoOD(int codigoOD) {
		this.codigoOD = codigoOD;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
