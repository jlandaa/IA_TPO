package vo;

import java.io.Serializable;
import java.util.Date;

public class MensajeLogVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String modulo;
	private int codModulo;
	private int tipo;
	private String evento;
	private Date fecha;
	public MensajeLogVO() {
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public int getCodModulo() {
		return codModulo;
	}
	public void setCodModulo(int codModulo) {
		this.codModulo = codModulo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getEvento() {
		return evento;
	}
	public void setEvento(String evento) {
		this.evento = evento;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
