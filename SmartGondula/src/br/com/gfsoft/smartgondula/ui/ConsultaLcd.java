package br.com.gfsoft.smartgondula.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultaLcd extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3586729931570034214L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLcd frame = new ConsultaLcd();
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
	public ConsultaLcd() {
		setBounds(100, 100, 450, 300);

	}

}
