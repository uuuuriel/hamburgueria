package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Cliente;

public interface ClienteDAO {

	public List<Cliente> buscarPorNome(String nome) throws HamburgueriaException;

	public void deletarUsuario(Cliente user) throws HamburgueriaException;

	public void atualizar(Cliente user)  throws HamburgueriaException;

	public Cliente inserir(Cliente user) throws HamburgueriaException;
	
	public Cliente buscarPorId(int id)  throws HamburgueriaException;

	public boolean buscarEmail(Cliente user)  throws HamburgueriaException;

	Cliente inserirPreCadastro(Cliente user) throws HamburgueriaException;

}
