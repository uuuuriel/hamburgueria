package br.com.hamburgueria.exception;

public class FinalizarPedidoException extends HamburgueriaException{
	public FinalizarPedidoException(){
		super("Erro ao finalizar pedido.");
	}
	public FinalizarPedidoException(String msg){
		super(msg);
	}
	public FinalizarPedidoException(Throwable t){
		super(t);
	}
}
