package br.com.gfsoft.smartgondula.service;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Usuario;
import br.com.gfsoft.smartgondula.persistence.IPersistenceUsuario;
import br.com.gfsoft.smartgondula.persistence.PersistenceUsuario;

public class UsuarioService  extends Service{
	
private IPersistenceUsuario persistencia;
	
	public UsuarioService(){
		
		persistencia = new PersistenceUsuario();
		
	}

	public boolean cadastrar(Usuario usuario){
		return persistencia.insert(usuario);
	}
	
	public boolean deletar(Usuario usuario){
		return persistencia.delete(usuario);
	}
	
	public boolean atualizar(Usuario usuario){
		return persistencia.update(usuario);
	}
	
	public Usuario buscar(int matricula) {
		return persistencia.selectUsuario(matricula);
	}
	
	public Set<Usuario> listar(){
		return persistencia.selectUsuarios();
	}
	
}
