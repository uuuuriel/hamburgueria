package br.com.hamburgueria.objs;

import java.sql.Date;

public class Pedido {
	
	private int codpedido;
	private int codfunc;
	private String estagiopedido;
	private double valortotal;
	private int codcliente;
	private int codtaxa;
	private Date data;
	
	public int getCodfunc() {
		return codfunc;
	}
	public void setCodfunc(int codfunc) {
		this.codfunc = codfunc;
	}	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
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
