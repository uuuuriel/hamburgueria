package br.com.hamburgueria.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.Cliente;
import br.com.hamburgueria.service.ClienteService;

@Path("UsuarioRest")
public class ClienteRest extends UtilRest {
	
	public ClienteRest() {
	}
	@POST
	@Path("/addUsuario")
	@Consumes("application/*")
	public Response addUsuario(String UsuarioParam) {
		try {
			Cliente user = new ObjectMapper().readValue(UsuarioParam,Cliente.class);
			ClienteService service = new ClienteService();
			System.out.println(user.getAtivo());
			service.adicionarUsuario(user);
			return this.buildResponse("Usuário cadastrado com sucesso.");
		} catch (HamburgueriaException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}

	@GET
	@Path("buscarUsuariosPorNome/{nome}")
	@Produces({MediaType.APPLICATION_JSON })
	public Response buscarUsuariosPorNome(@PathParam("nome") String nome) {
		try {
			ClienteService service = new ClienteService();
			if(nome.equals("null")){
				nome = "";
			}
			return this.buildResponse(service.buscarUsuarioPorNome(nome));
		} catch (HamburgueriaException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	
	@PUT
	@Path("/deletarUsuario/{id}")
	@Consumes("application/*")
	public Response deletarUsuario(@PathParam("id") int id) {
		try{
			ClienteService service = new ClienteService();
			service.deletarUsuario(id);			
			return this.buildResponse("Usuário deletado com sucesso!");
		}catch(HamburgueriaException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Path("/buscarUsuarioPeloId/{id}")
	@Produces({ MediaType.APPLICATION_JSON})
	public Response buscarUsuarioPeloId(@PathParam("id")int id){
		try{
			ClienteService service = new ClienteService();
			return this.buildResponse(service.buscarUsuarioPorId(id));
		}catch(HamburgueriaException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		} catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@PUT
	@Path("/editarUsuario")
	@Consumes("application/*")
	public Response editarUsuario(String usuarioParam){
		try{
			Cliente user = new ObjectMapper().readValue(usuarioParam, Cliente.class);
			ClienteService service = new ClienteService();
			System.out.println(user.getAtivo());
			service.atualizarUsuario(user);			
			return this.buildResponse("Usuário editado com sucesso.");
		}catch(HamburgueriaException e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}