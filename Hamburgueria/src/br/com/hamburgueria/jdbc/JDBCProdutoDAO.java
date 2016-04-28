package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.ProdutoDAO;
import br.com.hamburgueria.objs.Produto;

public class JDBCProdutoDAO implements ProdutoDAO{
	
	private Connection conexao;
	public JDBCProdutoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<Produto> buscarNome(String nome) throws HamburgueriaException{
		String comando = "select * from produto where ativo = 1";
		List<Produto> list = new ArrayList<Produto>();
		Produto prod = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				prod = new Produto();	
				prod.setCod(rs.getInt("codproduto"));
				prod.setNome(rs.getString("nomeproduto"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setAnexo(rs.getString("anexo"));
				prod.setCancelamento(rs.getString("cancelamento"));
				prod.setObservacao(rs.getString("observacao"));
				prod.setValor(rs.getDouble("valor"));
				prod.setCategoria(rs.getString("categoria"));
				prod.setAtivo(rs.getInt("ativo"));
				list.add(prod);
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return list;
	}
	
	public List<Produto> buscarNomeTodos(String nome) throws HamburgueriaException{
		String comando = "select * from produto  ";
		if (!nome.equals("")) {
			comando += "where nomeproduto like '" + nome + "%'";
		}
		List<Produto> list = new ArrayList<Produto>();
		Produto prod = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				prod = new Produto();
				prod.setCod(rs.getInt("codproduto"));
				prod.setNome(rs.getString("nomeproduto"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setAnexo(rs.getString("anexo"));
				prod.setCancelamento(rs.getString("cancelamento"));
				prod.setObservacao(rs.getString("observacao"));
				prod.setValor(rs.getDouble("valor"));
				prod.setCategoria(rs.getString("categoria"));
				prod.setAtivo(rs.getInt("ativo"));
				list.add(prod);
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return list;
	}

	@Override
	public boolean deletar(int cod) throws HamburgueriaException{
		String comando = "delete from produto where codproduto = "
				+ cod;
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return true;
	}

	@Override
	public boolean atualizar(Produto prod) throws HamburgueriaException{
		String comando = "UPDATE produto SET nomeproduto=?,"
				+ " descricao=?, categoria=?, ativo=?, valor=?";
		if(prod.getAnexo() != ""){
			comando += " ,anexo=?";
		}
		comando += " WHERE codproduto="+prod.getCod();
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, prod.getNome());
			p.setString(2, prod.getDescricao());
			p.setString(3, prod.getCategoria());
			p.setInt(4, prod.getAtivo());
			p.setDouble(5, prod.getValor());
			if(prod.getAnexo() != ""){
				p.setString(6, prod.getAnexo());
			}
			p.executeUpdate();
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return true;
	}

	@Override
	public boolean inserir(Produto prod) throws HamburgueriaException{
		String comando = "insert into produto (nomeproduto, descricao, anexo, categoria, ativo, valor)"
				+ " values (?, ?, ?, ?, ?, ?);";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, prod.getNome());
			p.setString(2, prod.getDescricao());
			p.setString(3, prod.getAnexo());
			p.setString(4, prod.getCategoria());
			p.setInt(5, prod.getAtivo());
			p.setDouble(6, prod.getValor());
			p.execute();
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return true;
	}

	public Produto buscarId(int cod) throws HamburgueriaException{
		String comando = "select * from produto where codproduto = "
				+ cod;
		Produto prod = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				prod = new Produto();
				prod.setCod(rs.getInt("codproduto"));
				prod.setNome(rs.getString("nomeproduto"));
				prod.setDescricao(rs.getString("descricao"));
				prod.setAnexo(rs.getString("anexo"));
				prod.setCancelamento(rs.getString("cancelamento"));
				prod.setObservacao(rs.getString("observacao"));
				prod.setAtivo(rs.getInt("ativo"));
				prod.setValor(rs.getDouble("valor"));
				prod.setCategoria(rs.getString("categoria"));
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e);
		}
		return prod;
	}

}
