package br.com.hamburgueria.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.GerarGraficoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCGraficoDAO;
import br.com.hamburgueria.jdbcinterface.GraficoDAO;
import br.com.hamburgueria.objs.GraficoVendaVO;

public class GraficoService {
	
	public List<GraficoVendaVO> venda(Date dataini, Date datafim) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {			
			Connection conexao = conec.abrirConexao();
			GraficoDAO jdbcGrafico = new JDBCGraficoDAO(conexao);
			return jdbcGrafico.venda(dataini, datafim);
		}finally{
			conec.fecharConexao();
		}
	}
}
