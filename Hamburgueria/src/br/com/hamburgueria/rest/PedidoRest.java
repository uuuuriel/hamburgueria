package br.com.hamburgueria.rest;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.hamburgueria.exception.AdicionarProdutoException;
import br.com.hamburgueria.exception.FinalizarPedidoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.objs.ClienteNovo;
import br.com.hamburgueria.objs.Pedido;
import br.com.hamburgueria.service.PedidoService;

import com.google.gson.Gson;

@Path("Pedido")
public class PedidoRest extends UtilRest{

	@Context
	private HttpServletRequest req;
	
	@POST
	@Path("/addProduto/{produto}")
	@Produces("application/json")
	public String pedido(@PathParam("produto") String produto) throws HamburgueriaException {
		try{
			HttpSession sessao = req.getSession(false);
			String produtos = (String)sessao.getAttribute("produto") != null ? (String)sessao.getAttribute("produto")  : "";
			sessao.setAttribute("produto",  produto + "," + produtos);
			//DELETAR DEPOIS
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("produto", (String)sessao.getAttribute("produto"));
			String json = new Gson().toJson(msg);
			return json;
			//DELETAR DEPOIS
		}catch(Exception e){
			e.printStackTrace();
			throw new AdicionarProdutoException();
		}
	}
	
	@POST
	@Path("/finalizar")
	@Consumes("application/*")
	public void finalizarPedido(String pedido) throws HamburgueriaException{
		try{
			Pedido ped = new ObjectMapper().readValue(pedido,Pedido.class);
			HttpSession sessao = req.getSession(false);
			PedidoService pedidoService = new PedidoService();
			ped.setCodcliente((int)sessao.getAttribute("cod"));
			pedidoService.finalizarPedido((String)sessao.getAttribute("produto"), ped);
			sessao.setAttribute("produto", null);
		}catch(Exception e){
			e.printStackTrace();
			throw new FinalizarPedidoException();
		}
	}
	

	@POST
	@Path("/finalizarPedidoFuncionario")
	@Consumes("application/*")
	public Response finalizarPedidoFuncionario(String pedido) throws HamburgueriaException {
		try{
			Pedido ped = new ObjectMapper().readValue(pedido,Pedido.class);
			HttpSession sessao = req.getSession(false);
			ped.setCodfunc((int)sessao.getAttribute("cod"));
			PedidoService pedidoService = new PedidoService();
			pedidoService.finalizarPedidoFuncionario((String)sessao.getAttribute("produto"), ped);
			sessao.setAttribute("produto", null);	
			return this.buildResponse("Pedido finalizado com sucesso.");
		}catch(Exception e){
			e.printStackTrace();
			throw new FinalizarPedidoException();
		}
	}
	
	@POST
	@Path("/finalizarPedidoFuncionarioNovo")
	@Consumes("application/*")
	public Response finalizarPedidoFuncionarioNovo(String usuario) throws HamburgueriaException {
		try{
			ClienteNovo user = new ObjectMapper().readValue(usuario,ClienteNovo.class);
			HttpSession sessao = req.getSession(false);
			PedidoService pedido = new PedidoService();
			user.setCodfunc((int)sessao.getAttribute("cod"));
			pedido.finalizarPedidoFuncionarioNovo((String)sessao.getAttribute("produto"), user);
			sessao.setAttribute("produto", null);	
			return this.buildResponse("Pedido finalizado com sucesso.");
		}catch(Exception e){
			e.printStackTrace();
			throw new FinalizarPedidoException();
		}
	}
	
	@GET
	@Path("listarPedidos/{busca}/{dataini}/{datafim}")
	@Produces({MediaType.APPLICATION_JSON })
	public Response listarPedidos(@PathParam("busca") String busca,
			@PathParam("dataini")Date dataini,
			@PathParam("datafim")Date datafim) {
		try {
			PedidoService pedido = new PedidoService();
			if(busca.equals("null")){
				busca = "";
			}
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(pedido.listarPedidos(busca, dataini, datafim, (int)sessao.getAttribute("administrador") != 1 ? (int)sessao.getAttribute("cod") : 0));

		} catch (HamburgueriaException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}		
	}
	
	@PUT
	@Path("/atualizarEstagioPedido/{estagio}/{codpe}/{codpr}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response atualizarEstagioPedido(@PathParam("estagio") int estagio, @PathParam("codpe") int codpe
			, @PathParam("codpr") int codpr) {
		try{
			PedidoService pedido = new PedidoService();
			pedido.atualizarEstagioPedido(estagio, codpe, codpr);
			return this.buildResponse("Pedido está no próximo estágio.");
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@DELETE
	@Path("/cancelarPedido/{cod}/{cancelado}")
	@Consumes("application/*")
	public Response deletar(@PathParam("cod") int cod, @QueryParam("cancelado") String cancelado) {
		try{
			PedidoService pedido = new PedidoService();
			return this.buildResponse(pedido.cancelarPedido(cod, cancelado) ? "success" : "");
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		
	}
	
	@POST
	@Path("/listarProdutosEstagio/{cod}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarPedidoEstagio(@PathParam("cod")int cod){
		try{
			PedidoService pedido = new PedidoService();
			return this.buildResponse(pedido.listarProdutosEstagio(cod));
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		
	}
	
}