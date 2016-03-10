package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.auxilia.Crip;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoResultException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.jdbc.JDBCUsuarioDAO;
import br.com.hamburgueria.jdbcinterface.UsuarioDAO;
import br.com.hamburgueria.objs.Usuario;
import br.com.hamburgueria.validacoes.Valida;

public class UsuarioService {
	public Usuario buscarUsuarioPorId(int id) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			return jdbcUsuario.buscarPorId(id);
		} catch (Exception e) {
			throw e;
		} finally {
			conec.fecharConexao();
		}
	}

	public List<Usuario> buscarUsuarioPorNome(String nome) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			return jdbcUsuario.buscarPorNome(nome);
		} catch (Exception e) {
			throw e;
		} finally {
			conec.fecharConexao();
		}
	}

	public void adicionarUsuario(Usuario user) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			Valida valida = new Valida();
			if (valida.usuario(user)) {
				jdbcUsuario.inserir(user);
			} else {
				throw new NoValueException();
			};
		} catch (NoValueException e) {
			throw e;
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			conec.fecharConexao();
		}
	}

	public void deletarUsuario(int id) throws HamburgueriaException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			jdbcUsuario.deletarUsuario(id);
		} catch (Exception e) {
			throw e;
		} finally {
			conec.fecharConexao();
		}
	}

	public void atualizarUsuario(Usuario user) throws NoValueException {
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			Crip crip = new Crip();
			user.setSenha(crip.cripto(user.getSenha()));
			Valida valida = new Valida();
			if (valida.usuario(user)) {
				jdbcUsuario.atualizar(user);
				
			} else {
				throw new NoValueException();
			};
		}catch(NoValueException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conec.fecharConexao();
		}
	}

}