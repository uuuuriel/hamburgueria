package br.com.hamburgueria.objs;

import java.util.Date;

public class ListaPedido {
	private int codPedido;
	private int codProduto;
	private int codCliente;
	private Date dataCompra;
	private float valorProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private String cancelado;
	private String anexo;
	private String categoria;
	private String estagio_produto;
	private int entrega;
	private float valorTotal;
	private String nomeUsuario;
	
	public int getCodPedido() {
		return codPedido;
	}
	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public float getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getCancelado() {
		return cancelado;
	}
	public void setCancelado(String cancelado) {
		this.cancelado = cancelado;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getEstagio_produto() {
		return estagio_produto;
	}
	public void setEstagio_produto(String estagio_produto) {
		this.estagio_produto = estagio_produto;
	}
	public int getEntrega() {
		return entrega;
	}
	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}	
}
