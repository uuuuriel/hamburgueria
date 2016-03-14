package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCDuvidaDAO;
import br.com.hamburgueria.jdbcinterface.DuvidaDAO;
import br.com.hamburgueria.objs.Duvida;
import br.com.hamburgueria.validacoes.ValidaDuvida;

public class DuvidaService {


	public void adicionar(Duvida duv) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			DuvidaDAO jdbcDuvida = new JDBCDuvidaDAO(conexao);
			ValidaDuvida valida = new ValidaDuvida();
			valida.Duvida(duv);
			jdbcDuvida.inserir(duv);
		}finally{
			conec.fecharConexao();
		}
	}
	public List<Duvida> buscarNome(String nome) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			DuvidaDAO jdbcDuvida = new JDBCDuvidaDAO(conexao);
			return jdbcDuvida.buscarNome(nome);
		}finally{
			conec.fecharConexao();
		}
	}
}
