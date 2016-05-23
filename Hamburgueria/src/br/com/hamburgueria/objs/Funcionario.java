package br.com.hamburgueria.objs;


public class Funcionario extends Cliente{
	
	private int administrador;
	private String funcao;
	private int codfuncionario;
	private int funcionario;

	public int getAdministrador() {
		return administrador;
	}
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getCodfuncionario() {
		return codfuncionario;
	}
	public void setCodfuncionario(int codfuncionario) {
		this.codfuncionario = codfuncionario;
	}
	public int getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	
}
