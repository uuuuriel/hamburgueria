package br.com.hamburgueria.exception;

public class finalizaPedidoAllException extends HamburgueriaException{
	
	public finalizaPedidoAllException(){
		super("Erro ao finalizar pedido.");
	}
	public finalizaPedidoAllException(String msg){
		super(msg);
	}
	public finalizaPedidoAllException(Throwable t){
		super(t);
	}

}
