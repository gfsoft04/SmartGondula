package br.com.gfsoft.smartgondula.model;

public class Lcd {
	private int codigo;
	private String rua;
	private int numero;
	private int cod_produto;
	

	/**
	 * Metodos Getters e Setters
	 */
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getCod_produto() {
		return cod_produto;
	}
	
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	
}
