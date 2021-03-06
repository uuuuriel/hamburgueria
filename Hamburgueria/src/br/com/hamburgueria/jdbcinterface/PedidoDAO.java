package br.com.hamburgueria.jdbcinterface;

import java.util.Date;
import java.util.List;

import br.com.hamburgueria.exception.CalculaValorException;
import br.com.hamburgueria.exception.CancelarPedidoException;
import br.com.hamburgueria.exception.EstagioPedidoException;
import br.com.hamburgueria.exception.EstagioProdutoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.ListarPedidoEntregaException;
import br.com.hamburgueria.exception.RelatorioVendaException;
import br.com.hamburgueria.exception.ValorTotalException;
import br.com.hamburgueria.exception.VerificaPedidoFinalizadoException;
import br.com.hamburgueria.exception.finalizaPedidoAllException;
import br.com.hamburgueria.objs.ListaPedidoVO;
import br.com.hamburgueria.objs.Pedido;

public interface PedidoDAO {

	void finalizarPedido(int pedido, int produtos) throws HamburgueriaException;

	public Pedido setPedidoCliente(Pedido pedido) throws HamburgueriaException;

	public void setPedidoFuncionario(Pedido ped) throws HamburgueriaException;

	public List<ListaPedidoVO> listar(String busca, Date dataini, Date datafim, int codcliente) throws HamburgueriaException;
	
	public void atualizaEstagioPedido (int estagio, int codpe, int codpr) throws EstagioPedidoException;
	
	public List<ListaPedidoVO> listarProdutoEstagio(int cod) throws EstagioProdutoException;
	
	public void cancelarPedido (int cod, String cancelar) throws CancelarPedidoException;
	
	public boolean verificaPedidoFinalizado(int cod)throws VerificaPedidoFinalizadoException;
	
	public void finalizaPedidoAll(int cod, int estagio)throws finalizaPedidoAllException;
	
	public boolean verificaProdutoCancela(int cod) throws CancelarPedidoException;
	
	public List<ListaPedidoVO> listarPedidoEntrega() throws ListarPedidoEntregaException;
	
	public float calculaValor(int cod) throws CalculaValorException;
	
	public void setValorTotalPedido(int cod, float total) throws ValorTotalException;
	
	public List<ListaPedidoVO> relatorioVenda(Date dataini, Date datafim, String busca) throws RelatorioVendaException;
	
	public List<ListaPedidoVO> pedidosUsuario(int cod) throws HamburgueriaException;
	
}
