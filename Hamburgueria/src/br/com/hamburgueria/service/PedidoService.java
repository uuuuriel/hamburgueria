package br.com.hamburgueria.service;

import java.sql.Connection;
import java.util.regex.Pattern;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCPedidoDAO;
import br.com.hamburgueria.jdbc.JDBCUsuarioDAO;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.jdbcinterface.UsuarioDAO;
import br.com.hamburgueria.objs.Pedido;
import br.com.hamburgueria.objs.Usuario;

public class PedidoService {
	
	public void finalizarPedido (String array, int codUser) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			Pedido pedido = new Pedido();
			pedido.setCodcliente(codUser);
			pedido = jdbcPedido.setPedidoCliente(pedido);			
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), pedido.getCodpedido());
			}
		}finally{
			conec.fecharConexao();
		}
	}

	public void finalizarPedidoFuncionario(String array, int codfunc, int codcliente) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			Pedido pedido = new Pedido();
			pedido.setCodcliente(codcliente);
			pedido = jdbcPedido.setPedidoCliente(pedido);	
			jdbcPedido.setPedidoFuncionario(codfunc, pedido.getCodpedido());
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), pedido.getCodpedido());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
		
	}
	
	public void finalizarPedidoFuncionarioNovo(String array, Usuario user, int codfunc) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			System.out.println(user);
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			Pedido pedido = new Pedido();
			UsuarioDAO jdbcUsuario = new JDBCUsuarioDAO(conexao);
			user = jdbcUsuario.inserir(user); 
			pedido.setCodcliente(user.getCod());
			pedido = jdbcPedido.setPedidoCliente(pedido);			
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), pedido.getCodpedido());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
	}

}
