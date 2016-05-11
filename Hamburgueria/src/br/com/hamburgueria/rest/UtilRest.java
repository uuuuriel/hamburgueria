package br.com.hamburgueria.rest;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;

public class UtilRest {
	public Response buildResponse(Object result) {
		StringWriter fw = new StringWriter();
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(fw, result);
			return Response.ok(fw.toString()).build();
		} catch (Exception ex) {
			return this.buildErrorResponse(ex.getMessage());
		}
	}
	public Response buildErrorResponse(String str) {
		ResponseBuilder rb = Response
				.status(Response.Status.INTERNAL_SERVER_ERROR);
		rb = rb.entity(str);
		rb = rb.type("text/plain");
		return rb.build();
	}
	
	@Context
	private HttpServletRequest req;
	
	public String getSessao(String parametro){
		HttpSession sessao = req.getSession(false);
		String variSessao = "";
		try{
			variSessao = (String)sessao.getAttribute(parametro);
		}catch(Exception e){ 
			variSessao = Integer.toString((int)sessao.getAttribute(parametro));
		}finally{
			return variSessao;
		}
	}
}