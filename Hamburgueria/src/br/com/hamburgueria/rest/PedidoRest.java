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
			sessao.setAttribute("produto", (String)sessao.getAttribute("produto") + "," + produto);
			Map<String, String> msg = new HashMap<String, String>();
			msg.put("produto", (String)sessao.getAttribute("produto"));
			String json = new Gson().toJson(msg);
			return json;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
