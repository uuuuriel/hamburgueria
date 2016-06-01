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
import br.com.hamburgueria.exception.RelatorioVendaException;
import br.com.hamburgueria.exception.ValueZException;
import br.com.hamburgueria.jdbc.JDBCClienteDAO;
import br.com.hamburgueria.jdbc.JDBCPedidoDAO;
import br.com.hamburgueria.jdbc.JDBCTaxaDAO;
import br.com.hamburgueria.jdbcinterface.ClienteDAO;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.jdbcinterface.TaxaDAO;
import br.com.hamburgueria.objs.ClienteNovo;
import br.com.hamburgueria.objs.ListaPedidoVO;
import br.com.hamburgueria.objs.ListaVO;
import br.com.hamburgueria.objs.Pedido;
import br.com.hamburgueria.validacoes.ValidaPedido;

public class PedidoService {

	public void finalizarPedido (String array, Pedido ped) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			ValidaPedido valida = new ValidaPedido();
			valida.pedido(ped);
			ped = jdbcPedido.setPedidoCliente(ped);
			String quebra[] = array.split(Pattern.quote(","));
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			float total = jdbcTaxa.taxaEntrega().getCod() == ped.getCodtaxa() ? jdbcTaxa.taxaEntrega().getValor() : 0;
			for (int i = 0; i < quebra.length; i++) {
				 total = total + jdbcPedido.calculaValor(Integer.parseInt(quebra[i]));
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
			jdbcPedido.setValorTotalPedido(ped.getCodpedido(), total);
		}finally{
			conec.fecharConexao();
		}
	}

	public void finalizarPedidoFuncionario(String array, Pedido ped) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			ValidaPedido valida = new ValidaPedido();
			valida.pedidoFuncionario(ped);
			ped = jdbcPedido.setPedidoCliente(ped);	
			jdbcPedido.setPedidoFuncionario(ped);
			String quebra[] = array.split(Pattern.quote(","));
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			float total = jdbcTaxa.taxaEntrega().getCod() == ped.getCodtaxa() ? jdbcTaxa.taxaEntrega().getValor() : 0;
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
			ClienteService serviceCliente = new ClienteService();
			if(serviceCliente.validaFone(user.getTelefone(), 0)){
				throw new HamburgueriaException("Telefone já cadastrado.");
			}
			user = jdbcUsuario.inserirPreCadastro(user); 
			Pedido ped = new Pedido();
			ped.setCodcliente(user.getCodCliente());
			ped.setCodtaxa(user.getCodtaxa());
			ped.setCodfunc(user.getCodfunc());
			ValidaPedido valida = new ValidaPedido();
			valida.pedidoFuncionarioNovo(ped);
			ped = jdbcPedido.setPedidoCliente(ped);
			jdbcPedido.setPedidoFuncionario(ped);
			String quebra[] = array.split(Pattern.quote(","));
			TaxaDAO jdbcTaxa = new JDBCTaxaDAO(conexao);
			float total = jdbcTaxa.taxaEntrega().getCod () == ped.getCodtaxa() ? jdbcTaxa.taxaEntrega().getValor() : 0;
			for (int i = 0; i < quebra.length; i++) {
				 total = total + jdbcPedido.calculaValor(Integer.parseInt(quebra[i]));
				 jdbcPedido.finalizarPedido(Integer.parseInt(quebra[i]), ped.getCodpedido());
			}
			jdbcPedido.setValorTotalPedido(ped.getCodpedido(), total);
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
			jdbcPedido.cancelarPedido(cod, cancelado);
			return true;
		}catch(Exception e){
			throw new CancelarPedidoException();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public boolean validaCancelarPedido(int cod) throws CancelarPedidoException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.verificaProdutoCancela(cod);
		}catch(Exception e){
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
			ListaVO lastVO = new ListaVO();
			for(ListaPedidoVO pedido : jdbcPedido.listarPedidoEntrega()){
				if ( pedido.getCodPedido() != lastVO.getCodigoPedido() ) {
					lastVO = new ListaVO();
					lastVO.setCodigoPedido(pedido.getCodPedido());
					lastVO.setNomeCliente(pedido.getNomeCliente());
					lastVO.setValorTotal(pedido.getValorTotal());
				 	listaPedido.add(lastVO);
				}
				lastVO.setQtdeTotal(lastVO.getQtdeTotal() + pedido.getQtde());
				lastVO.getList().add(pedido);
			}
			return listaPedido;
		}catch(ListarPedidoEntregaException e){
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
	
	public List<ListaPedidoVO> relatorioVenda(Date dataini, Date datafim, String busca) throws RelatorioVendaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.relatorioVenda(dataini, datafim, busca);
		}catch(Exception e){
			throw new RelatorioVendaException(e);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<ListaPedidoVO> pedidosUsuario(int cod) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			PedidoDAO jdbcPedido = new JDBCPedidoDAO(conexao);
			return jdbcPedido.pedidosUsuario(cod);
		}catch(Exception e){
			throw new HamburgueriaException("Erro ao exibir pedidos.");
		}finally{
			conec.fecharConexao();
		}
	}
	
}
