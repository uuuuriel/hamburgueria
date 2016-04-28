package br.com.hamburgueria.service;
import java.sql.Connection;
import java.util.List;

import br.com.hamburgueria.auxilia.hashImagem;
import br.com.hamburgueria.bd.conexao.Conexao;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.jdbc.JDBCProdutoDAO;
import br.com.hamburgueria.jdbcinterface.ProdutoDAO;
import br.com.hamburgueria.objs.Produto;
import br.com.hamburgueria.validacoes.ValidaProduto;

public class ProdutoService {

	public Produto buscarId(int id) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {			
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			return jdbcProduto.buscarId(id);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<Produto> buscarNome(String nome) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			return jdbcProduto.buscarNome(nome);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public List<Produto> buscarNomeTodos(String nome) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			return jdbcProduto.buscarNomeTodos(nome);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public String adicionar(Produto prod) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try {
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			ValidaProduto valid = new ValidaProduto();
			valid.produtoCadastro(prod);
			hashImagem imagem = new hashImagem();
			prod.setAnexo(imagem.cripto(prod.getAnexo())+".jpg");
			jdbcProduto.inserir(prod);
			return prod.getAnexo();
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void deletar(int id) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			jdbcProduto.deletar(id);
		}finally{
			conec.fecharConexao();
		}
	}
	
	public void atualizar(Produto prod) throws HamburgueriaException{
		Conexao conec = new Conexao();
		try{
			Connection conexao = conec.abrirConexao();
			ProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
			ValidaProduto valid = new ValidaProduto();
			valid.produtoCadastro(prod);
			if(prod.getAnexo()!= ""){
				hashImagem imagem = new hashImagem();
				prod.setAnexo(imagem.cripto(prod.getAnexo())+".jpg");
			}
			jdbcProduto.atualizar(prod);
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			conec.fecharConexao();
		}
	}
}