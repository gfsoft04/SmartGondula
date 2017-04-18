package br.com.gfsoft.smartgondula.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import br.com.gfsoft.smartgondula.model.Usuario;

public class PersistenceUsuario implements IPersistenceUsuario {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Usuario usuario) {
		
		String sql = "INSERT INTO usuario(matricula, nome, senha) "
				+ "VALUES('"+ usuario.getMatricula() +"',"
						+ "'"+ usuario.getNome() +"',"
						+ usuario.getSenha() +");";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException ex) {
			// Excecao para banco de dados
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na inserção dos dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(Usuario usuario) {
		
		String sql;
		
		sql = "DELETE FROM usuario WHERE matricula = "+usuario.getMatricula()+";";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar dados na base!", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Usuario usuario) {
		
		String sql = "UPDATE usuario SET nome = '"+usuario.getNome()+"',"
				+ " senha = '"+usuario.getSenha()+"' "
																				
				+ " WHERE matricula = "+usuario.getMatricula()+";";
		
		try {
			con.getConnection().createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public Usuario selectUsuario(String nome) {
		
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario WHERE nome='" + nome + "';";
		
		try {
			stmt = (Statement) con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				usuario.setMatricula(rs.getLong("matricula"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			return usuario;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public Set<Usuario> selectUsuarios() {
		
		Set<Usuario> usuarios = new HashSet<>();
		Usuario usuario;
		
		try {
			stmt = (Statement) con.getConnection().createStatement();
			String sql = "SELECT * FROM usuario;";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				usuario = new Usuario();
				
				usuario.setMatricula(rs.getLong("matricula"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			return usuarios;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos usuários na base!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			try {
//				if(con != null)
//					con.getConnection().close();
				
				if(stmt != null)
					stmt.close();
				
				if(rs != null)
					rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}

}
