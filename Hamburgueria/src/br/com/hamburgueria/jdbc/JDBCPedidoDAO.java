package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.ListaPedido;
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
			p.setInt(1, 1);
			p.setInt(2, pedido.getCodcliente());
			p.setInt(3, pedido.getCodtaxa());
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
	
	public List<ListaPedido> buscarPedido(String nome)  throws HamburgueriaException{
		String comando = "SELECT pe.codpedido, pe.cliente_codcliente as codcliente, pe.funcionario_codfuncionario, "
				+ "pe.data, pr.valor,"
				+ " pr.nomeproduto, pr.descricao, pr.cancelamento, pr.anexo, pr.categoria, pr.codproduto,"
				+ " pe.estagio_pedido_codestagio_pedido as estagio, pe.taxas_codtaxas as entrega, fc.nomefuncionario FROM pedido pe"
				+ "inner join pedido_produto pp on pp.pedido_codpedido = pe.codpedido"
				+ "inner join produto pr on pr.codproduto = pp.produto_codproduto"
				+ "inner join funcionario fc on fc.codfuncionario = pe.cliente_codcliente";
		if (!nome.equals("")) {
			comando += "where pe.cliente_codcliente like '" + nome + "%'";
		}
		List<ListaPedido> list = new ArrayList<ListaPedido>();
		ListaPedido produt = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				produt = new ListaPedido();
				produt.setCancelado(rs.getString("cancelamento"));
				produt.setCategoria(rs.getString("categoria"));
				produt.setCodCliente(rs.getInt("codcliente"));
				produt.setCodPedido(rs.getInt("codpedido"));
				produt.setCodProduto(rs.getInt("codproduto"));
				produt.setDataCompra(rs.getDate("data"));
				produt.setDescricaoProduto(rs.getString("descricao"));
				produt.setEntrega(rs.getInt("entrega"));
				produt.setEstagio_produto(rs.getString("estagio"));
				produt.setNomeProduto(rs.getString("nomeproduto"));
				produt.setNomeUsuario(rs.getString("nome"));
				produt.setValorProduto(rs.getFloat("valor"));
				list.add(produt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
		return list;
	}

	@Override
	public void setPedidoFuncionario(int codfuncionario, int codpedido) throws HamburgueriaException {
		String comando = "insert into historico_funcionario (pedido_codpedido, funcionario_codfuncionario)"
				+ "VALUES (?, ?)";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setInt(1, codpedido);
			p.setInt(2, codfuncionario);
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException(e.getMessage());
		}	
	}

}
