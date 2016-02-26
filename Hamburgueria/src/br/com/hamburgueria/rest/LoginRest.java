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

@Path("LoginRest")
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
			
			Usuario usuario = new ObjectMapper().readValue(user, Usuario.class);
			UsuarioService serviceCli = new UsuarioService();
			if(serviceFunc.buscarLogin(funcionario)){
				return this.buildResponse("success");
			}else if(serviceCli.buscarLogin(usuario)){
				return this.buildResponse("success");
			}else{
				return this.buildResponse("Dados não conferem!");
			}
		} catch (HamburgueriaException | IOException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

}
