package br.com.gfsoft.smartgondula.service;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Produto;
import br.com.gfsoft.smartgondula.persistence.IPersistenceProduto;
import br.com.gfsoft.smartgondula.persistence.PersistenceProduto;

public class ProdutoService extends Service{
	
	private IPersistenceProduto persistencia;
	
	public ProdutoService(){
		
		persistencia = new PersistenceProduto();
		
	}

	public boolean cadastrar(Produto produto){
		return persistencia.insert(produto);
	}
	
	public boolean deletar(Produto produto){
		return persistencia.delete(produto);
	}
	
	public boolean atualizar(Produto produto){
		return persistencia.update(produto);
	}
	
	public Produto buscar(String descricao) {
		return persistencia.selectProduto(descricao);
	}
	
	public Set<Produto> listar(){
		return persistencia.selectProdutos();
	}
	
	public Set<Produto> filtrar(String descricao){
		return persistencia.filtroProdutos(descricao);
	}
	
}
