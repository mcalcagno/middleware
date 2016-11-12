package grupo01.ws.impl;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.ResponseWrapper;

import grupo01.database.Confirmacion;
import grupo01.database.Manejador;
import grupo01.ws.interfaces.ConfirmarReservaEntradas;

@WebService(targetNamespace = "http://ws.grupo01/", portName = "ConfirmarReservaEntradasPort", serviceName = "ConfirmarReservaEntradasService")
public class ConfirmarReservaEntradasImpl implements ConfirmarReservaEntradas{

	public ConfirmarReservaEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@WebResult(name="notificacionConfirmacionReserva")
	@WebMethod(operationName = "confirmarReservaVenta", action = "urn:ConfirmarReservaVenta")
	@ResponseWrapper(targetNamespace="http://ws.grupo01/",localName="notificacionConfirmacionReserva")
	@Action(
			output="http://ws.grupo01/CallbackWsImpl/notificacionConfirmacionReserva")
	@Override
	public Long confirmarReservaVenta(@WebParam(name = "idReserva") Long idReserva, @WebParam(name = "medioPago") Long idMedioPago,
			@WebParam(name = "nroTarjeta") String nroTarjeta, @WebParam(name = "fechaVenc") Date fechaVenc,@WebParam(name = "digitoVerificador")  Integer digitoVerificador) {
		
		Confirmacion conf = Manejador.confirmarReserva(idReserva);
		Manejador.crearMedioPago(idReserva,idMedioPago,nroTarjeta,fechaVenc,digitoVerificador);
		return idReserva;
		
	}

	
}
