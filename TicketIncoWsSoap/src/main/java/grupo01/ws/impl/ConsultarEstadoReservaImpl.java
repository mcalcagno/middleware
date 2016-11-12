package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import grupo01.database.Manejador;
import grupo01.ws.interfaces.ConsultarEstadoReserva;


@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEstadoReservaImplPort", serviceName = "ConsultarEstadoReservaImplService")
public class ConsultarEstadoReservaImpl implements ConsultarEstadoReserva{

	public ConsultarEstadoReservaImpl() {
		
	}

	@WebResult(name = "estadoReserva")
	@WebMethod(operationName = "consultarEstadoReserva", action = "urn:ConsultarEstadoReserva")
	@Override
	public Integer consultarEstadoReserva(@WebParam(name = "idReserva") Long idReserva) {
		
		
		return Manejador.getReserva(idReserva).getEstado();
		
	}


}
