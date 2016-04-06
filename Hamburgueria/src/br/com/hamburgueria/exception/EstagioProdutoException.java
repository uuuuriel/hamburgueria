package br.com.hamburgueria.exception;

public class EstagioProdutoException extends HamburgueriaException{
		public EstagioProdutoException(){
			super("Erro ao trocar estágio de um produto.");
		}
		public EstagioProdutoException(String msg){
			super(msg);
		}
		public EstagioProdutoException(Throwable t){
			super(t);
		}
}

