package br.com.hamburgueria.exception;

public class GerarGraficoException extends HamburgueriaException{
	public GerarGraficoException(){
		super("Erro ao gerar gráfico.");
	}
	public GerarGraficoException(String msg){
		super(msg);
	}
	public GerarGraficoException(Throwable t){
		super(t);
	}
}
