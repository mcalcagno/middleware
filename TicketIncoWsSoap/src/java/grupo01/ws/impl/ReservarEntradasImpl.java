package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.ws.interfaces.ReservarEntradas;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ReservarEntradasImplPort", serviceName = "ReservarEntradasImplService")
public class ReservarEntradasImpl implements ReservarEntradas{

	public ReservarEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "reservarEntradas", action = "urn:ReservarEntradas")
	@Override
	public String reservarEntradas(@WebParam(name = "espectaculo") String espectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
