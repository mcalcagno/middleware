package esb.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import esb.dto.RequestAnulacionMedioPagoLocalData;
import esb.dto.RequestConfirmacionMedioPagoLocalData;
import esb.dto.ResponseAnulacionMedioPagoLocalData;
import esb.dto.ResponseConfirmacionMedioPagoLocalData;

@WebService(name = "IConfirmadorMedioPagoLocal")
public interface IConfirmadorMedioPagoLocal {
	
	@WebMethod(action = "confirmarPago", operationName = "confirmarPago")
	public ResponseConfirmacionMedioPagoLocalData confirmarPago(@WebParam(name = "req") RequestConfirmacionMedioPagoLocalData req);
	
	@WebMethod(action = "anularPago", operationName = "anularPago")
	public ResponseAnulacionMedioPagoLocalData anularPago(@WebParam(name = "req") RequestAnulacionMedioPagoLocalData req);

}
