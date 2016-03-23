package br.com.hamburgueria.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.service.PedidoService;

import com.google.gson.Gson;

@Path("Pedido")
public class PedidoRest {

	@Context
	private HttpServletRequest req;
	
	@POST
	@Path("/listaPedido/{produto}")
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
			return null;
		}
	}
	
	@POST
	@Path("/finalizar")
	public void finalizarPedido() throws HamburgueriaException{
		try{
			HttpSession sessao = req.getSession(false);
			PedidoService pedido = new PedidoService();
			pedido.finalizarPedido((String)sessao.getAttribute("produto"), (int)sessao.getAttribute("cod"));
			sessao.setAttribute("produto", null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@POST
	@Path("/finalizarPedidoFuncionaroi/{produto}")
	@Produces("application/json")
	public String finalizarPedidoFuncionario(@PathParam("codcliente") int codcliente) throws HamburgueriaException {
		try{
			HttpSession sessao = req.getSession(false);
			PedidoService pedido = new PedidoService();
			pedido.finalizarPedidoFuncionario((String)sessao.getAttribute("produto"), (int)sessao.getAttribute("cod"), codcliente);
			sessao.setAttribute("produto", null);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
}