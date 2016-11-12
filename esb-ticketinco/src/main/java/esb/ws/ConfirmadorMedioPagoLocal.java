package esb.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import esb.dto.RequestAnulacionMedioPagoLocalData;
import esb.dto.RequestConfirmacionMedioPagoLocalData;

@WebService(endpointInterface = "esb.ws.IConfirmadorMedioPagoLocal", name = "IConfirmadorMedioPagoLocal", targetNamespace="http://ws.esb/")
public class ConfirmadorMedioPagoLocal implements IConfirmadorMedioPagoLocal{
	
	@Override
	public RequestConfirmacionMedioPagoLocalData confirmarPago(@WebParam(name = "req") RequestConfirmacionMedioPagoLocalData req){
		System.out.println("Se invoco al WS de confirmarPago en medio de pago local");
		return req;
	}
	
	@Override
	public RequestAnulacionMedioPagoLocalData anularPago(@WebParam(name = "req") RequestAnulacionMedioPagoLocalData req){
		System.out.println("Se invoco al WS de anularPago en medio de pago local");
		return req;
	}


}
