package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.objs.Taxa;

public interface TaxaDAO {
	public List<Taxa> buscar(String list);

	public boolean editar(Taxa taxa);
}
