package br.com.hamburgueria.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.PermissaoException;
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.service.FuncionarioService;

@Path("funcionarioRest")
public class FuncionarioRest extends UtilRest {
	
	@Context
	private HttpServletRequest req;
	
	public FuncionarioRest() {
	}
	@POST
	@Path("/addFuncionario")
	@Consumes("application/*")
	public Response addFuncionario(String funcionarioParam) throws PermissaoException {
		try {
			Funcionario funcionario = new ObjectMapper().readValue(funcionarioParam,
					Funcionario.class);
			FuncionarioService service = new FuncionarioService();
			HttpSession sessao = req.getSession(false);
			service.adicionarFuncionario(funcionario, Integer.parseInt((String)sessao.getAttribute("admRest")));
			return this.buildResponse("Funcionário cadastrado com sucesso.");
		} catch (HamburgueriaException | IOException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

	@GET
	@Path("buscarFuncionariosPorNome/{nome}")
	@Produces({MediaType.APPLICATION_JSON })
	public Response buscarFuncionariosPorNome(@PathParam("nome") String nome) throws PermissaoException {
		try {
			FuncionarioService service = new FuncionarioService();
			if(nome.equals("null")){
				nome = "";
			}
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(service.buscarFuncionarioPorNome(nome, Integer.parseInt((String)sessao.getAttribute("funcionario"))));
		} catch (HamburgueriaException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}		
	}
	
	
	@DELETE
	@Path("/deletarFuncionario/{id}")
	@Consumes("application/*")
	public Response deletarFuncionario(@PathParam("id") int id) throws PermissaoException {
		try{
			FuncionarioService funcionarioService = new FuncionarioService();
			HttpSession sessao = req.getSession(false);
			funcionarioService.deletarFuncionario(id,  Integer.parseInt((String)sessao.getAttribute("admRest")));			
			return this.buildResponse("Funcionário está inativo a partir de agora!");
		}catch(HamburgueriaException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Path("/buscarFuncionarioPeloId/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response buscarFuncionarioPeloId(@PathParam("id")int id) throws PermissaoException{
		try{
			FuncionarioService funcionarioService = new FuncionarioService();
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(funcionarioService.buscarFuncionarioPorId(id,  Integer.parseInt((String)sessao.getAttribute("funcionario"))));
		}catch(HamburgueriaException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@PUT
	@Path("/editarFuncionario")
	@Consumes("application/*")
	public Response editarFuncionario(String funcionarioParam) throws PermissaoException{
		try{
			Funcionario funcionario = new ObjectMapper().readValue(funcionarioParam, Funcionario.class);
			FuncionarioService service = new FuncionarioService();
			HttpSession sessao = req.getSession(false);
			service.atualizarFuncionario(funcionario, Integer.parseInt((String)sessao.getAttribute("funcionario")));			
			return this.buildResponse("Funcionário editado com sucesso.");
		}catch(HamburgueriaException | IOException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}