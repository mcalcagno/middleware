package grupo01.ws.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.MTOM;

import grupo01.database.Confirmacion;
import grupo01.database.Manejador;
import grupo01.ws.data.EntradaData;
import grupo01.ws.interfaces.ConfirmarReservaEntradas;

@MTOM
@WebService(targetNamespace = "http://ws.grupo01/", portName = "ConfirmarReservaEntradasPort", serviceName = "ConfirmarReservaEntradasService")
public class ConfirmarReservaEntradasImpl implements ConfirmarReservaEntradas{

	public ConfirmarReservaEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@WebResult(name="entrada")
	@WebMethod(operationName = "confirmarReservaVenta", action = "urn:ConfirmarReservaVenta")
	@ResponseWrapper(targetNamespace="http://ws.grupo01/",localName="notificacionConfirmacionReserva")
	@Action(
			output="http://ws.grupo01/CallbackWsImpl/notificacionConfirmacionReserva")
	@Override
	public EntradaData confirmarReservaVenta(@WebParam(name = "idReserva") Long idReserva, @WebParam(name = "medioPago") Long idMedioPago,
			@WebParam(name = "nroTarjeta") String nroTarjeta, @WebParam(name = "fechaVenc") Date fechaVenc,@WebParam(name = "digitoVerificador")  Integer digitoVerificador) {
		
		Confirmacion conf = Manejador.confirmarReserva(idReserva);
		Manejador.crearMedioPago(idReserva,idMedioPago,nroTarjeta,fechaVenc,digitoVerificador);
		EntradaData entrada =new EntradaData( conf.getId());
		File ent1File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent1.jpg");
		File ent2File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent2.jpg");
		File ent3File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent3.png");
		try {
			Image ent1Img = ImageIO.read(ent1File);
			Image ent2Img = ImageIO.read(ent2File);
			Image ent3Img = ImageIO.read(ent3File);
			entrada.getImagenes().add(ent1Img);
			entrada.getImagenes().add(ent2Img);
			entrada.getImagenes().add(ent3Img);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entrada;
	}

	
}
