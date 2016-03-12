package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Duvida;

public interface DuvidaDAO {
	
	public List<Duvida> buscarNome(String nome) throws HamburgueriaException;
	public boolean inserir(Duvida duv) throws HamburgueriaException;

}
