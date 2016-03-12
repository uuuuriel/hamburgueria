package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Funcionario;

public interface FuncionarioDAO {

	public List<Funcionario> buscarPorNome(String nome) throws HamburgueriaException;

	public boolean deletarFuncionario(int id) throws HamburgueriaException;

	public boolean atualizar(Funcionario funcionario) throws HamburgueriaException;

	public boolean inserir(Funcionario funcionario) throws HamburgueriaException;
	
	public Funcionario buscarPorId(int id) throws HamburgueriaException;

	public boolean buscarEmail(Funcionario func) throws HamburgueriaException;

}
