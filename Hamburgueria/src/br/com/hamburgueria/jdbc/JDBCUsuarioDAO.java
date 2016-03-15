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
import br.com.hamburgueria.jdbcinterface.UsuarioDAO;
import br.com.hamburgueria.objs.Usuario;

public class JDBCUsuarioDAO implements UsuarioDAO {
	private Connection conexao;

	public JDBCUsuarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Usuario> buscarPorNome(String nome)  throws HamburgueriaException{
		String comando = "select * from cliente  ";
		if (!nome.equals("")) {
			comando += "where nomecliente like '" + nome + "%'";
		}
		List<Usuario> list = new ArrayList<Usuario>();
		Usuario user = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				user = new Usuario();
				user.setBairro(rs.getInt("bairro"));
				user.setCidade(rs.getInt("cidade"));
				user.setCod(rs.getInt("codcliente"));
				user.setComplemento(rs.getString("complemento"));
				user.setCpf(rs.getString("cpf"));
				user.setData_nascimento(rs.getDate("data_nascimento"));
				user.setEmail(rs.getString("email"));
				user.setNome(rs.getString("nomecliente"));
				user.setNumero(rs.getInt("numero"));
				user.setData_cadastro(rs.getDate("data_cadastro"));
				user.setRg(rs.getString("rg"));
				user.setRua(rs.getString("rua"));
				user.setSenha(rs.getString("senha"));
				user.setTelefone(rs.getDouble("telefone"));
				user.setCep(rs.getInt("cep"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
		return list;
	}

	@Override
	public void deletarUsuario(int cod) throws HamburgueriaException{
		String comando = "delete from cliente where codcliente = "
				+ cod;
		Statement p;
		try {
			p = this.conexao.createStatement();
			p.execute(comando);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
	}

	@Override
	public void atualizar(Usuario user) throws HamburgueriaException{
		boolean editSenha = false;
		String comando = "UPDATE cliente SET nomecliente=?, data_nascimento=?, rg=?, cpf=?,"
				+ "cidade=?, bairro=?, rua=?, numero=?, complemento=?, cep=?, telefone=?, email=?";
		if (user.getSenha() == null || user.getSenha().isEmpty()) {
			comando += " WHERE codcliente = ";
		} else {
			editSenha = true;
			comando += ", senha=? where codcliente = ";
		}
		comando += user.getCod() + ";";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, user.getNome());
			p.setDate(2, new java.sql.Date( user.getData_nascimento().getTime()));
			p.setString(3, user.getRg());
			p.setString(4, user.getCpf());
			p.setInt(5, user.getCidade());
			p.setInt(6, user.getBairro());
			p.setString(7, user.getRua());
			p.setInt(8, user.getNumero());
			p.setString(9, user.getComplemento());
			p.setInt(10, user.getCep());
			p.setDouble(11, user.getTelefone());
			p.setString(12, user.getEmail());
			if (editSenha) {
				p.setString(13, user.getSenha());
			};
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
	}

	@Override
	public void inserir(Usuario user) throws HamburgueriaException{
		String comando = "insert into cliente (nomecliente, data_nascimento, rg, cpf, cidade"
				+ ", bairro, rua, numero, complemento, cep, telefone, data_cadastro, email"
				+ ", senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p;
		Date d = new Date();
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, user.getNome());
			p.setDate(2, new java.sql.Date( user.getData_nascimento().getTime()));
			p.setString(3, user.getRg());
			p.setString(4, user.getCpf());
			p.setInt(5, user.getCidade());
			p.setInt(6, user.getBairro());
			p.setString(7, user.getRua());
			p.setInt(8, user.getNumero());
			p.setString(9, user.getComplemento());
			p.setInt(10, user.getCep());
			p.setDouble(11, user.getTelefone());
			p.setDate(12, new java.sql.Date( d.getTime()));
			p.setString(13, user.getEmail());
			p.setString(14, user.getSenha());
			p.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
	}

	public Usuario buscarPorId(int cod) throws HamburgueriaException{
		String comando = "select * from cliente where codcliente = "
				+ cod;
		Usuario user = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				user = new Usuario();
				user.setBairro(rs.getInt("bairro"));
				user.setCidade(rs.getInt("cidade"));
				user.setCod(rs.getInt("codcliente"));
				user.setComplemento(rs.getString("complemento"));
				user.setCpf(rs.getString("cpf"));
				user.setData_nascimento(rs.getDate("data_nascimento"));
				user.setEmail(rs.getString("email"));
				user.setNome(rs.getString("nomecliente"));
				user.setNumero(rs.getInt("numero"));
				user.setData_cadastro(rs.getDate("data_cadastro"));
				user.setRg(rs.getString("rg"));
				user.setRua(rs.getString("rua"));
				user.setTelefone(rs.getDouble("telefone"));
				user.setCep(rs.getInt("cep"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
		return user;
	}

	public boolean buscarEmail(Usuario user) throws HamburgueriaException{
		String comando = "select * from cliente where email ='" + user.getEmail() + "'";
		boolean retun = false;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				if((user.getEmail().equals(rs.getString("email"))) && (user.getSenha().equals(rs.getString("senha")))){
					user.setNome(rs.getString("nomecliente"));
					user.setCod(rs.getInt("codcliente"));
					retun = true;
				}				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new HamburgueriaException();
		}
		if(retun){
			return true;
		}else{
			return false;
		}
	}
}
