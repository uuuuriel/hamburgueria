package br.com.hamburgueria.objs;

import java.util.ArrayList;
import java.util.List;

public class ListaVO {
	
	private int codigoPedido;
	private String nomeCliente;
	private List<ListaPedidoVO> list = new ArrayList();
	private float valorTotal;
	private int qtdeTotal;
	
	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQtdeTotal() {
		return qtdeTotal;
	}

	public void setQtdeTotal(int qtdeTotal) {
		this.qtdeTotal = qtdeTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public List<ListaPedidoVO> getList() {
		return list;
	}

	public void setList(List<ListaPedidoVO> list) {
		this.list = list;
	}

}
