package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.hamburgueria.exception.CalculaValorException;
import br.com.hamburgueria.exception.CancelarPedidoException;
import br.com.hamburgueria.exception.EstagioPedidoException;
import br.com.hamburgueria.exception.EstagioProdutoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.ListarPedidoEntregaException;
import br.com.hamburgueria.exception.RelatorioVendaException;
import br.com.hamburgueria.exception.ValorTotalException;
import br.com.hamburgueria.exception.VerificaPedidoFinalizadoException;
import br.com.hamburgueria.exception.finalizaPedidoAllException;
import br.com.hamburgueria.jdbcinterface.PedidoDAO;
import br.com.hamburgueria.objs.ListaPedidoVO;
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
	
	public float calculaValor(int cod) throws CalculaValorException{
		String comando = "SELECT valor, codproduto FROM produto WHERE codproduto ="+cod; 
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			return rs.next() ? rs.getFloat("valor") : 0;
		} catch(SQLException e){
			e.printStackTrace();
			throw new CalculaValorException();
		}
	}
	
	public void setValorTotalPedido(int cod, float total) throws ValorTotalException{
		String comando = "UPDATE pedido SET total = ? WHERE codpedido ="+cod;
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setFloat(1, total);
			p.executeUpdate();
		} catch (SQLException e) {
			throw new ValorTotalException(e);
		}
	}
	
	public List<ListaPedidoVO> buscarPedido(String nome)  throws HamburgueriaException{
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
		List<ListaPedidoVO> list = new ArrayList<ListaPedidoVO>();
		ListaPedidoVO produt = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				produt = new ListaPedidoVO();
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
				produt.setNomeCliente(rs.getString("nome"));
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
	
	@Override
	public List<ListaPedidoVO> listar(String busca, Date dataini, Date datafim, int codcliente) throws HamburgueriaException{
		String comando = "select p.*, pr.*, ep.estagio as estagio, cl.nomecliente from pedido p"
				+ " inner join pedido_produto pp on p.codpedido = pp.pedido_codpedido"
				+ " inner join produto pr on pr.codproduto = pp.produto_codproduto"
				+ " inner join estagio_pedido ep on ep.codestagio_pedido = p.estagio_pedido_codestagio_pedido"
				+ " inner join cliente cl on cl.codcliente = p.cliente_codcliente";
		if (!dataini.equals("")) {
			comando += " where (data between '" + dataini + "' and '" + datafim + "')"
					+ " and (pr.nomeproduto like '%" + busca + "%' or pr.descricao like '%" + busca + "%'"
					+ " or cl.nomecliente like '%"+ busca +"%') AND p.estagio_pedido_codestagio_pedido = 5";
					if (codcliente != 0) {
						comando += " and cliente_codcliente = "+codcliente;
					}
		}
		List<ListaPedidoVO> list = new ArrayList<ListaPedidoVO>();
		ListaPedidoVO ped = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				ped = new ListaPedidoVO();
				ped.setCancelado(rs.getString("cancelado"));
				ped.setCodCliente(rs.getInt("cliente_codcliente"));
				ped.setCodPedido(rs.getInt("codpedido"));
				ped.setCodProduto(rs.getInt("codproduto"));
				ped.setDataCompra(rs.getDate("data"));
				ped.setValorProduto(rs.getFloat("valor"));
				ped.setDescricaoProduto(rs.getString("descricao"));
				ped.setEstagio_produto(rs.getString("estagio"));
				ped.setNomeProduto(rs.getString("nomeproduto"));
				ped.setNomeCliente(rs.getString("nomecliente"));
				list.add(ped);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException(e.getMessage());
		}
		
		return list;	
	}
	
	@Override
	public List<ListaPedidoVO> listarProdutoEstagio(int cod) throws EstagioProdutoException{
		String comando = "SELECT ped.codpedido, prod.codproduto, prod.nomeproduto, prod.descricao, prod.valor,"
				+ " prod.categoria, ped_prod.estagio_pedido, count(ped_prod.produto_codproduto) as qtde FROM pedido ped"
				+ " inner join pedido_produto ped_prod on ped_prod.pedido_codpedido = ped.codpedido"
				+ " inner join produto prod on prod.codproduto = ped_prod.produto_codproduto "
				+ " WHERE ped_prod.estagio_pedido ="+cod+ " "
						+ " AND ped.cancelado is null GROUP BY ped_prod.pedido_codpedido,ped_prod.produto_codproduto";
		List<ListaPedidoVO> list = new ArrayList<ListaPedidoVO>();
		ListaPedidoVO ped = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				ped = new ListaPedidoVO();
				ped.setCodPedido(rs.getInt("codpedido"));
				ped.setCodProduto(rs.getInt("codproduto"));
				ped.setNomeProduto(rs.getString("nomeproduto"));
				ped.setDescricaoProduto(rs.getString("descricao"));
				ped.setValorProduto(rs.getFloat("valor"));
				ped.setCategoria(rs.getString("categoria"));
				ped.setEstagio_produto(rs.getString("estagio_pedido"));
				ped.setQtde(rs.getInt("qtde"));
				list.add(ped);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EstagioProdutoException(e.getMessage());
		}
		
		return list;	
	}
	
	@Override
	public void atualizaEstagioPedido (int estagio, int codpe, int codpr) throws EstagioPedidoException{
		String comando = "UPDATE pedido_produto SET estagio_pedido="+estagio+" WHERE pedido_codpedido="+ codpe
					+ " AND produto_codproduto=" + codpr;
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.executeUpdate(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EstagioPedidoException(e.getMessage());
		}
	}

	@Override
	public void cancelarPedido(int cod,String cancelado) throws CancelarPedidoException {
		String comando = "UPDATE pedido SET total=?, cancelado=? WHERE codpedido="+ cod;
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setInt(1, 0);
			p.setString(2, cancelado);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CancelarPedidoException(e);
		}
	}
	
	@Override
	public boolean verificaPedidoFinalizado(int cod)throws VerificaPedidoFinalizadoException{
		String comando = "SELECT p.codpedido, pp.estagio_pedido FROM pedido p"
				+ " inner join pedido_produto pp on pp.pedido_codpedido = p.codpedido"
				+ "	inner join produto pr on pr.codproduto = pp.produto_codproduto"
				+ "	WHERE pp.estagio_pedido < 4 AND p.estagio_pedido_codestagio_pedido = 1"
				+ " AND p.codpedido ="+cod; 
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			return rs.next() ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new VerificaPedidoFinalizadoException(e.getMessage());
		}
	}
	
	public void finalizaPedidoAll(int cod, int estagio)throws finalizaPedidoAllException{
			String comando = "UPDATE pedido SET estagio_pedido_codestagio_pedido ="+estagio+" WHERE codpedido=" + cod;
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.executeUpdate(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new finalizaPedidoAllException(e.getMessage());
		}
	}
	
	public boolean verificaProdutoCancela(int cod) throws CancelarPedidoException{
		String comando = "SELECT p.codpedido FROM pedido p "
				+ "inner join pedido_produto pp on p.codpedido = pp.pedido_codpedido"
				+ " WHERE p.codpedido ="+cod+" AND pp.estagio_pedido != 1";
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			return rs.next() ? false : true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CancelarPedidoException(e.getMessage());
		}

	}

	@Override
	public List<ListaPedidoVO> listarPedidoEntrega() throws ListarPedidoEntregaException{
		String comando = "SELECT p.*, pr.*, c.nomecliente, count(pp.produto_codproduto) as qtde FROM pedido p "
				+ "inner join pedido_produto pp on pp.pedido_codpedido = p.codpedido "
				+ "inner join produto pr on pr.codproduto = pp.produto_codproduto "
				+ "inner join cliente c on c.codcliente = p.cliente_codcliente "
				+ "WHERE p.estagio_pedido_codestagio_pedido = 4 GROUP BY pp.pedido_codpedido, pp.produto_codproduto ORDER BY p.codpedido ASC";
		List<ListaPedidoVO> list = new ArrayList<ListaPedidoVO>();
		ListaPedidoVO ped = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				ped = new ListaPedidoVO();
				ped.setCodPedido(rs.getInt("codpedido"));
				ped.setCodProduto(rs.getInt("codproduto"));
				ped.setNomeProduto(rs.getString("nomeproduto"));
				ped.setNomeCliente(rs.getString("nomecliente"));
				ped.setDescricaoProduto(rs.getString("descricao"));
				ped.setValorProduto(rs.getFloat("valor"));
				ped.setCategoria(rs.getString("categoria"));
				ped.setValorTotal(rs.getInt("total"));
				ped.setQtde(rs.getInt("qtde"));
				list.add(ped);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ListarPedidoEntregaException(e.getMessage());
		}
		
		return list;	
	} 
	
	public void relatorioVenda(Date dataini, Date datafim) throws RelatorioVendaException{
		//IMPLEMENTAR A DATA COMO PARAMETRO NA CONSULTA
		String comando = "SELECT p.*, c.nomecliente, count(pp.pedido_codpedido) as qtde,"
				+ " f.nomefuncionario FROM pedido p inner join cliente c"
				+ " on c.codcliente = p.cliente_codcliente inner join pedido_produto pp "
				+ "on pp.pedido_codpedido = p.codpedido "
				+ "inner join historico_funcionario hf on hf.pedido_codpedido = p.codpedido "
				+ " inner join funcionario f on f.codfuncionario = hf.funcionario_codfuncionario "
				+ "GROUP by p.codpedido";
		List<ListaPedidoVO> list = new ArrayList<ListaPedidoVO>();
		ListaPedidoVO ped = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				ped = new ListaPedidoVO();
				ped.setCodPedido(rs.getInt("codpedido"));
				ped.setCancelado(rs.getString("cancelado"));
				ped.setDataCompra(rs.getDate("data"));
				ped.setNomeCliente(rs.getString("nomecliente"));
				ped.setValorTotal(rs.getFloat("total"));
				ped.setCategoria(rs.getString("categoria"));
				ped.setNomefuncionario(rs.getString("nomefuncionario"));
				ped.setQtde(rs.getInt("qtde"));
				list.add(ped);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new RelatorioVendaException(e.getMessage());
		}
	}
	
}
