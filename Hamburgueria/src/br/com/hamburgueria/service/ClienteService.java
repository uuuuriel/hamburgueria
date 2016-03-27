package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoResultException;
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
			jdbcUsuario.inserir(user);
		} finally {
			conec.fecharConexao();
		}
	}

	public void deletarUsuario(int id) throws HamburgueriaException {
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

	public void atualizarUsuario(Cliente user) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			ValidaUsuario valida = new ValidaUsuario();
			valida.usuario(user);
			jdbcUsuario.atualizar(user);
		} finally {
			conec.fecharConexao();
		}
	}

}