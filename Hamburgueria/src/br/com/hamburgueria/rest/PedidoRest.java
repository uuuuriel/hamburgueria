package br.com.hamburgueria.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Pedido;
import br.com.hamburgueria.service.FuncionarioService;
import br.com.hamburgueria.service.PedidoService;

@Path("funcionarioRest")
public class PedidoRest extends UtilRest {
	
	public PedidoRest() {
	}
	@POST
	@Path("/novo")
	@Consumes("application/*")
	public Response novoPedido(int[] pedido) {
		try {
			
			/*PedidoService service = new PedidoService();
			service.novoPedido(pede);*/
			return this.buildResponse("Funcionário cadastrado com sucesso.");
		} catch (HamburgueriaException | IOException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}