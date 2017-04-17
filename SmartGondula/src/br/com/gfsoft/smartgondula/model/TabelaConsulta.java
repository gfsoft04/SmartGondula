package br.com.gfsoft.smartgondula.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaConsulta extends AbstractTableModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5229651418060080633L;
	private List<Object> linhas = null;
    private String[] colunas = null;

    public TabelaConsulta(List<Object> lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    public List<Object> getLinhas() {
        return linhas;
    }
    public void setLinhas(List<Object> linhas) {
        this.linhas = linhas;
    }
    public String[] getColunas() {
        return colunas;
    }
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    public int getRowCount(){
        return linhas.size();
    }
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    public Object getValueAt(int numLin, int numCol){
        Object[] linhas = (Object[])getLinhas().get(numLin);
        return linhas[numCol];
    }
}
