package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import grupo01.database.Manejador;
import grupo01.database.Reserva;
import grupo01.ws.fault.NoExisteReservaException;
import grupo01.ws.interfaces.ConsultarEstadoReserva;


@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEstadoReservaImplPort", serviceName = "ConsultarEstadoReservaImplService")
public class ConsultarEstadoReservaImpl implements ConsultarEstadoReserva{

	public ConsultarEstadoReservaImpl() {
		
	}

	@WebResult(name = "estadoReserva")
	@WebMethod(operationName = "consultarEstadoReserva", action = "urn:ConsultarEstadoReserva")
	@Override
	public Integer consultarEstadoReserva(@WebParam(name = "idReserva") Long idReserva) throws NoExisteReservaException {
		
		Reserva reserva = Manejador.getReserva(idReserva); 
		Integer estado = -1;
		if (reserva != null){
			estado = reserva.getEstado();
		} else {
			// error no existe reserva
			throw new NoExisteReservaException("No existe la reserva: "+idReserva.toString());
		}
		
		return estado;
		
	}


}
