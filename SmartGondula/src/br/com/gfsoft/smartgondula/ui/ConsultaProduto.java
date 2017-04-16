package br.com.gfsoft.smartgondula.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultaProduto extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProduto frame = new ConsultaProduto();
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
	public ConsultaProduto() {
		setBounds(100, 100, 450, 300);

	}

}
