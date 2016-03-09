package br.com.hamburgueria.jdbcinterface;

import java.sql.SQLException;
import java.util.List;

import br.com.hamburgueria.exception.NoResultException;
import br.com.hamburgueria.exception.NoValueException;
import br.com.hamburgueria.objs.Usuario;

public interface UsuarioDAO {

	public List<Usuario> buscarPorNome(String nome) throws NoResultException;

	public void deletarUsuario(int id) throws NoResultException;

	public void atualizar(Usuario user) throws SQLException;

	public void inserir(Usuario user) throws SQLException;
	
	public Usuario buscarPorId(int id) throws NoResultException;

	public boolean buscarEmail(Usuario user) throws NoResultException;

}
