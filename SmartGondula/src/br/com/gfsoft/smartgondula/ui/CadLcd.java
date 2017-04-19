package br.com.gfsoft.smartgondula.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import br.com.gfsoft.smartgondula.model.Lcd;

public class CadLcd extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7620690799007594615L;
	private JTextField txtCodigo;
	private JTextField txtNumero;
	private JTextField txtCodProduto;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	private JButton btnDeletar;
	private JButton btnBuscaProduto;
	private JComboBox comboBoxRua;
	private JPanel panel_3;
	
	private Lcd lcd;
	private SmartGondula smartGondula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadLcd frame = new CadLcd();
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
	public CadLcd() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Cadastro de LCD");
		setBounds(100, 100, 1205, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 24, 412, 160);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(23, 37, 66, 16);
		panel_1.add(lblCdigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(88, 28, 255, 35);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto:");
		lblCdigoDoProduto.setBounds(23, 100, 130, 16);
		panel_1.add(lblCdigoDoProduto);
		
		txtCodProduto = new JTextField();
		txtCodProduto.setBounds(152, 91, 191, 35);
		panel_1.add(txtCodProduto);
		txtCodProduto.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Localiza\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(445, 24, 335, 160);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(19, 43, 71, 16);
		panel_2.add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(19, 88, 71, 16);
		panel_2.add(lblNmero);
		
		comboBoxRua = new JComboBox();
		comboBoxRua.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E"}));
		comboBoxRua.setBounds(102, 34, 165, 35);
		panel_2.add(comboBoxRua);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(102, 79, 165, 35);
		panel_2.add(txtNumero);
		txtNumero.setColumns(10);
		
		btnBuscaProduto = new JButton("...");
		btnBuscaProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**  BOTAO CHAMARA UM JDIALOG QUE LISTA OS PRODUTOS  **/
				
			}
		});
		btnBuscaProduto.setBounds(355, 92, 32, 32);
		panel_1.add(btnBuscaProduto);		
		
		JPanel panel_3;
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(246, 207, 534, 81);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		/** BOTAO CANCELAR **/
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(199, 18, 125, 45);
		panel_3.add(btnCancelar);
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
		btnCadastrar.setBounds(376, 18, 125, 45);
		panel_3.add(btnCadastrar);
		//btnCadastrar.setIcon(new ImageIcon(CadProduto.class.getResource("/icon/cadastrar.png")));
		btnCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtCodigo.getText().equals("") || txtCodProduto.getText().equals("") || txtNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				lcd = new Lcd();
				smartGondula = new SmartGondula();
				
				lcd.setCodigo(Integer.parseInt(txtCodigo.getText()));
				lcd.setRua(comboBoxRua.getSelectedItem().toString());
				lcd.setNumero(Integer.parseInt(txtNumero.getText()));
				lcd.setCod_produto(Integer.parseInt(txtCodProduto.getText()));
				
				if(smartGondula.cadastrarLcd(lcd)){
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
					limparCampos();
				}
			
			}
		});
				
		/** BOTAO DELETAR **/
		btnDeletar = new JButton("Deletar");
		//btnDeletar.setIcon(new ImageIcon(CadAluno.class.getResource("/icon/del.png")));
		btnDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeletar.setBounds(30, 18, 125, 45);
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int codigo = Integer.parseInt(txtCodigo.getText());
				lcd = new Lcd();
				smartGondula = new SmartGondula();
				
				lcd = smartGondula.buscarLcd(codigo);
				
				//Confirmacao do usuario
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "Confirmação", JOptionPane.WARNING_MESSAGE) == 0){
					if(smartGondula.deletarLcd(lcd)){
						JOptionPane.showMessageDialog(null, "Exclusão efetuada com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
						limparCampos();
						Principal.CONSULTAPRODUTO.preencherTabela();
					}
				} 
				
			}
		});
		
		/** BOTAO ALTERAR **/
		btnAlterar = new JButton("Alterar");
		//btnAlterar.setIcon(new ImageIcon(CadAluno.class.getResource("/icon/cadastrar.png")));
		btnAlterar.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAlterar.setBounds(376, 18, 125, 45);
		panel_3.add(btnAlterar);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//VERIFICAR OS CAMPOS OBRIGATORIOS PREENCHIDOS
				if(txtCodigo.getText().equals("") || txtCodProduto.getText().equals("") || txtNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Campos Obrigatorios em Branco!", "Erro", JOptionPane.ERROR_MESSAGE);
					return ;					
				}
				
				lcd = new Lcd();
				smartGondula = new SmartGondula();
				
				lcd.setCodigo(Integer.parseInt(txtCodigo.getText()));
				lcd.setRua(comboBoxRua.getSelectedItem().toString());
				lcd.setNumero(Integer.parseInt(txtNumero.getText()));
				lcd.setCod_produto(Integer.parseInt(txtCodProduto.getText()));
				
				if(smartGondula.atualizarLcd(lcd)){
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
	public void preencheCampos(Lcd lcd){
			
		txtCodigo.setText(lcd.getCodigo()+"");
		txtCodProduto.setText(lcd.getCod_produto()+"");
		txtNumero.setText(lcd.getNumero()+"");
		//FALTA A PREENCHER O COMBOBOX DA RUA
		
	}
	
	/**
	 * Metodo para limpar campos
	 */	
	public void limparCampos(){
		txtCodProduto.setText("");
		txtCodigo.setText("");
		txtNumero.setText("");
	}

}
