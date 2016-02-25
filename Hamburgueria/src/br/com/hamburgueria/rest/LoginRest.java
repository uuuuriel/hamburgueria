package br.com.hamburgueria.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Usuario;
import br.com.hamburgueria.service.FuncionarioService;
import br.com.hamburgueria.service.UsuarioService;

public class LoginRest extends UtilRest {
	
	public LoginRest() {
	}
	
	@POST
	@Path("/login")
	@Consumes("application/*")
	public Response buscarLogin(String user) {
		try {
			Funcionario funcionario = new ObjectMapper().readValue(user, Funcionario.class);
			FuncionarioService serviceFunc = new FuncionarioService();
			
			if(serviceFunc.buscarLogin(funcionario) != null){
				return this.buildResponse(funcionario);
			}
			Usuario usuario = new ObjectMapper().readValue(user, Usuario.class);
			UsuarioService serviceCli = new UsuarioService();
			if(serviceCli.buscarLogin(usuario) != null){
				return this.buildResponse(usuario);
			}else{
				return this.buildResponse("Email ou senha estão incorretos!");
			}
		} catch (HamburgueriaException | IOException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

}
