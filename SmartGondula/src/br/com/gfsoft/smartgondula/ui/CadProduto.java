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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CadProduto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8453356691067985291L;
	private JTextField txtDescricao;
	private JTextField txtCodigo;
	private JTextField txtValor;
	private JButton btnCadastrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadProduto frame = new CadProduto();
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
	public CadProduto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de Produto");
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
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(23, 48, 70, 16);
		panel_1.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(97, 39, 380, 35);
		panel_1.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(23, 100, 70, 16);
		panel_1.add(lblCdigo);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(23, 147, 57, 16);
		panel_1.add(lblValor);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(97, 91, 225, 35);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(97, 138, 130, 35);
		panel_1.add(txtValor);
		txtValor.setColumns(10);
		
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
}
