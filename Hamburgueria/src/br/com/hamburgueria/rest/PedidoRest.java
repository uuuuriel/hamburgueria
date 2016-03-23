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

import com.google.gson.Gson;

import br.com.hamburgueria.exception.AdicionarProdutoException;
import br.com.hamburgueria.exception.FinalizarPedidoException;
import br.com.hamburgueria.exception.HamburgueriaException;
import br.com.hamburgueria.service.PedidoService;

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
			throw new AdicionarProdutoException();
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
			throw new FinalizarPedidoException();
		}
	}
	

	@POST
	@Path("/finalizarPedidoFuncionario/{codcliente}")
	@Produces("application/json")
	public void finalizarPedidoFuncionario(@PathParam("codcliente") int codcliente) throws HamburgueriaException {
		try{
			System.out.println(codcliente);
			HttpSession sessao = req.getSession(false);
			PedidoService pedido = new PedidoService();
			pedido.finalizarPedidoFuncionario((String)sessao.getAttribute("produto"), (int)sessao.getAttribute("cod"), codcliente);
			sessao.setAttribute("produto", null);	
		}catch(Exception e){
			e.printStackTrace();
			throw new FinalizarPedidoException();
		}
	}
	
}