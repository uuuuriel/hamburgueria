package br.com.hamburgueria.rest;

import java.sql.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hamburgueria.service.GraficoService;

@Path("Grafico")
public class GraficoRest extends UtilRest{
	@GET
	@Path("/venda/{dataini}/{datafim}")
	@Produces({MediaType.APPLICATION_JSON })
	public Response venda(@PathParam("dataini")Date dataini, @PathParam("datafim")Date datafim) {
		try {
			GraficoService grafico = new GraficoService();
			return this.buildResponse(grafico.venda(dataini, datafim));
		} catch (Exception e) {
			e.printStackTrace();
			return this.buildErrorResponse(e.getMessage());
		}
	}
}
