package br.com.hamburgueria.service;
import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCFuncionarioDAO;
import br.com.hamburgueria.jdbcinterface.FuncionarioDAO;
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.validacoes.ValidaFuncionario;


public class FuncionarioService {

	public Funcionario buscarFuncionarioPorId(int id) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {			
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			return jdbcFuncionario.buscarPorId(id);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<Funcionario> buscarFuncionarioPorNome(String nome) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			return jdbcFuncionario.buscarPorNome(nome);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void adicionarFuncionario(Funcionario func) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			Crip crip = new Crip();
			func.setSenha(crip.cripto(func.getSenha()));
			func.setFuncionario(1);
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			ValidaFuncionario valida = new ValidaFuncionario();
			valida.funcionario(func);
			jdbcFuncionario.inserir(func);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void deletarFuncionario(int id) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			jdbcFuncionario.deletarFuncionario(id);	
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void atualizarFuncionario(Funcionario func) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			ValidaFuncionario valida = new ValidaFuncionario();
			Crip crip = new Crip();
			func.setSenha(crip.cripto(func.getSenha()));
			valida.funcionario(func);
			jdbcFuncionario.atualizar(func);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public boolean buscarLogin(Funcionario func) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			Crip crip = new Crip();
			func.setSenha(crip.cripto(func.getSenha()));
			return jdbcFuncionario.buscarEmail(func);
		}finally{
			conec.fecharConexao();
		}
	}
}