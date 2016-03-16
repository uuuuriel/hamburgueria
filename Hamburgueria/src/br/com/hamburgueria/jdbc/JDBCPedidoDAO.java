package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.PedidoProduto;

public class JDBCPedidoDAO implements PedidoDAO {
	
	private Connection conexao;
	public JDBCPedidoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	

	public void finalizarPedido(PedidoProduto cod) throws HamburgueriaException{
			String comando = "insert into pedido_produto (pedido_codpedido, produto_codproduto)"
					+ "VALUES (?, ?)";
			PreparedStatement p;
			try {
				p = this.conexao.prepareStatement(comando);
				p.setInt(1, cod.getPedido());
				p.setInt(2, cod.getProduto());
				p.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new HamburgueriaException(e.getMessage());
			}
			return true;
		}
	}
	
	public String setPedidoCliente(int cod, Date date) throws HamburgueriaException{
		
		return null;
	}

}
