package br.com.hamburgueria.exception;

public class DadosPedidoException extends HamburgueriaException{
	public DadosPedidoException(){
		super("Dados Do pedido não conferem.");
	}
	public DadosPedidoException(String msg){
		super(msg);
	}
	public DadosPedidoException(Throwable t){
		super(t);
	}
}
