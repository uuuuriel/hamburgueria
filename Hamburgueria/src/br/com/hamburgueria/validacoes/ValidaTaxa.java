package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Taxa;

public class ValidaTaxa {
	
	public void validaTaxa(Taxa taxa) throws HamburgueriaException{
		if (taxa.getValor() == 0) {
			throw new NoValueException();
		}
	}

}
