package br.com.hamburgueria.objs;

import java.sql.Date;

public class GraficoVendaVO {
	private float valor;
	private String descricao;
	private Date data;
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
}
