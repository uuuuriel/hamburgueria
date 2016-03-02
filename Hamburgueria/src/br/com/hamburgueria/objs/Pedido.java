package br.com.hamburgueria.objs;

public class Pedido {
	
	private int codpedido;
	private String estagiopedido;
	private double valortotal;
	private int codcliente;
	private int codtaxa;
	
	public int getCodpedido() {
		return codpedido;
	}
	public void setCodpedido(int codpedido) {
		this.codpedido = codpedido;
	}
	public String getEstagiopedido() {
		return estagiopedido;
	}
	public void setEstagiopedido(String estagiopedido) {
		this.estagiopedido = estagiopedido;
	}
	public double getValortotal() {
		return valortotal;
	}
	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	public int getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}
	public int getCodtaxa() {
		return codtaxa;
	}
	public void setCodtaxa(int codtaxa) {
		this.codtaxa = codtaxa;
	}

}
