package interfaces.local.implementacion;

import interfaces.local.administradores.AdministradorUsuarios;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.*;

import ClasesVO.UsuarioVO;
import entities.*;

@Stateless
public class AdministradorUsuariosBean implements AdministradorUsuarios {
	
	@PersistenceContext(unitName="AdministradorProductosDB")
	private EntityManager em;

	@Override
	public void agregar(UsuarioVO usuario) {
		
		//this.em.getTransaction().begin();
		
		Usuario usu=new Usuario();
		
		usu.setUsername(usuario.getUsername());
		usu.setPassword(usuario.getPassword());
		usu.setNombre(usuario.getNombre());
		usu.setApellido(usuario.getApellido());
		usu.setActivo(true);
		
		this.em.persist(usu);
		//this.em.getTransaction().commit();
		//this.em.close();
	}
	
	@Override
	public List<UsuarioVO> listar() {
		
		//Obtengo la lista de Usuarios
		
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = this.em.createQuery(" FROM Usuario").getResultList();
		
		UsuarioVO usu;
		List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();
		
		//Convierto esos Usuarios en objetos VO los cuales seran
		//mostrados al Usuario final
		
		for (int i=0;i<usuarios.size();i++){
			
			//Convierto el objeto persistido en un objeto VO
			usu = usuarios.get(i).getUsuarioVO();
			
			//Lo agrego a la lista de resultados
			usuariosVO.add(usu);
		}
		
		return usuariosVO;
	}
	
	public void actualizar(UsuarioVO usuario) {
		
		//Tomamos que el valor 1 es TRUE y el 0 FALSE
		
		//Si esta habilitado
		if (usuario.getActivo() == true){
			
			//Cambiamos el estado a deshabilitado
			this.em.createQuery("UPDATE Usuario SET activo = false"+" where username ="+usuario.getUsername());
		
		}else{
			
			//Cambiamos el estado a habilitado
			this.em.createQuery("UPDATE Usuario SET activo = true"+" where username ="+usuario.getUsername());
		
		}
	
	}
	
	@Override
	public UsuarioVO get(String username) {
		
		UsuarioVO usuVO = null;
		
		//Busco al Usuario solicitado
		Usuario usu = this.em.find(Usuario.class, username);
		
		//Si existe
		if (usu != null){
			
			//Lo convierto en un objeto VO para mostrarlo al Usuario
			usuVO = usu.getUsuarioVO();
			
		}
		
		return usuVO;
	}
	
	@Override
	public void eliminar(String username) {
		UsuarioVO usuario = this.get(username);
		//Si existe el User, lo elimina
		if (usuario != null) {
			this.em.remove(usuario);
		}
	}
}

