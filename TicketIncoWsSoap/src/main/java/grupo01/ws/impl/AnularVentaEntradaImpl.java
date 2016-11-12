package grupo01.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import grupo01.database.Manejador;
import grupo01.ws.interfaces.AnularVentaEntrada;

@WebService(targetNamespace = "http://ws.grupo01/", portName = "AnularVentaEntradaPort", serviceName = "AnularVentaEntradaService")
public class AnularVentaEntradaImpl implements AnularVentaEntrada{

	public AnularVentaEntradaImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebMethod(operationName = "anularVentaEntrada", action = "urn:AnularVentaEntrada")
	@Override
	public Long anularVentaEntrada(@WebParam(name = "idCoonfirmacion") Long idConfirmacion,
			@WebParam(name = "idMedioPago") Long idMedioPago) {
		return Manejador.createAnulacion(idConfirmacion).getId();
	}

	
	
}
