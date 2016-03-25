package br.com.hamburgueria.jdbcinterface;

import java.util.List;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Usuario;

public interface UsuarioDAO {

	public List<Usuario> buscarPorNome(String nome) throws HamburgueriaException;

	public void deletarUsuario(Usuario user) throws HamburgueriaException;

	public void atualizar(Usuario user)  throws HamburgueriaException;

	public Usuario inserir(Usuario user) throws HamburgueriaException;
	
	public Usuario buscarPorId(int id)  throws HamburgueriaException;

	public boolean buscarEmail(Usuario user)  throws HamburgueriaException;

}
