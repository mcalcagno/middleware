package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.ws.interfaces.ConfirmarReservaEntradas;

@WebService(targetNamespace = "http://ws.grupo01/", portName = "ConfirmarReservaEntradasPort", serviceName = "ConfirmarReservaEntradasService")
public class ConfirmarReservaEntradasImpl implements ConfirmarReservaEntradas{

	public ConfirmarReservaEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "confirmarReservaVenta", action = "urn:ConfirmarReservaVenta")
	@Override
	public void confirmarReservaVenta(@WebParam(name = "arg0") String idReserva) {
		// TODO Auto-generated method stub
		
	}

	
}
