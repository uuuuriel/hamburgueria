package br.com.hamburgueria.jdbcinterface;

import java.sql.Date;
import java.util.List;

import br.com.hamburgueria.exception.GerarGraficoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.GraficoVendaVO;

public interface GraficoDAO {
	public List<GraficoVendaVO> venda(Date dataini, Date datafim) throws HamburgueriaException;
}
