package br.com.hamburgueria.exception;

public class RelatorioVendaException extends HamburgueriaException{
	public RelatorioVendaException(){
		super("Erro ao exibir relatório de venda.");
	}
	public RelatorioVendaException(String msg){
		super(msg);
	}
	public RelatorioVendaException(Throwable t){
		super(t);
	}

}
