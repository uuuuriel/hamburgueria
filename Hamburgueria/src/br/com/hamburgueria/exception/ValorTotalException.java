package br.com.hamburgueria.exception;

public class ValorTotalException extends HamburgueriaException{

	public ValorTotalException(){
		super("Erro ao inserir valor total.");
	}
	public ValorTotalException(String msg){
		super(msg);
	}
	public ValorTotalException(Throwable t){
		super(t);
	}
	
}
