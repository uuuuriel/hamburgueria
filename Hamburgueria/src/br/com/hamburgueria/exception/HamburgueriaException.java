package br.com.hamburgueria.exception;

public class HamburgueriaException extends Exception {
	public HamburgueriaException(){
		super("Ocorreu um erro inesperado.");
	}
	public HamburgueriaException(String msg){
		super(msg);
	}
	public HamburgueriaException(Throwable t){
		super(t);
	}
	public HamburgueriaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
}
