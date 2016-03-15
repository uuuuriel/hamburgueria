package br.com.hamburgueria.validacoes; 

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Funcionario;

public class ValidaFuncionario {

	public void funcionario(Funcionario func) throws HamburgueriaException {
		ValidaCpf validcpf = new ValidaCpf();
		ValidaEmail validemail = new ValidaEmail();
		validemail.validarEmail(func.getEmail());
		validcpf.validarCpf(func.getCpf());
		if ((func.getBairro().equals(""))
				|| (func.getCep() - func.getCep() != 0)
				|| (func.getCidade().equals(""))
				|| (func.getDataNascimento().equals(""))
				|| (func.getEmail().equals(""))
				|| (func.getFone() - func.getFone() != 0)
				|| (func.getFuncao().equals(""))
				|| (func.getNomeFuncionario().equals(""))
				|| (func.getNumero() - func.getNumero() != 0)
				|| (func.getRg().equals("")) || (func.getRua().equals(""))) {
			throw new NoValueException();
		}
	}
}