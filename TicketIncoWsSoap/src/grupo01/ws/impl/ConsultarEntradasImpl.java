package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.ws.interfaces.ConsultarEntradas;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEntradasImplPort", serviceName = "ConsultarEntradasImplService")
public class ConsultarEntradasImpl implements ConsultarEntradas{

	public ConsultarEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "consultarEntradasDisponibles", action = "urn:ConsultarEntradasDisponibles")
	@Override
	public Integer consultarEntradasDisponibles(@WebParam(name = "arg0") String espetaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
