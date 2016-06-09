package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.auxilia.Permissao;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCClienteDAO;
import br.com.hamburgueria.jdbcinterface.ClienteDAO;
import br.com.hamburgueria.objs.Cliente;
import br.com.hamburgueria.validacoes.ValidaUsuario;

public class ClienteService {
	public Cliente buscarUsuarioPorId(int id) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			return jdbcUsuario.buscarPorId(id);
		} finally {
			conec.fecharConexao();
		}
	}

	public List<Cliente> buscarUsuarioPorNome(String nome) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			return jdbcUsuario.buscarPorNome(nome);
		} finally {
			conec.fecharConexao();
		}
	}

	public void adicionarUsuario(Cliente user) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			ValidaUsuario valida = new ValidaUsuario();
			valida.usuario(user);
			if(!validaFone(user.getTelefone(), 0)){
				jdbcUsuario.inserir(user);
			}else{
				throw new HamburgueriaException("Telefone já existente!");
			}
		} finally {
			conec.fecharConexao();
		}
	}

	public void deletarUsuario(int id, int codi) throws HamburgueriaException {
		Permissao perm = new Permissao();
		perm.checkPermission("func", codi);
		Conexao conec = new Conexao();
		try {
			Cliente user = new Cliente();
			user.setCod(id);
			user.setAtivo(0);
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			jdbcUsuario.deletarUsuario(user);
		} finally {
			conec.fecharConexao();
		}
	}

	public void atualizarUsuario(Cliente user, int codi) throws HamburgueriaException {
		Permissao perm = new Permissao();
		perm.checkPermission("log", codi);
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			ValidaUsuario valida = new ValidaUsuario();
			valida.usuario(user);
			if(!validaFone(user.getTelefone(), user.getCod())){
				jdbcUsuario.atualizar(user);
			}else{
				throw new HamburgueriaException("Telefone já existente!");
			}
		} finally {
			conec.fecharConexao();
		}
	}
	
	public boolean validaFone(double numero, int cod)throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcCliente = new JDBCClienteDAO(conexao);
			return jdbcCliente.validaFone(numero, cod);
		}catch(Exception e){
			throw new HamburgueriaException("Erro ao exibir pedidos.");
		}finally{
			conec.fecharConexao();
		}		
	}
}