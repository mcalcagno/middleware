package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.ws.interfaces.ConsultarEstadoReserva;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEstadoReservaImplPort", serviceName = "ConsultarEstadoReservaImplService")
public class ConsultarEstadoReservaImpl implements ConsultarEstadoReserva{

	public ConsultarEstadoReservaImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "consultarEstadoReserva", action = "urn:ConsultarEstadoReserva")
	@Override
	public void consultarEstadoReserva(@WebParam(name = "idReserva") String idReserva) {
		// TODO Auto-generated method stub
		
	}


}
