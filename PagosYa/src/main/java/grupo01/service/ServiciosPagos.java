package grupo01.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import grupo01.dto.RequestAnulacionPagosYaData;
import grupo01.dto.RequestConfirmacionPagosYaData;
import grupo01.dto.ResponseAnulacionPagosYaData;
import grupo01.dto.ResponseConfirmacionPagosYaData;
import grupo01.helper.PagosHelper;

@Path("/pagos")
public class ServiciosPagos {
	
	PagosHelper pagosHelper = new PagosHelper();
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("/pagos")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response recibirPago(RequestConfirmacionPagosYaData pagoData) {
		ResponseConfirmacionPagosYaData resultado = pagosHelper.procesarPago(pagoData);
		System.out.println("pagoData.getDigitoVerif()"+pagoData.getDigitoVerif());
		System.out.println("Entro al WS REST!");
		return Response.status(200).type(MediaType.APPLICATION_XML).entity(resultado).build();
	}

	@PUT
	@Path("/pagos")
	@Consumes({MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_XML})
	public Response anularPago(RequestAnulacionPagosYaData requestAnulacionPagosYaData) {
		ResponseAnulacionPagosYaData resultado = pagosHelper.anularPago(requestAnulacionPagosYaData);
		return Response.status(200).type(MediaType.APPLICATION_XML).entity(resultado).build();
	}

}
