package br.com.gfsoft.smartgondula.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Principal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5431461428230621869L;
	private JDesktopPane desktopPane;
	public static CadUsuario USUARIO;
	public static ConsultaUsuario CONSULTAUSUARIO;
	public static CadProduto PRODUTO;
	public static ConsultaProduto CONSULTAPRODUTO;
	public static CadLcd LCD;
	public static ConsultaLcd CONSULTALCD;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
			System.out.println(e);
		} catch (ClassNotFoundException e) {
		    // handle exception
			System.out.println(e);
		} catch (InstantiationException e) {
		    // handle exception
			System.out.println(e);
		} catch (IllegalAccessException e) {
		    // handle exception
			System.out.println(e);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("SmartGondula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 720);
		setExtendedState(MAXIMIZED_BOTH);
		//setIconImage(new ImageIcon("icon\\sisAcademic64.png").getImage());
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JPanel panelInicial = new JPanel();
		panelInicial.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelInicial.setBounds(10, 11, 1342, 644);
		desktopPane.add(panelInicial);
		panelInicial.setLayout(null);
	
	
	
		/**
		 * Instanciando todas as telas e deixando invisiveis
		 */
		USUARIO = new CadUsuario();
		PRODUTO = new CadProduto();
		LCD = new CadLcd();
		CONSULTAUSUARIO = new ConsultaUsuario();
		CONSULTAPRODUTO = new ConsultaProduto();
		CONSULTALCD = new ConsultaLcd();
		
		desktopPane.add(USUARIO);
		desktopPane.add(PRODUTO);
		desktopPane.add(LCD);
		desktopPane.add(CONSULTAUSUARIO);
		desktopPane.add(CONSULTAPRODUTO);
		desktopPane.add(CONSULTALCD);
		
		try {
			USUARIO.setMaximum(true);
			PRODUTO.setMaximum(true);
			LCD.setMaximum(true);
			CONSULTAUSUARIO.setMaximum(true);
			CONSULTAPRODUTO.setMaximum(true);
			CONSULTALCD.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		USUARIO.setVisible(false);
		PRODUTO.setVisible(false);
		LCD.setVisible(false);
		CONSULTAUSUARIO.setVisible(false);
		CONSULTAPRODUTO.setVisible(false);
		CONSULTALCD.setVisible(false);
		// =======================================================

	}
	
}
