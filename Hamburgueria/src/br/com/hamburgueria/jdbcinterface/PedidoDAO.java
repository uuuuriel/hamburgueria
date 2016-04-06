package br.com.hamburgueria.jdbcinterface;

import java.util.Date;
import java.util.List;

import br.com.hamburgueria.exception.DeletarPedidoException;
import br.com.hamburgueria.exception.EstagioPedidoException;
import br.com.hamburgueria.exception.EstagioProdutoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.ListaPedido;
import br.com.hamburgueria.objs.Pedido;

public interface PedidoDAO {

	void finalizarPedido(int pedido, int produtos) throws HamburgueriaException;

	public Pedido setPedidoCliente(Pedido pedido) throws HamburgueriaException;

	public void setPedidoFuncionario(int codfuncionario, int codpedido) throws HamburgueriaException;

	public List<ListaPedido> listar(String busca, Date dataini, Date datafim, int codcliente) throws HamburgueriaException;
	
	public void atualizaEstagioPedido (int estagio, int cod) throws EstagioPedidoException;
	
	public List<ListaPedido> listarEstagioPedido() throws EstagioProdutoException;
	
	public void deletarPedido (int cod) throws DeletarPedidoException;
	
}
