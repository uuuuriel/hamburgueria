package br.com.hamburgueria.exception;
import br.com.hamburgueria.exception.HamburgueriaException;


public class DeletarPedidoException extends HamburgueriaException{
			public DeletarPedidoException(){
				super("Erro ao deletar um pedido.");
			}
			public DeletarPedidoException(String msg){
				super(msg);
			}
			public DeletarPedidoException(Throwable t){
				super(t);
			}
}
