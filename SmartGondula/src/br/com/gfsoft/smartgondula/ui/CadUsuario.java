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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.smartgondula.model.Usuario;

public class CadUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6320760660478827222L;
	private JTextField txtNome;
	private JTextField txtMatricula;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JPasswordField ptxtSenha;

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
		
		/** BOTAO CADASTRAR **/
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(415, 302, 125, 45);
		panel.add(btnCadastrar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				/* ADICIONAR AÇÃO DO BOTÃO */
			
			}
		});
		
		/** BOTAO CADASTRAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(266, 302, 125, 45);
		panel.add(btnCancelar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cancelar.png")));
		btnCancelar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				/* ADICIONAR AÇÃO DO BOTÃO */
			
			}
		});
		
	}

	/**
	 * Metodo que recebe um objeto e preenche os campos
	 */
	public void preencheCampos(Usuario usuario){
			
		txtMatricula.setText(usuario.getMatricula()+"");
		txtNome.setText(usuario.getNome());
		
	}

}
