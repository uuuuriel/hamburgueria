package br.com.hamburgueria.jdbcinterface;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Pedido;

public interface PedidoDAO {

	void finalizarPedido(int pedido, int produtos) throws HamburgueriaException;

	public Pedido setPedidoCliente(Pedido pedido) throws HamburgueriaException;

	public Pedido setPedidoFuncionario(Pedido pedido) throws HamburgueriaException;
	
}
