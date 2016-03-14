package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Produto;

public class ValidaProduto {
	
	public void produtoCadastro(Produto prod) throws HamburgueriaException {
		if (prod.getDescricao().equals("") || prod.getNome().equals("")
				|| prod.getValor() == 0 || prod.getCategoria().equals("")) {
			throw new NoValueException();
		}
	}
	
	public void produtoCancelamento(Produto prod) throws HamburgueriaException {
		if (prod.getCancelamento().equals("")) {
			throw new NoValueException("Preencha o motivo do cancelamento.");
		}
	}
}
