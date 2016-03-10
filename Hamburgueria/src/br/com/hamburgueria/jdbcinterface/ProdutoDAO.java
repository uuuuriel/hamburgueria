package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.objs.Produto;

public interface ProdutoDAO {

	public Produto buscarId(int id);

	public List<Produto> buscarNome(String nome);

	public boolean inserir(Produto prod);

	public boolean deletar(int cod);

	public boolean atualizar(Produto prod);

}
