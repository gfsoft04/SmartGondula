package br.com.gfsoft.smartgondula.persistence;

import java.util.Set;

import br.com.gfsoft.smartgondula.model.Produto;

public interface IPersistenceProduto {
	
	public boolean insert(Produto produto);
	public boolean delete(Produto produto);
	public boolean update(Produto produto);
	public Produto selectProduto(String descricao);
	public Set<Produto> selectProdutos();
	Set<Produto> filtroProdutos(String descricao);
	
}
