package br.com.hamburgueria.rest;

import java.sql.Date;

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

import br.com.hamburgueria.exception.AdicionarProdutoException;
import br.com.hamburgueria.exception.FinalizarPedidoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.exception.PermissaoException;
import br.com.hamburgueria.objs.AjustaFinalizarPedido;
import br.com.hamburgueria.objs.ClienteNovo;
import br.com.hamburgueria.objs.Pedido;
import br.com.hamburgueria.service.PedidoService;

@Path("Pedido")
public class PedidoRest extends UtilRest{

	@Context
	private HttpServletRequest req;
	
	@POST
	@Path("/ajustarFinalizar")
	@Consumes("application/*")
	public void ajustarFinalizar(String pedido) throws HamburgueriaException{
		try{
			AjustaFinalizarPedido[] ped = new ObjectMapper().readValue(pedido,AjustaFinalizarPedido[].class);
			HttpSession sessao = req.getSession(false);
			sessao.setAttribute("produto", null);
			int conta = 0;
			boolean x = true;
			for (int i = 0; i < ped.length; i++) {
				conta = ped[i].getQtde();
				while(conta > 0){
					if(x){
						sessao.setAttribute("produto", ped[i].getCod() + ",");
						x = false;
						conta = conta - 1;
					}else{
						String produtos = (String)sessao.getAttribute("produto") != null ? (String)sessao.getAttribute("produto")  : "";
						sessao.setAttribute("produto", ped[i].getCod() + "," + produtos);
						conta = conta - 1;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new FinalizarPedidoException();
		}
	}
	
	@POST
	@Path("/addProduto/{produto}")
	@Produces("application/json")
	public void pedido(@PathParam("produto") String produto) throws HamburgueriaException {
		try{
			HttpSession sessao = req.getSession(false);
			String produtos = (String)sessao.getAttribute("produto") != null ? (String)sessao.getAttribute("produto")  : "";
			sessao.setAttribute("produto",  produto + "," + produtos);
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
			ped.setCodcliente(Integer.parseInt((String)sessao.getAttribute("cod")));
			pedidoService.finalizarPedido((String)sessao.getAttribute("produto"), ped, Integer.parseInt((String)sessao.getAttribute("log")));
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
			ped.setCodfunc(Integer.parseInt((String)sessao.getAttribute("cod")));
			PedidoService pedidoService = new PedidoService();
			pedidoService.finalizarPedidoFuncionario((String)sessao.getAttribute("produto"), ped, Integer.parseInt((String)sessao.getAttribute("funcionario")));
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
			user.setCodfunc(Integer.parseInt((String)sessao.getAttribute("cod")));
			pedido.finalizarPedidoFuncionarioNovo((String)sessao.getAttribute("produto"), user, Integer.parseInt((String)sessao.getAttribute("funcionario")));
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
			@PathParam("datafim")Date datafim) throws PermissaoException {	
		try {
			
			PedidoService pedido = new PedidoService();
			if(busca.equals("null")){
				busca = "";
			}
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(pedido.listarPedidos(busca, dataini, datafim, Integer.parseInt((String)sessao.getAttribute("funcionario")) != 1 ? Integer.parseInt((String) sessao.getAttribute("cod")) : 0));

		} catch (HamburgueriaException e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}		
	}
	
	@PUT
	@Path("/atualizarEstagioPedido/{estagio}/{codpe}/{codpr}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response atualizarEstagioPedido(@PathParam("estagio") int estagio, @PathParam("codpe") int codpe
			, @PathParam("codpr") int codpr) throws PermissaoException {
		try{
			PedidoService pedido = new PedidoService();
			HttpSession sessao = req.getSession(false);
			pedido.atualizarEstagioPedido(estagio, codpe, codpr, Integer.parseInt((String)sessao.getAttribute("funcionario")));
			return this.buildResponse("Pedido está no próximo estágio.");
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@DELETE
	@Path("/cancelarPedido/{cod}/{cancelado}")
	@Consumes("application/*")
	public Response deletar(@PathParam("cod") int cod, @PathParam("cancelado") String cancelado) throws PermissaoException {
		try{
			PedidoService pedido = new PedidoService();
			return this.buildResponse(pedido.cancelarPedido(cod, cancelado) ? true : false);
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		
	}
	
	@DELETE
	@Path("/verificaCancelarPedido/{cod}")
	@Consumes("application/*")
	public Response verificaDeletar(@PathParam("cod") int cod) throws PermissaoException {
		try{
			PedidoService pedido = new PedidoService();
			return this.buildResponse(pedido.validaCancelarPedido(cod) ? true : false);
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		
	}
	
	@POST
	@Path("/listarProdutosEstagio/{cod}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarPedidoEstagio(@PathParam("cod")int cod) throws PermissaoException{
		try{
			PedidoService pedido = new PedidoService();
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(pedido.listarProdutosEstagio(cod, Integer.parseInt((String)sessao.getAttribute("funcionario"))));
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
		
	}
	
	@GET
	@Path("/listarPedidoEntrega/")
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarPedidoEntrega() throws PermissaoException{
		try{
			PedidoService pedido = new PedidoService();
			return this.buildResponse(pedido.listarPedidoEntrega());
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@POST
	@Path("/pedidoEntrega/{cod}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response pedidoEntrega(@PathParam("cod")int cod){
		try{
			PedidoService pedido = new PedidoService();
			HttpSession sessao = req.getSession(false);
			pedido.pedidoEntregue(cod, Integer.parseInt((String)sessao.getAttribute("funcionario")));
			return this.buildResponse("Pedido entregue.");
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Path("/relatorioVenda/{dataini}/{datafim}/{busca}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response relatorioVenda(@PathParam("dataini")Date dataini,
			@PathParam("datafim")Date datafim,
			@PathParam("busca")String busca) throws PermissaoException{
		try{
			if(busca.equals("null")){
				busca = "";
			}
			PedidoService pedido = new PedidoService();
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(pedido.relatorioVenda(dataini, datafim, busca, Integer.parseInt((String)sessao.getAttribute("funcionario"))));
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
	
	@GET
	@Path("/pedidosUsuario")
	@Produces({MediaType.APPLICATION_JSON})
	public Response pedidosUsuario() {
		try{
			PedidoService pedido = new PedidoService();
			HttpSession sessao = req.getSession(false);
			return this.buildResponse(pedido.pedidosUsuario(Integer.parseInt((String) sessao.getAttribute("cod")), Integer.parseInt((String)sessao.getAttribute("log"))));
		}catch(Exception e){
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}