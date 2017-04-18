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
import br.com.gfsoft.smartgondula.model.TabelaConsulta;
import br.com.gfsoft.smartgondula.model.Usuario;

public class ConsultaUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 394472469301792401L;
	private JTable table;
	private SmartGondula smartGondula;
	private Usuario usuario;
	private JTextField txtNome;
	private JButton btnFiltrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Usuário");
		setBounds(100, 100, 1200, 670);
		setLocation(0, 0);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setBounds(115, 27, 350, 30);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
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
					String nome = (String) table.getValueAt(table.getSelectedRow(), 1);
					smartGondula = new SmartGondula();
					usuario = new Usuario();
					
					//try {
						usuario = smartGondula.buscarUsuario(nome);
						
						Principal.USUARIO.preencheCampos(usuario);
						Principal.USUARIO.setVisible(true);
						Principal.USUARIO.setTitle("Editar");
//					} catch (UsuarioNaoEncontradoException ex) {
//						// Excecao para usuario nao encontrado
//						JOptionPane.showMessageDialog(null, "Usuario Nao Cadastrado no Sistema!", "Erro", JOptionPane.ERROR_MESSAGE);
//					}
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		/* BOTAO FILTRAR */
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				
				preencherTabelaFiltro(nome);
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
        List<Usuario> usuario = new ArrayList<>();
        String[] colunas = new String[]{"Matricula","Nome"};
        smartGondula = new SmartGondula();
        
        usuario.addAll(smartGondula.listarUsuarios());
        
        for(Usuario a : usuario){
        	dados.add(new Object[]{a.getMatricula(), a.getNome()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
	/**
	 * Metodo para preencher a tabela
	 * 
	 */
	public void preencherTabelaFiltro(String nome){
        List<Object> dados = new ArrayList<>();
        List<Usuario> usuario = new ArrayList<>();
        String[] colunas = new String[]{"Código","Descrição","Valor"};
        smartGondula = new SmartGondula();
        
        usuario.add(smartGondula.buscarUsuario(nome));
        
        for(Usuario a : usuario){
        	dados.add(new Object[]{a.getMatricula(), a.getNome()});
        }
        
        TabelaConsulta modelo = new TabelaConsulta(dados, colunas);
        table.setModel(modelo);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(0).setResizable(true);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setResizable(true);
        table.getColumnModel().getColumn(2).setPreferredWidth(80);
        table.getColumnModel().getColumn(2).setResizable(true);
        
        table.getTableHeader().setReorderingAllowed(true);
        //jTableConsulta.getAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        
    } //Fim do Metodo preencherTabela
	
}
