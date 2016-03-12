package br.com.hamburgueria.exception;

public class CpfInvalidoException extends HamburgueriaException{
	public CpfInvalidoException(){
		super("CPF inválido.");
	}
	public CpfInvalidoException(String msg){
		super(msg);
	}
	public CpfInvalidoException(Throwable t){
		super(t);
	}
}
