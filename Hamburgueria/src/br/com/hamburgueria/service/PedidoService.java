package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.regex.Pattern;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCPedidoDAO;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;

public class PedidoService {
	
	public void finalizarPedido (String array) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO();
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				jdbcPedido.
			}
		}finally{
			conec.fecharConexao();
		}
	}

}
