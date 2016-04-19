package br.com.hamburgueria.objs;

import java.util.ArrayList;
import java.util.List;

public class ListaVO {
	
	private int codigoPedido;
	
	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	List<ListaPedidoVO> list = new ArrayList();

	public List<ListaPedidoVO> getList() {
		return list;
	}

	public void setList(List<ListaPedidoVO> list) {
		this.list = list;
	}

}
