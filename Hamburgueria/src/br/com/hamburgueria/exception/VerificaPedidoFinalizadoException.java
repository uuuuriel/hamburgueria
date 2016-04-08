package br.com.hamburgueria.exception;

public class VerificaPedidoFinalizadoException extends HamburgueriaException{
	public VerificaPedidoFinalizadoException(){
		super("Erro ao verifica se finalizou o pedido todo.");
	}
	public VerificaPedidoFinalizadoException(String msg){
		super(msg);
	}
	public VerificaPedidoFinalizadoException(Throwable t){
		super(t);
	}
}
