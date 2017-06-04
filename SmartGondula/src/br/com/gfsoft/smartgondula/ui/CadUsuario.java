package br.com.gfsoft.smartgondula.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.smartgondula.controller.SmartGondula;
import br.com.gfsoft.smartgondula.model.Usuario;
import javax.swing.ImageIcon;

public class CadUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6320760660478827222L;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JPasswordField ptxtSenha;
	
	private Usuario usuario;
	private SmartGondula smartGondula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadUsuario frame = new CadUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Usuário");
		setBounds(100, 100, 1205, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 6, 534, 233);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDescrio = new JLabel("Nome:");
		lblDescrio.setBounds(23, 48, 70, 16);
		panel_1.add(lblDescrio);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 39, 380, 35);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCdigo = new JLabel("Matricula:");
		lblCdigo.setBounds(23, 100, 70, 16);
		panel_1.add(lblCdigo);
		
		JLabel lblValor = new JLabel("Senha:");
		lblValor.setBounds(23, 147, 57, 16);
		panel_1.add(lblValor);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(97, 91, 225, 35);
		panel_1.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		ptxtSenha = new JPasswordField();
		ptxtSenha.setBounds(97, 138, 155, 35);
		panel_1.add(ptxtSenha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(6, 266, 534, 81);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		/** BOTAO CANCELAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CadUsuario.class.getResource("/icon/cancel.png")));
		btnCancelar.setBounds(199, 18, 125, 45);
		panel_2.add(btnCancelar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cancelar.png")));
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limparCampos();
				setVisible(false);
			
			}
		});
		
		/** BOTAO CADASTRAR **/
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(CadUsuario.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setBounds(376, 18, 125, 45);
		panel_2.add(btnCadastrar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtMatricula.getText().equals("") || txtNome.getText().equals("") || ptxtSenha.getPassword().length < 1) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				usuario = new Usuario();
				smartGondula = new SmartGondula();
				
				usuario.setMatricula(Long.parseLong(txtMatricula.getText()));
				usuario.setNome(txtNome.getText());
				usuario.setSenha(ptxtSenha.getPassword().toString());
				
				if(smartGondula.cadastrarUsuario(usuario)){
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				}
			
			}
		});
				
		/** BOTAO DELETAR **/
		btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(CadUsuario.class.getResource("/icon/del.png")));
		//btnDeletar.setIcon(new ImageIcon(CadAluno.class.getResource("/icon/del.png")));
		btnDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeletar.setBounds(30, 18, 125, 45);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				usuario = new Usuario();
				smartGondula = new SmartGondula();
				
				usuario = smartGondula.buscarUsuario(nome);
				
				//Confirmacao do usuario
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
					if(smartGondula.deletarUsuario(usuario)){
						JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
						Principal.CONSULTAPRODUTO.preencherTabela();
					}
				} 
				
			}
		});
		
		/** BOTAO ALTERAR **/
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(CadUsuario.class.getResource("/icon/cadastrar.png")));
		btnAlterar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(376, 18, 125, 45);
		panel_2.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtMatricula.getText().equals("") || txtNome.getText().equals("") || ptxtSenha.getPassword().length < 1) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				usuario = new Usuario();
				smartGondula = new SmartGondula();
				
				usuario.setMatricula(Long.parseLong(txtMatricula.getText()));
				usuario.setNome(txtNome.getText());
				usuario.setSenha(ptxtSenha.getPassword().toString());
				
				if(smartGondula.cadastrarUsuario(usuario)){
					JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!", "Atencao", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
					Principal.CONSULTAPRODUTO.preencherTabela();
				}
				
			}
		});
		
	}
	
	/**
	 * Metodo para alternar botoes habilitados e desabilitados
	 * true = habilita botao alterar e deletar
	 * flase = habilita botao cadastrar
	 */
	public void alternaBotoes(boolean flag){
		btnCadastrar.setVisible(!flag);
		btnAlterar.setVisible(flag);
		btnDeletar.setVisible(flag);
	}	

	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Usuario usuario){
			
		txtMatricula.setText(usuario.getMatricula()+"");
		txtNome.setText(usuario.getNome());
		
	}
	
	/**
	 * Metodo para limpar campos
	 */	
	public void limparCampos(){
		txtMatricula.setText("");
		txtNome.setText("");
		ptxtSenha.setText("");
	}

}
