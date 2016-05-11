package br.com.hamburgueria.validacoes; 

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Funcionario;

public class ValidaFuncionario {

	public void funcionario(Funcionario func) throws HamburgueriaException {
		ValidaCpf validcpf = new ValidaCpf();
		ValidaEmail validemail = new ValidaEmail();
		validemail.validarEmail(func.getEmail());
		//validcpf.validarCpf(func.getCpf());
		if ((func.getBairro() == 0)
				|| (func.getCep() - func.getCep() != 0)
				|| (func.getCidade() == 0)
				|| (func.getData_nascimento().equals(""))
				|| (func.getEmail().equals(""))
				|| (func.getTelefone() - func.getTelefone() != 0)
				|| (func.getFuncao().equals(""))
				|| (func.getNome().equals(""))
				|| (func.getNumero() - func.getNumero() != 0)
				|| (func.getRg().equals("")) || (func.getRua().equals(""))) {
			throw new NoValueException();
		}
	}
}