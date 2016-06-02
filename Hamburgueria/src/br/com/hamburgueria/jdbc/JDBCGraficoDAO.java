package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.GraficoDAO;
import br.com.hamburgueria.objs.GraficoVendaVO;

public class JDBCGraficoDAO implements GraficoDAO{
	
	private Connection conexao;

	public JDBCGraficoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	
	public List<GraficoVendaVO> venda(Date dataini, Date datafim) throws HamburgueriaException{
		String comando = "SELECT sum(pedido.total) as total, pedido.data FROM pedido"
				+ " WHERE (data between '"+dataini+"' AND '"+datafim+"') GROUP BY date_format(data, '%Y-%m-%d')";
		List<GraficoVendaVO> lista = new ArrayList();
		GraficoVendaVO grafico = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				grafico = new GraficoVendaVO();
				grafico.setData(rs.getDate("data"));
				grafico.setValor(rs.getFloat("total"));
				lista.add(grafico);
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return lista;
	}
}
