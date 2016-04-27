package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.DadosPedidoException;
import br.com.hamburgueria.objs.Pedido;

public class ValidaPedido {
	
	public void pedido(Pedido ped) throws DadosPedidoException{
		try{
			int v = ped.getCodtaxa();
			if(ped.getCodcliente() == 0){
				throw new DadosPedidoException();
			}
		}catch(Exception e){
			throw new DadosPedidoException(e);
		}
	}
	
	public void pedidoFuncionario(Pedido ped) throws DadosPedidoException{
		try{
			int v = ped.getCodtaxa();
			if((ped.getCodcliente() == 0) || (ped.getCodfunc() == 0)){
				throw new DadosPedidoException();
			}
		}catch(Exception e){
			throw new DadosPedidoException(e);
		}
	}
	public void pedidoFuncionarioNovo(Pedido ped) throws DadosPedidoException{
		try{
			int v = ped.getCodtaxa();
			if((ped.getCodcliente() == 0) || (ped.getCodfunc() == 0)){
				throw new DadosPedidoException();
			}
		}catch(Exception e){
			throw new DadosPedidoException(e);
		}
	}

}
