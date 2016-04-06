package br.com.hamburgueria.exception;

public class EstagioPedidoException extends HamburgueriaException{
	public EstagioPedidoException(){
		super("Erro ao trocar estágio de um pedido.");
	}
	public EstagioPedidoException(String msg){
		super(msg);
	}
	public EstagioPedidoException(Throwable t){
		super(t);
	}

}
