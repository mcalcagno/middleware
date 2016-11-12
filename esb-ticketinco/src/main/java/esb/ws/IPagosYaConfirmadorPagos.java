package esb.ws;

import javax.jws.WebService;

import esb.dto.RequestAnulacionPagosYaData;
import esb.dto.RequestConfirmacionPagosYaData;

import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(name = "IPagosYaConfirmadorPagos")
public interface IPagosYaConfirmadorPagos {
	
	@WebMethod(action = "confirmarPago", operationName = "confirmarPago")
	public RequestConfirmacionPagosYaData confirmarPago(@WebParam(name = "req") RequestConfirmacionPagosYaData req);

	@WebMethod(action = "cancelarPago", operationName = "cancelarPago")
	public RequestAnulacionPagosYaData cancelarPago(@WebParam(name = "idConfirmacionPago") RequestAnulacionPagosYaData req);
}
