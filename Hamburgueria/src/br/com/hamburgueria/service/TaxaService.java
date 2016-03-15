package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCTaxaDAO;
import br.com.hamburgueria.jdbcinterface.TaxaDAO;
import br.com.hamburgueria.objs.Taxa;
import br.com.hamburgueria.validacoes.ValidaTaxa;

public class TaxaService {

	public List<Taxa> buscar(String nome) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			return jdbcTaxa.buscar(nome);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void editar(Taxa taxa)throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			ValidaTaxa valid = new ValidaTaxa();
			valid.validaTaxa(taxa);
			jdbcTaxa.editar(taxa);
		}finally{
			conec.fecharConexao();
		}
	}

	
}
