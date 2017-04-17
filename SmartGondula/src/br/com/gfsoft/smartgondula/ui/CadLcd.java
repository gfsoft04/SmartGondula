package br.com.gfsoft.smartgondula.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CadLcd extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7620690799007594615L;

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
		setBounds(100, 100, 450, 300);

	}

}
