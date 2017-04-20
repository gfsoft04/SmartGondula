package br.com.gfsoft.smartgondula.model;

public class Produto {
	private int codigo;
	private String descricao;
	private float precoVarejo;
	private float precoAtacado;
		
	
	/**
	 * Metodos Getters e Setters
	 */
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getPrecoVarejo() {
		return precoVarejo;
	}

	public void setPrecoVarejo(float precoVarejo) {
		this.precoVarejo = precoVarejo;
	}

	public float getPrecoAtacado() {
		return precoAtacado;
	}

	public void setPrecoAtacado(float precoAtacado) {
		this.precoAtacado = precoAtacado;
	}
	
	
	
}
