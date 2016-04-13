package br.com.hamburgueria.exception;

public class ListarPedidoEntregaException extends HamburgueriaException{

	public ListarPedidoEntregaException(){
		super("Erro ao listar os pedidos para entrega.");
	}
	public ListarPedidoEntregaException(String msg){
		super(msg);
	}
	public ListarPedidoEntregaException(Throwable t){
		super(t);
	}

	
}
