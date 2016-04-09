package br.com.hamburgueria.exception;

public class PedidoEntregueException extends HamburgueriaException{

	public PedidoEntregueException(){
		super("Erro ao trocar estágio de um pedido.");
	}
	public PedidoEntregueException(String msg){
		super(msg);
	}
	public PedidoEntregueException(Throwable t){
		super(t);
	}	
	
}
