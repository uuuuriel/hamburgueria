package br.com.hamburgueria.objs;

import java.util.Date;

public class ListaPedidoVO {
	private int codigoPedido;
	private int codigoProduto;
	private int codigoCliente;
	private Date dataCompra;
	private float valorProduto;
	private String nomeProduto;
	private String descricaoProduto;
	private String cancelado;
	private String anexo;
	private String categoria;
	private String estagioProduto;
	private int entrega;
	private float valorTotal;
	private String nomeUsuario;
	private int quantidade;
	private String nomefuncionario;
	
	public String getNomefuncionario() {
		return nomefuncionario;
	}
	public void setNomefuncionario(String nomefuncionario) {
		this.nomefuncionario = nomefuncionario;
	}
	public int getQtde() {
		return quantidade;
	}
	public void setQtde(int qtde) {
		this.quantidade = qtde;
	}
	public int getCodPedido() {
		return codigoPedido;
	}
	public void setCodPedido(int codPedido) {
		this.codigoPedido = codPedido;
	}
	public int getCodProduto() {
		return codigoProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codigoProduto = codProduto;
	}
	public int getCodCliente() {
		return codigoCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codigoCliente = codCliente;
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
		return estagioProduto;
	}
	public void setEstagio_produto(String estagio_produto) {
		this.estagioProduto = estagio_produto;
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
