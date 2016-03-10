package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.objs.Usuario;

public interface UsuarioDAO {

	public List<Usuario> buscarPorNome(String nome);

	public void deletarUsuario(int id);

	public void atualizar(Usuario user);

	public void inserir(Usuario user);
	
	public Usuario buscarPorId(int id);

	public boolean buscarEmail(Usuario user);

}
