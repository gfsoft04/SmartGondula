package br.com.gfsoft.smartgondula.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import br.com.gfsoft.smartgondula.model.Produto;

public class PersistenceProduto implements IPersistenceProduto {
	
	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();

	@Override
	public boolean insert(Produto produto) {
		String sql = "INSERT INTO produto(codigo, descricao, precoAtacado, precoVarejo) "
				+ "VALUES('"+ produto.getCodigo() +"',"
						+ "'"+ produto.getDescricao() +"',"
						+ produto.getPrecoAtacado() +"),"
						+ produto.getPrecoVarejo() +");";
		
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
	public boolean delete(Produto produto) {
		String sql;
		
		sql = "DELETE FROM produto WHERE codigo = "+ produto.getCodigo() + ";";
		
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
	public boolean update(Produto produto) {
		
		String sql = "UPDATE produto SET descricao = '"+produto.getDescricao()+"',"
				+ " precoAtacado = "+produto.getPrecoAtacado()+", "
				+ " precoVarejo = "+produto.getPrecoVarejo()
																				
				+ " WHERE codigo = "+produto.getCodigo()+";";
		
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
	public Produto selectProduto(String descricao) {
		
		Produto produto = new Produto();
		String sql = "SELECT * FROM produto WHERE descricao='" + descricao + "';";
		
		try {
			stmt = (Statement) con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				produto.setCodigo(rs.getInt("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoAtacado(rs.getFloat("precoAtacado"));
				produto.setPrecoVarejo(rs.getFloat("precoVarejo"));
			}
			
			return produto;

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
	public Set<Produto> selectProdutos() {
		
		Set<Produto> produtos = new HashSet<>();
		Produto produto;
		
		try {
			stmt = (Statement) con.getConnection().createStatement();
			String sql = "SELECT * FROM produto;";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				produto = new Produto();
				
				produto.setCodigo(rs.getInt("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoAtacado(rs.getFloat("precoAtacado"));
				produto.setPrecoVarejo(rs.getFloat("precoVarejo"));
				
				produtos.add(produto);
			}
			
			return produtos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos produtos na base!", "Erro", JOptionPane.ERROR_MESSAGE);
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
//	String sql = "SELECT * FROM tb_Aluno INNER JOIN tb_Pessoa ON tb_Aluno.tb_Pessoa_idPessoa = tb_Pessoa.idPessoa "
//			+ "WHERE nome LIKE '" + nome + "%'";
	@Override
	public Set<Produto> filtroProdutos(String descricao) {
		
		Set<Produto> produtos = new HashSet<>();
		Produto produto;
		
		try {
			stmt = (Statement) con.getConnection().createStatement();
			String sql = "SELECT * FROM produto WHERE descricao LIKE '" + descricao + "%';";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				produto = new Produto();
				
				produto.setCodigo(rs.getInt("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPrecoAtacado(rs.getFloat("precoAtacado"));
				produto.setPrecoVarejo(rs.getFloat("precoVarejo"));
				
				produtos.add(produto);
			}
			
			return produtos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro na busca dos produtos na base!", "Erro", JOptionPane.ERROR_MESSAGE);
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
