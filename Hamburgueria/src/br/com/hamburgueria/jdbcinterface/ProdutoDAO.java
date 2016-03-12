package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Produto;

public interface ProdutoDAO {

	public Produto buscarId(int id) throws HamburgueriaException;

	public List<Produto> buscarNome(String nome) throws HamburgueriaException;

	public boolean inserir(Produto prod) throws HamburgueriaException;

	public boolean deletar(int cod) throws HamburgueriaException;

	public boolean atualizar(Produto prod) throws HamburgueriaException;

}
