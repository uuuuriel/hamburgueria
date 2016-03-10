package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.objs.Funcionario;

public interface FuncionarioDAO {

	public List<Funcionario> buscarPorNome(String nome);

	public boolean deletarFuncionario(int id);

	public boolean atualizar(Funcionario funcionario);

	public boolean inserir(Funcionario funcionario);
	
	public Funcionario buscarPorId(int id);

	public boolean buscarEmail(Funcionario func);

}
