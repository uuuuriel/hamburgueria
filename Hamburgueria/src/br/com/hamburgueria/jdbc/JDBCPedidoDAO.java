package br.com.hamburgueria.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;

public class JDBCPedidoDAO implements PedidoDAO {

	public void finalizarPedido(int codproduto, int codpedido) throws HamburgueriaException{
			String comando = "insert into pedido_produto (pedido_codpedido, produto_codproduto)"
					+ "VALUES (?, ?)";
			PreparedStatement p;
			try {
				p = this.conexao.prepareStatement(comando);
				p.setString(1, func.getNomeFuncionario());
				p.setString(2, func.getCpf());
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
