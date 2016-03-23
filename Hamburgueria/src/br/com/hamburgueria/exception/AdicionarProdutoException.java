package br.com.hamburgueria.exception;

public class AdicionarProdutoException extends HamburgueriaException{
	public AdicionarProdutoException(){
		super("Erro ao adicionar um novo produto.");
	}
	public AdicionarProdutoException(String msg){
		super(msg);
	}
	public AdicionarProdutoException(Throwable t){
		super(t);
	}
}
