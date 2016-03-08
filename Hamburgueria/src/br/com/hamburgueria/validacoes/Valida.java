package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Usuario;

public class Valida {

	public boolean funcionario(Funcionario func) throws NoValueException {
		if ((func.getBairro().equals(""))
				|| (func.getCep() - func.getCep() != 0)
				|| (func.getCidade().equals(""))
				|| (func.getCodfuncionario() - func.getCodfuncionario() != 0)
				|| (func.getCpf().equals(""))
				|| (func.getDataNascimento().equals(""))
				|| (func.getEmail().equals(""))
				|| (func.getFone() - func.getFone() != 0)
				|| (func.getFuncao().equals(""))
				|| (func.getNomeFuncionario().equals(""))
				|| (func.getNumero() - func.getNumero() != 0)
				|| (func.getRg().equals("")) || (func.getRua().equals(""))) {
			return false;
		} else {
			return true;
		}
	}

	public boolean usuario(Usuario user) throws NoValueException {
		if (((user.getCep()
				- user.getCep() != 0))
				|| (user.getEmail().equals(""))
				|| (user.getSenha().equals(""))
				|| (user.getCpf() - user.getCpf() != 0)
				|| (user.getRg() - user.getRg() != 0)
				|| (user.getNome().equals(""))
				|| (user.getTelefone() - user.getTelefone() != 0)) {
			return false;
		} else {
			return true;
		}
	}
}
