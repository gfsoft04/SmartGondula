package br.com.gfsoft.smartgondula.controller;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Lcd;
import br.com.gfsoft.smartgondula.model.Produto;
import br.com.gfsoft.smartgondula.model.Usuario;
import br.com.gfsoft.smartgondula.service.LcdService;
import br.com.gfsoft.smartgondula.service.ProdutoService;
import br.com.gfsoft.smartgondula.service.UsuarioService;

public class SmartGondula {
	
	UsuarioService usuarioService;
	ProdutoService produtoService;
	LcdService lcdService;
	
	public SmartGondula(){
		this.usuarioService = new UsuarioService();
		this.produtoService = new ProdutoService();
		this.lcdService = new LcdService();
	}
	
	//-------------Metodos do Usuario------------------------
	
	public boolean cadastrarUsuario(Usuario usuario){
		return usuarioService.cadastrar(usuario);
	}
	
	public boolean deletarUsuario(Usuario usuario){
		return usuarioService.deletar(usuario);
	}
	
	public boolean atualizarUsuario(Usuario usuario){
		return usuarioService.atualizar(usuario);
	}
	
	public Usuario buscarUsuario(String nome){
		return usuarioService.buscar(nome);
	}
	
	public Set<Usuario> listarUsuarios(){
		return usuarioService.listar();
	}
	
	//-------------Metodos do Produto------------------------
	
	public boolean cadastrarProduto(Produto produto){
		return produtoService.cadastrar(produto);
	}
	
	public boolean deletarProduto(Produto produto){
		return produtoService.deletar(produto);
	}
	
	public boolean atualizarProduto(Produto produto){
		return produtoService.atualizar(produto);
	}
	
	public Produto buscarProduto(String descricao){
		return produtoService.buscar(descricao);
	}
	
	public Set<Produto> listarProdutos(){
		return produtoService.listar();
	}
	
	//-------------Metodos do LCD------------------------
	
	public boolean cadastrarLcd(Lcd lcd){
		return lcdService.cadastrar(lcd);
	}
	
	public boolean deletarLcd(Lcd lcd){
		return lcdService.deletar(lcd);
	}
	
	public boolean atualizarLcd(Lcd lcd){
		return lcdService.atualizar(lcd);
	}
	
	public Lcd buscarLcd(int codigo){
		return lcdService.buscar(codigo);
	}
	
	public Set<Lcd> listarLcd(){
		return lcdService.listar();
	}

}
