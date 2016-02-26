package br.com.hamburgueria.service;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCUsuarioDAO;
import br.com.hamburgueria.jdbcinterface.UsuarioDAO;
import br.com.hamburgueria.objs.Usuario;

public class LoginService {
	private HttpServletRequest request;

	public LoginService(HttpServletRequest req) {
		this.request = req;
	}

	public boolean buscarLogin(Usuario user, HttpServletRequest request)
			throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			return jdbcUsuario.buscarEmail(user, request);
		} catch (HamburgueriaException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		} finally {
			conec.fecharConexao();
		}
	}

}
