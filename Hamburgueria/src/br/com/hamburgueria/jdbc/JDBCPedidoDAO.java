package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.Pedido;

public class JDBCPedidoDAO implements PedidoDAO {

	private Connection conexao;

	public JDBCPedidoDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public void finalizarPedido(int produto, int pedido) throws HamburgueriaException {
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
		String comando = "insert into pedido (estagio_pedido_codestagio_pedido, cliente_codcliente,"
				+ "taxas_codtaxas, data) VALUES (?,?,?,?)";
		PreparedStatement p;
		Date d = new Date();
		try {
			p = this.conexao.prepareStatement(comando, Statement.RETURN_GENERATED_KEYS);
			p.setString(1, "1");
			p.setInt(2, pedido.getCodcliente());
			p.setInt(3, 1);
			p.setDate(4, new java.sql.Date(d.getTime()));
			p.execute();
			try (ResultSet generatedKeys = p.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                pedido.setCodpedido(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Erro ao criar pedido. ID failed.");
	            }
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pedido;
	}

}
