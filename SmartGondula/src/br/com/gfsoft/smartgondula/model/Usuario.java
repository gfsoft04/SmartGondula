package br.com.gfsoft.smartgondula.model;

public class Usuario {
	private int matricula;
	private String nome;
	private String senha;
	
	
	/**
	 * Metodos Getters e Setters
	 */
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
