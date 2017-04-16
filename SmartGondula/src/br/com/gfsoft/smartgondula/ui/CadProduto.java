package br.com.gfsoft.smartgondula.ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CadProduto extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
