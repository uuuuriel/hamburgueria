package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCTaxaDAO;
import br.com.hamburgueria.jdbcinterface.TaxaDAO;
import br.com.hamburgueria.objs.Taxa;

public class TaxaService {

	public List<Taxa> buscar(String list) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			
			return jdbcTaxa.buscar(list);
		}catch(Exception e){
			e.printStackTrace();
			throw new HamburgueriaException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void editar(Taxa taxa)throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			jdbcTaxa.editar(taxa);
		}catch(Exception e){
			e.printStackTrace();
			throw new HamburgueriaException();
		}finally{
			conec.fecharConexao();
		}
	}

	
}
