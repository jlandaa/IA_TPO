package entities;

import java.io.Serializable;

import javax.persistence.*;

import ClasesVO.UsuarioVO;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String nombre;
	private String apellido;
	private String password;
	private Boolean activo;
	
	public Usuario() {
	}
	
	@Id
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="activo", columnDefinition="bit")
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	//Sirve para que lo tome como metodo del negocio y no como metodo get/set 
	@Transient
	public UsuarioVO getUsuarioVO() {

		UsuarioVO usu = new UsuarioVO();

		usu.setUsername(this.username);
		usu.setNombre(this.nombre);
		usu.setApellido(this.apellido);
		usu.setActivo(this.activo);

		return usu;
	}
	
	
}
