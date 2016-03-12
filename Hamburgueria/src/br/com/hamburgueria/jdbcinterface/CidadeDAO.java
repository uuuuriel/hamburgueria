package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Cidade;

public interface CidadeDAO {

	List<Cidade> listarTodas() throws HamburgueriaException;

}
