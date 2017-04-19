package br.com.gfsoft.smartgondula.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import br.com.gfsoft.smartgondula.controller.SmartGondula;
import br.com.gfsoft.smartgondula.model.Lcd;
import br.com.gfsoft.smartgondula.model.TabelaConsulta;

public class ConsultaLcd extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3586729931570034214L;
	private JTable table;
	private SmartGondula smartGondula;
	private Lcd lcd;
	private JTextField txtCodigo;
	private JButton btnFiltrar;

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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de LCD");
		setBounds(100, 100, 1200, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(115, 27, 350, 30);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(30, 35, 75, 14);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 1174, 544);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			//DUPLO CLICK SOBRE LINHA DA TABELA
			public void mouseClicked(MouseEvent e) {
				
				if(e.getClickCount() == 2){
					int codigo = (int) table.getValueAt(table.getSelectedRow(), 0);
					smartGondula = new SmartGondula();
					lcd = new Lcd();
					
					lcd = smartGondula.buscarLcd(codigo);
					
					Principal.LCD.preencheCampos(lcd);
					Principal.LCD.setVisible(true);
					Principal.LCD.alternaBotoes(true);
					Principal.LCD.setTitle("Editar");
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		/* BOTAO FILTRAR */
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());
				preencherTabelaFiltro(codigo);
			}
		});
		btnFiltrar.setBounds(510, 27, 100, 30);
		panel.add(btnFiltrar);
		
		
		preencherTabela();

	}
	
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabela(){
        List<Object> dados = new ArrayList<>();
        List<Lcd> lcds = new ArrayList<>();
        String[] colunas = new String[]{"Código","Rua","Número","Código do Produto"};
        smartGondula = new SmartGondula();
        
        lcds.addAll(smartGondula.listarLcd());
        
        for(Lcd a : lcds){
        	dados.add(new Object[]{a.getCodigo(), a.getRua(), a.getNumero(), a.getCod_produto()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setResizable(true);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabelaFiltro(int codigo){
        List<Object> dados = new ArrayList<>();
        List<Lcd> lcds = new ArrayList<>();
        String[] colunas = new String[]{"Código","Rua","Número","Código do Produto"};
        smartGondula = new SmartGondula();
        
        lcds.addAll(smartGondula.filtrarLcd(codigo));
        
        for(Lcd a : lcds){
        	dados.add(new Object[]{a.getCodigo(), a.getRua(), a.getNumero(), a.getCod_produto()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setResizable(true);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(3).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela

}
