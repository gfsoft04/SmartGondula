package br.com.gfsoft.smartgondula.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import br.com.gfsoft.smartgondula.model.Lcd;

public class PersistenceLcd implements IPersistenceLcd {

	private static Statement stmt;
	private static ResultSet rs;
	private static Conexao con = new Conexao();
	
	@Override
	public boolean insert(Lcd lcd) {
		String sql = "INSERT INTO lcd(codigo, rua, numero, codProduto) "
				+ "VALUES("+ lcd.getCodigo() +","
						+ "'"+ lcd.getRua() +"',"
						+ lcd.getNumero() +","
						+ lcd.getCod_produto() + ");";
		
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
	public boolean delete(Lcd lcd) {
		String sql;
		
		sql = "DELETE FROM lcd WHERE codigo = "+ lcd.getCodigo() + ";";
		
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
	public boolean update(Lcd lcd) {
		String sql = "UPDATE lcd SET rua = '"+lcd.getRua()+"', "
				+ "numero = "+lcd.getNumero()+", "
				+ "codProduto = "+lcd.getCod_produto()
																				
				+ " WHERE codigo = "+lcd.getCodigo()+";";
		
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
	public Lcd selectLcd(int codigo) {
		Lcd lcd = new Lcd();
		String sql = "SELECT * FROM lcd WHERE codigo=" + codigo + ";";
		
		try {
			stmt = (Statement) con.getConnection().prepareStatement(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lcd.setCodigo(rs.getInt("codigo"));
				lcd.setRua(rs.getString("rua"));
				lcd.setNumero(rs.getInt("numero"));
				lcd.setCod_produto(rs.getInt("codProduto"));
			}
			
			return lcd;

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
	public Set<Lcd> selectLcds() {
		Set<Lcd> lcds = new HashSet<>();
		Lcd lcd;
		
		try {
			stmt = (Statement) con.getConnection().createStatement();
			String sql = "SELECT * FROM lcd;";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				lcd = new Lcd();
				
				lcd.setCodigo(rs.getInt("codigo"));
				lcd.setRua(rs.getString("rua"));
				lcd.setNumero(rs.getInt("numero"));
				lcd.setCod_produto(rs.getInt("codProduto"));
				
				lcds.add(lcd);
			}
			
			return lcds;

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
