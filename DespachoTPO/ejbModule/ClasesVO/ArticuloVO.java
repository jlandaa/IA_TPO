package ClasesVO;

import java.io.Serializable;


public class ArticuloVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	//Este es el id con el que lo tenemos en la b.datos
	private String id;
	
	//Id con el que nos llega del portal web
	//Habria que hacer un mapa en el que me indique
	//a que articulo corresponde ese id
	private String codigo;
	
	private String nombre;
	
	private String descripcion;
	
	//El tp indica que un articulo solo lo satisface un deposito especifico
	private String deposito;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDeposito() {
		return deposito;
	}

	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
	
	
	
	
}
