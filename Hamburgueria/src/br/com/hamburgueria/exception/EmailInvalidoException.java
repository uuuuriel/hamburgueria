package br.com.hamburgueria.exception;

public class EmailInvalidoException extends HamburgueriaException{
	public EmailInvalidoException(){
		super("EMAIL inválido.");
	}
	public EmailInvalidoException(String msg){
		super(msg);
	}
	public EmailInvalidoException(Throwable t){
		super(t);
	}
}
