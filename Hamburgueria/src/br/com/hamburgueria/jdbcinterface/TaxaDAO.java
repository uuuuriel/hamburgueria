package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Taxa;

public interface TaxaDAO {
	public List<Taxa> buscar(String list) throws HamburgueriaException;

	public boolean editar(Taxa taxa) throws HamburgueriaException;
}
