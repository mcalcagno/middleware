package esb.ws;

import javax.jws.WebService;

import esb.dto.RequestAnulacionPagosYaData;
import esb.dto.RequestConfirmacionPagosYaData;

@WebService(endpointInterface = "esb.ws.IPagosYaConfirmadorPagos.java", name = "IPagosYaConfirmadorPagos")
public class PagosYaConfirmadorPagos implements IPagosYaConfirmadorPagos{
	
	@Override
	public RequestConfirmacionPagosYaData confirmarPago(RequestConfirmacionPagosYaData req){
		System.out.println("HOLAAAAAAAAAAAAAAA confirmarPago");
		return req;
	}

	@Override
	public RequestAnulacionPagosYaData cancelarPago(RequestAnulacionPagosYaData idConfirmacionPago){
		System.out.println("HOLAAAAAAAAAAAAAAA cancelarPago");
		return idConfirmacionPago;
	}

}
