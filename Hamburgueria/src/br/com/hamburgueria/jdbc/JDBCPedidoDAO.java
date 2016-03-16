package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.Pedido;

import com.mysql.jdbc.Statement;

public class JDBCPedidoDAO implements PedidoDAO {

	private Connection conexao;

	public JDBCPedidoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void finalizarPedido(int pedido, int produto) throws HamburgueriaException {
		String comando = "insert into pedido_produto (pedido_codpedido, produto_codproduto)"
				+ "VALUES (?, ?)";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setInt(1, pedido);
			p.setInt(2, produto);
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException(e.getMessage());
		}
	}

	public Pedido setPedidoCliente(Pedido pedido) throws HamburgueriaException {
		String comando = "insert into pedido (valor_total, estagio_pedido_codestagio_pedido";
		PreparedStatement p;
		Date d = new Date();
		try {
			p = this.conexao.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
			p.setDouble(1, pedido.getValortotal());
			p.setDate(2, new java.sql.Date(d.getTime()));
			p.execute();
			System.out.println(p);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
		return pedido;
	}

}
