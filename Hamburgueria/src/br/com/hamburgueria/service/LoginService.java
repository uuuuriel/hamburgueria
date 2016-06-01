package br.com.hamburgueria.service;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.CripException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoResultException;
import br.com.hamburgueria.jdbc.JDBCFuncionarioDAO;
import br.com.hamburgueria.jdbc.JDBCClienteDAO;
import br.com.hamburgueria.jdbcinterface.FuncionarioDAO;
import br.com.hamburgueria.jdbcinterface.ClienteDAO;
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Cliente;

public class LoginService {
	private HttpServletRequest request;

	public LoginService(HttpServletRequest req) {
		this.request = req;
	}

	public boolean buscarLoginUsuario(Cliente user)throws NoResultException, NoSuchAlgorithmException, CripException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			return jdbcUsuario.buscarEmail(user);
		} catch (Exception e) {
			return false;
		} finally {
			conec.fecharConexao();
		}
	}
	public boolean buscarLoginFuncionario(Funcionario func)throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			FuncionarioDAO jdbcFuncionario = new JDBCFuncionarioDAO(conexao);
			Crip crip = new Crip();
			func.setSenha(crip.cripto(func.getSenha()));
			return jdbcFuncionario.buscarEmail(func);
		} catch (Exception e) {
			return false;
		} finally {
			conec.fecharConexao();
		}
	}

}
