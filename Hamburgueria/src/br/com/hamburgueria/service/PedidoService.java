package br.com.hamburgueria.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.regex.Pattern;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.DeletarPedidoException;
import br.com.hamburgueria.exception.EstagioPedidoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.ListaPedidoException;
import br.com.hamburgueria.exception.ValueZException;
import br.com.hamburgueria.jdbc.JDBCClienteDAO;
import br.com.hamburgueria.jdbc.JDBCPedidoDAO;
import br.com.hamburgueria.jdbcinterface.ClienteDAO;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.ClienteNovo;
import br.com.hamburgueria.objs.ListaPedido;
import br.com.hamburgueria.objs.Pedido;

public class PedidoService {
	
	public void finalizarPedido (String array, Pedido ped) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			ped = jdbcPedido.setPedidoCliente(ped);			
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
		}finally{
			conec.fecharConexao();
		}
	}

	public void finalizarPedidoFuncionario(String array, Pedido ped) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			ped = jdbcPedido.setPedidoCliente(ped);	
			jdbcPedido.setPedidoFuncionario(ped.getCodfunc(), ped.getCodpedido());
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
		
	} 
	
	public void finalizarPedidoFuncionarioNovo(String array, ClienteNovo user) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			ClienteDAO jdbcUsuario = new JDBCClienteDAO(conexao);
			user = jdbcUsuario.inserirPreCadastro(user); 
			Pedido ped = new Pedido();
			ped.setCodcliente(user.getCodCliente());
			ped.setCodtaxa(user.getCodtaxa());
			ped = jdbcPedido.setPedidoCliente(ped);
			jdbcPedido.setPedidoFuncionario(user.getCodfunc(), ped.getCodpedido());
			String quebra[] = array.split(Pattern.quote(","));
			for (int i = 0; i < quebra.length; i++) {
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaPedido> listarPedidos(String busca, Date dataini, Date datafim, int cod) throws ListaPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.listar(busca, dataini, datafim, cod);		
		}catch(Exception e){
			e.printStackTrace();
			throw new ListaPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void atualizarEstagioPedido(int estagio, int cod) throws EstagioPedidoException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			if(estagio != 0 && cod != 0){
				jdbcPedido.atualizaEstagioPedido(estagio, cod);
			}else{
				throw new ValueZException();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaPedido> listarProdutosEstagio(int cod) throws ListaPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.listarProdutoEstagio(cod);		
		}catch(Exception e){
			e.printStackTrace();
			throw new ListaPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void deletarPedido(int cod) throws DeletarPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			jdbcPedido.deletarPedido(cod);	
		}catch(Exception e){
			e.printStackTrace();
			throw new DeletarPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}

}
