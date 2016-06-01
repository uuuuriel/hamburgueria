package br.com.hamburgueria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbcinterface.FuncionarioDAO;
import br.com.hamburgueria.objs.Funcionario;

public class JDBCFuncionarioDAO implements FuncionarioDAO {
	private Connection conexao;

	public JDBCFuncionarioDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Funcionario> buscarPorNome(String nome) throws HamburgueriaException{
		String comando = "select * from funcionario  ";
		if (!nome.equals("")) {
			comando += "where nomefuncionario like '" + nome + "%'";
		}
		List<Funcionario> listFunc = new ArrayList<Funcionario>();
		Funcionario func = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				func = new Funcionario();
				func.setAdministrador(rs.getInt("administrador"));
				func.setBairro(rs.getInt("bairro"));
				func.setCidade(rs.getInt("cidade"));
				func.setCodfuncionario(rs.getInt("codfuncionario"));
				func.setComplemento(rs.getString("complemento"));
				func.setCpf(rs.getString("cpf"));
				func.setData_nascimento(rs.getDate("data_nascimento"));
				func.setEmail(rs.getString("email"));
				func.setNome(rs.getString("nomefuncionario"));
				func.setNumero(rs.getInt("numero"));
				func.setRg(rs.getString("rg"));
				func.setRua(rs.getString("rua"));
				func.setFuncao(rs.getString("funcao"));
				func.setSenha(rs.getString("senha"));
				func.setTelefone(rs.getDouble("fone"));
				func.setCep(rs.getInt("cep"));
				func.setAtivo(rs.getInt("ativo"));
				listFunc.add(func);
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return listFunc;
	}

	@Override
	public boolean deletarFuncionario(int cod) throws HamburgueriaException{
		String comando = "UPDATE funcionario SET ativo=0 WHERE codfuncionario = "+ cod;
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.executeUpdate(comando);
		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean atualizar(Funcionario func) throws HamburgueriaException{
		boolean editSenha = false;
		String comando = "UPDATE funcionario SET nomefuncionario=?, cpf=?, rg=?, data_nascimento=?,"
				+ "fone=?, email=?, funcao=?, cidade=?, bairro=?, numero=?, rua=?, complemento=?,"
				+ "administrador=?, cep=?, ativo=?";
		if (func.getSenha() == null || func.getSenha().isEmpty() || func.getSenha() != "") {
			comando += " WHERE codfuncionario = ";
		} else {
			editSenha = true;
			comando += ", senha=? where codfuncionario = ";
		}
		comando += func.getCodfuncionario();
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, func.getNome());
			p.setString(2, func.getCpf());
			p.setString(3, func.getRg());
			p.setDate(4, new java.sql.Date(func.getData_nascimento().getTime()));
			p.setDouble(5, func.getTelefone());
			p.setString(6, func.getEmail());
			p.setString(7, func.getFuncao());
			p.setInt(8, func.getCidade());
			p.setInt(9, func.getBairro());
			p.setFloat(10, func.getNumero());
			p.setString(11, func.getRua());
			p.setString(12, func.getComplemento());
			p.setInt(13, func.getAdministrador());
			p.setInt(14, func.getCep());
			p.setInt(15, func.getAtivo());
			if (editSenha) {
				p.setString(16, func.getSenha());
			};
			p.executeUpdate();

		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return true;
	}

	@Override
	public boolean inserir(Funcionario func) throws HamburgueriaException{
		String comando = "insert into funcionario (nomefuncionario, cpf, rg"
				+ ", data_nascimento, fone, email, senha, funcao, cidade, bairro"
				+ ",numero, rua, complemento, administrador, cep, funcionario, ativo) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement p;
		try {
			p = this.conexao.prepareStatement(comando);
			p.setString(1, func.getNome());
			p.setString(2, func.getCpf());
			p.setString(3, func.getRg());
			p.setDate(4, new java.sql.Date(func.getData_nascimento().getTime()));
			p.setDouble(5, func.getTelefone());
			p.setString(6, func.getEmail());
			p.setString(7, func.getSenha());
			p.setString(8, func.getFuncao());
			p.setInt(9, func.getCidade());
			p.setInt(10, func.getBairro());
			p.setFloat(11, func.getNumero());
			p.setString(12, func.getRua());
			p.setString(13, func.getComplemento());
			p.setInt(14, func.getAdministrador());
			p.setInt(15, func.getCep());
			p.setInt(16, func.getFuncionario());
			p.setInt(17, func.getAtivo());
			p.execute();
		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return true;
	}

	public Funcionario buscarPorId(int cod) throws HamburgueriaException{
		String comando = "select * from funcionario where codfuncionario = "
				+ cod;
		Funcionario func = null;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				func = new Funcionario();
				func.setAdministrador(rs.getInt("administrador"));
				func.setBairro(rs.getInt("bairro"));
				func.setCidade(rs.getInt("cidade"));
				func.setCodfuncionario(rs.getInt("codfuncionario"));
				func.setComplemento(rs.getString("complemento"));
				func.setCpf(rs.getString("cpf"));
				func.setData_nascimento(rs.getDate("data_nascimento"));
				func.setEmail(rs.getString("email"));
				func.setNome(rs.getString("nomefuncionario"));
				func.setNumero(rs.getInt("numero"));
				func.setRg(rs.getString("rg"));
				func.setRua(rs.getString("rua"));
				func.setFuncao(rs.getString("funcao"));
				func.setSenha(rs.getString("senha"));
				func.setTelefone(rs.getDouble("fone"));
				func.setCep(rs.getInt("cep"));
				func.setAtivo(rs.getInt("ativo"));
			}
		} catch (SQLException e) {
			throw new HamburgueriaException(e.getMessage());
		}
		return func;
	}

	public boolean buscarEmail(Funcionario func) throws HamburgueriaException{
		String comando = "select * from funcionario where email ='" + func.getEmail() + "' AND ativo = 1";
		boolean retun = false;
		try {
			java.sql.Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery(comando);
			while (rs.next()) {
				if((func.getEmail().equals(rs.getString("email"))) && (func.getSenha().equals(rs.getString("senha")))){
					func.setNome(rs.getString("nomefuncionario"));
					func.setAdministrador(rs.getInt("administrador"));
					func.setCodfuncionario(rs.getInt("codfuncionario"));
					retun =  true;
				}	
			}
			
		} catch (SQLException e) {
			throw new HamburgueriaException();
		}
		if(retun){
			return true;
		}else{			
			return false;
		}
	}
}
