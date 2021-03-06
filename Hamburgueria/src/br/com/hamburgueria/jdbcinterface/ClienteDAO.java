package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Cliente;
import br.com.hamburgueria.objs.ClienteNovo;

public interface ClienteDAO {

	public List<Cliente> buscarPorNome(String nome) throws HamburgueriaException;

	public void deletarUsuario(Cliente user) throws HamburgueriaException;

	public void atualizar(Cliente user)  throws HamburgueriaException;

	public Cliente inserir(Cliente user) throws HamburgueriaException;
	
	public Cliente buscarPorId(int id)  throws HamburgueriaException;

	public boolean buscarEmail(Cliente user)  throws HamburgueriaException;

	public ClienteNovo inserirPreCadastro(ClienteNovo user) throws HamburgueriaException;
	
	public boolean validaFone(double numero, int cod) throws HamburgueriaException;

}
