package br.com.gfsoft.smartgondula.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CadLcd extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7620690799007594615L;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(88, 28, 255, 35);
		panel_1.add(textField);
		textField.setColumns(10);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E"}));
		comboBox.setBounds(102, 34, 165, 35);
		panel_2.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 79, 165, 35);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(552, 228, 100, 35);
		panel.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(680, 228, 100, 35);
		panel.add(btnCadastrar);

	}
}
