package br.com.hamburgueria.exception;
import br.com.hamburgueria.exception.HamburgueriaException;


public class CancelarPedidoException extends HamburgueriaException{
			public CancelarPedidoException(){
				super("Erro ao deletar um pedido.");
			}
			public CancelarPedidoException(String msg){
				super(msg);
			}
			public CancelarPedidoException(Throwable t){
				super(t);
			}
}
