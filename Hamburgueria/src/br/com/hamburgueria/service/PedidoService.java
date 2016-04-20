package br.com.hamburgueria.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.CancelarPedidoException;
import br.com.hamburgueria.exception.EstagioPedidoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.ListaPedidoException;
import br.com.hamburgueria.exception.ListarPedidoEntregaException;
import br.com.hamburgueria.exception.PedidoEntregueException;
import br.com.hamburgueria.exception.ValueZException;
import br.com.hamburgueria.jdbc.JDBCClienteDAO;
import br.com.hamburgueria.jdbc.JDBCPedidoDAO;
import br.com.hamburgueria.jdbcinterface.ClienteDAO;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.ClienteNovo;
import br.com.hamburgueria.objs.ListaPedidoVO;
import br.com.hamburgueria.objs.ListaVO;
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
			float total = 0;
			for (int i = 0; i < quebra.length; i++) {
				 total = total + jdbcPedido.calculaValor(Integer.parseInt(quebra[i]));
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
			jdbcPedido.setValorTotalPedido(ped.getCodpedido(), total);
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
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaPedidoVO> listarPedidos(String busca, Date dataini, Date datafim, int cod) throws ListaPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.listar(busca, dataini, datafim, cod);		
		}catch(Exception e){
			throw new ListaPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void atualizarEstagioPedido(int estagio, int codpe, int codpr) throws EstagioPedidoException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			if(estagio != 0 && codpe != 0 && codpr != 0){
				jdbcPedido.atualizaEstagioPedido(estagio, codpe, codpr);
			}else{
				throw new ValueZException();
			}
			if(jdbcPedido.verificaPedidoFinalizado(codpe) == false){
				jdbcPedido.finalizaPedidoAll(codpe, 4);
			}
			
		}catch(Exception e){
			throw new EstagioPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaPedidoVO> listarProdutosEstagio(int cod) throws ListaPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.listarProdutoEstagio(cod);		
		}catch(Exception e){
			throw new ListaPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public boolean cancelarPedido(int cod, String cancelado) throws CancelarPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			if(jdbcPedido.verificaProdutoCancela(cod)){
				jdbcPedido.cancelarPedido(cod, cancelado);
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new CancelarPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaVO> listarPedidoEntrega() throws  ListarPedidoEntregaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			List<ListaVO> listaPedido = new ArrayList<ListaVO>();
			boolean firsttime = true;
			List<ListaPedidoVO> listPedido = jdbcPedido.listarPedidoEntrega();
			for(ListaPedidoVO pedidos : listPedido){
				ListaVO listaVO = new ListaVO();
				if(firsttime){
				   	listaVO.setCodigoPedido(pedidos.getCodPedido());
				  	listaVO.getList().add(pedidos);
			   	}
			   	if (listaVO.getCodigoPedido() == pedidos.getCodPedido()) {
				  	listaVO.getList().add(pedidos);
			  	}else{
			  		listaVO.setCodigoPedido(pedidos.getCodPedido());
			  		listaVO.getList().add(pedidos);
	  		 	}
			 	firsttime = false;
			}
			return listaPedido;
		}catch(ListarPedidoEntregaException e){
			e.printStackTrace();
			throw new ListarPedidoEntregaException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void pedidoEntregue(int cod) throws PedidoEntregueException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			jdbcPedido.finalizaPedidoAll(cod, 5);
		}catch(Exception e){
			throw new PedidoEntregueException();
		}finally{
			conec.fecharConexao();
		}
	}
}
