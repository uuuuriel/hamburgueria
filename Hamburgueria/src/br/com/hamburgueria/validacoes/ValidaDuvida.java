package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoResultException;

public class ValidaDuvida {
	
	public boolean Duvida(br.com.hamburgueria.objs.Duvida duv) throws HamburgueriaException {
		if(duv.getEmail().equals("") || duv.getMensagem().equals("")){
			throw new NoResultException();
		}else{
			return true;
		}
	}

}
