package br.com.gfsoft.smartgondula.persistence;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Usuario;

public interface IPersistenceUsuario {
	
	public boolean insert(Usuario usuario);
	public boolean delete(Usuario usuario);
	public boolean update(Usuario usuario);
	public Usuario selectUsuario(long matricula);
	public Set<Usuario> selectUsuarios();
	
}
