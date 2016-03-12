package br.com.hamburgueria.validacoes;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Usuario;

public class ValidaUsuario {

	public boolean usuario(Usuario user) throws HamburgueriaException {
		ValidaCpf validcpf = new ValidaCpf();
		validcpf.validarCpf(String.valueOf(user.getCpf()));
		if (((user.getCep()
				- user.getCep() != 0))
				|| (user.getEmail().equals(""))
				|| (user.getSenha().equals(""))
				|| (user.getRg() - user.getRg() != 0)
				|| (user.getNome().equals(""))
				|| (user.getTelefone() - user.getTelefone() != 0)) {
			throw new NoValueException();
		} else {
			return true;
		}
	}
}