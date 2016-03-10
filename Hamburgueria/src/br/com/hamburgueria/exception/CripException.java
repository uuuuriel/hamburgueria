package br.com.hamburgueria.exception;

public class CripException extends HamburgueriaException{
	public CripException(){
		super("Errou ao criptografar.");
	}
	public CripException(String msg){
		super(msg);
	}
	public CripException(Throwable t){
		super(t);
	}
}
