package br.com.hamburgueria.exception;

public class PermissaoException extends HamburgueriaException{
	public PermissaoException(){
		super("Sem permissão para acessar.");
	}
	public PermissaoException(String msg){
		super(msg);
	}
	public PermissaoException(Throwable t){
		super(t);
	}
}
