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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.com.gfsoft.smartgondula.controller.SmartGondula;
import br.com.gfsoft.smartgondula.model.Produto;
import br.com.gfsoft.smartgondula.util.QrCode;
import javax.swing.ImageIcon;

public class CadProduto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8453356691067985291L;
	private JTextField txtDescricao;
	private JTextField txtCodigo;
	private JTextField txtPrecoAtacado;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnDeletar;
	private JButton btnAlterar;
	
	private Produto produto;
	private SmartGondula smartGondula;
	private JTextField txtPrecoVarejo;

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
		
		JLabel lblValor = new JLabel("Pre\u00E7o por Atacado:");
		lblValor.setBounds(23, 147, 123, 16);
		panel_1.add(lblValor);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(97, 91, 225, 35);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtPrecoAtacado = new JTextField();
		txtPrecoAtacado.setBounds(158, 138, 130, 35);
		panel_1.add(txtPrecoAtacado);
		txtPrecoAtacado.setColumns(10);
		
		txtPrecoVarejo = new JTextField();
		txtPrecoVarejo.setColumns(10);
		txtPrecoVarejo.setBounds(158, 175, 130, 35);
		panel_1.add(txtPrecoVarejo);
		
		JLabel lblPreoPorVarejo = new JLabel("Pre\u00E7o por Varejo:");
		lblPreoPorVarejo.setBounds(23, 184, 123, 16);
		panel_1.add(lblPreoPorVarejo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(6, 266, 534, 81);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		/** BOTAO CANCELAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cancel.png")));
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
		btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setBounds(376, 18, 125, 45);
		panel_2.add(btnCadastrar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtDescricao.getText().equals("") || txtCodigo.getText().equals("") || txtPrecoAtacado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				produto = new Produto();
				smartGondula = new SmartGondula();
				
				produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
				produto.setDescricao(txtDescricao.getText());
				produto.setPrecoAtacado(Float.parseFloat(txtPrecoAtacado.getText()));
				produto.setPrecoVarejo(Float.parseFloat(txtPrecoVarejo.getText()));
				
				if(smartGondula.cadastrarProduto(produto)){
					// GERACAO DO QRCODE
					QrCode qrCod = new QrCode();
					//*********************** FALTA ACRESCENTAR O VALOR POR ATACADO **********************************
					qrCod.gerarQrCode(produto.getCodigo()+"", produto.getDescricao() + ";" + produto.getPrecoVarejo());
					
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
					Principal.CONSULTAPRODUTO.preencherTabela();
				}
			
			}
		});
				
		/** BOTAO DELETAR **/
		btnDeletar = new JButton("Deletar");
		btnDeletar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/del.png")));
		btnDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeletar.setBounds(30, 18, 125, 45);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_2.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String descricao = txtDescricao.getText();
				produto = new Produto();
				smartGondula = new SmartGondula();
				
				produto = smartGondula.buscarProduto(descricao);
				
				//Confirmacao do usuario
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
					if(smartGondula.deletarProduto(produto)){
						JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
						Principal.CONSULTAPRODUTO.preencherTabela();
					}
				} 
				
			}
		});
		
		/** BOTAO ALTERAR **/
		btnAlterar = new JButton("Alterar");
		btnAlterar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnAlterar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(376, 18, 125, 45);
		panel_2.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtDescricao.getText().equals("") || txtCodigo.getText().equals("") || txtPrecoAtacado.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				produto = new Produto();
				smartGondula = new SmartGondula();
				
				produto.setCodigo(Integer.parseInt(txtCodigo.getText()));
				produto.setDescricao(txtDescricao.getText());
				produto.setPrecoAtacado(Float.parseFloat(txtPrecoAtacado.getText()));
				produto.setPrecoVarejo(Float.parseFloat(txtPrecoVarejo.getText()));
				
				if(smartGondula.atualizarProduto(produto)){
					// GERACAO DO QRCODE
					QrCode qrCod = new QrCode();
					//*********************** FALTA ACRESCENTAR O VALOR POR ATACADO **********************************
					qrCod.gerarQrCode(produto.getCodigo()+"", produto.getDescricao() + ";" + produto.getPrecoVarejo());
					
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
	public void preencheCampos(Produto produto){
			
		txtDescricao.setText(produto.getDescricao());
		txtCodigo.setText(produto.getCodigo()+"");
		txtPrecoAtacado.setText(produto.getPrecoAtacado()+"");
		txtPrecoVarejo.setText(produto.getPrecoVarejo()+"");
		
	}
	
	/**
	 * Metodo para limpar campos
	 */	
	public void limparCampos(){
		txtDescricao.setText("");
		txtCodigo.setText("");
		txtPrecoAtacado.setText("");
		txtPrecoVarejo.setText("");
	}
}
