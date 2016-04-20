package br.com.hamburgueria.exception;

public class CalculaValorException extends HamburgueriaException{

	public CalculaValorException(){
		super("Erro ao calcula valor total.");
	}
	public CalculaValorException(String msg){
		super(msg);
	}
	public CalculaValorException(Throwable t){
		super(t);
	}
}
