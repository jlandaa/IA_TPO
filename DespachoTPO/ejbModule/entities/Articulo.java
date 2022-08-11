package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import ClasesVO.ArticuloVO;

@Entity
@Table(name = "ARTICULOS")
public class Articulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="codigoArticulo")
	private String codigo;
	
	private String nombre;

	private String descripcion;
	private String deposito;
	

	public Articulo() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	@Transient
	public ArticuloVO getArticuloVO(){
		
		ArticuloVO artVO = new ArticuloVO();
		
		artVO.setCodigo(this.codigo);
		artVO.setNombre(this.nombre);
		artVO.setDescripcion(this.descripcion);
		artVO.setDeposito(this.deposito);
		
		return artVO;
	}

}
