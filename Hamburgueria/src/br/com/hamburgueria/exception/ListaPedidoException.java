package br.com.hamburgueria.exception;

public class ListaPedidoException extends HamburgueriaException {
	public ListaPedidoException(){
		super("Erro ao retornar pedidos.");
	}
	public ListaPedidoException(String msg){
		super(msg);
	}
	public ListaPedidoException(Throwable t){
		super(t);
	}
	public ListaPedidoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
}
