package grupo01.ws.impl;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.database.Horario;
import grupo01.database.Manejador;
import grupo01.ws.interfaces.ConsultarEntradas;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEntradasImplPort", serviceName = "ConsultarEntradasImplService")
public class ConsultarEntradasImpl implements ConsultarEntradas{

	public ConsultarEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "consultarEntradasDisponibles", action = "urn:ConsultarEntradasDisponibles")
	@Override
	public List<Horario> consultarEntradasDisponibles(@WebParam(name = "idEvento") Integer idEvento,
			@WebParam(name = "fecha") Date fecha) {
		return Manejador.getEvento(idEvento).getHorarios();
	}

	
	
}
