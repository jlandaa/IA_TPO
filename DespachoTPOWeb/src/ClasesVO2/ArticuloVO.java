package ClasesVO2;

import java.io.Serializable;


public class ArticuloVO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	//Este es el id con el que lo tenemos en la b.datos
	//private String idarticulo;
	
	//Id con el que nos llega del portal web
	//Habria que hacer un mapa en el que me indique
	//a que articulo corresponde ese id
	private int codArticulo;
	
	private String nombre;
	
	private String descripcion;
	
	private String marca;
	
	//Verificar
	private String origen;
	
	private float precio;
	
	private String categoria;
	
	private int stock;
	
	//El tp indica que un articulo solo lo satisface un deposito especifico
	private String idDeposito;

	public int getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(String idDeposito) {
		this.idDeposito = idDeposito;
	}
	
	
	
	
	
}
