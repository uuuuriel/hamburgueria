package br.com.hamburgueria.exception;

public class CripException extends HamburgueriaException{
	public CripException(){
		this((Throwable) null);
	}
	public CripException(String msg){
		super(msg);
	}
	public CripException(Throwable t){
		super("Errou ao criptografar.", t);
	}
	public CripException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
}
