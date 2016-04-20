package br.com.hamburgueria.objs;

import java.util.ArrayList;
import java.util.List;

public class ListaVO {
	
	private int codigoPedido;
	private List<ListaPedidoVO> list = new ArrayList();
	
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
