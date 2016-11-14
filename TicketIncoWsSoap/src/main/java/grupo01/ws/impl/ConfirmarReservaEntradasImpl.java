package grupo01.ws.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;
import javax.xml.ws.Action;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.soap.MTOM;

import org.apache.cxf.binding.corba.wsdl.Exception;

import grupo01.database.Confirmacion;
import grupo01.database.Manejador;
import grupo01.database.Reserva;
import grupo01.ws.data.Constantes;
import grupo01.ws.data.EntradaData;
import grupo01.ws.esb.PagoExternoEsb;
import grupo01.ws.esb.PagoLocalEsb;
import grupo01.ws.fault.NoExisteReservaException;
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
			@WebParam(name = "nroTarjeta") String nroTarjeta, @WebParam(name = "fechaVenc") Date fechaVenc,@WebParam(name = "digitoVerificador")  Integer digitoVerificador) throws NoExisteReservaException {
		
		
		EntradaData entrada = null;
		try {
			Reserva reserva = Manejador.getReserva(idReserva);
			if (reserva != null){
			
			Double monto = Manejador.getMontoReserva(idReserva); 	
				
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaVenc);
			if (idMedioPago == Constantes.MEDIO_PAGO_EXTERNO){
				PagoExternoEsb pagoExt = new PagoExternoEsb();
				pagoExt.confirmarPago(digitoVerificador,cal, idReserva, monto, new Long(nroTarjeta));
			} else {
				PagoLocalEsb pagoLocal = new PagoLocalEsb();
				pagoLocal.confirmarPago(String.valueOf(digitoVerificador), String.valueOf(fechaVenc.getYear())+"-"+String.valueOf(fechaVenc.getMonth())+"-"+String.valueOf(fechaVenc.getDay()), idReserva, String.valueOf(monto), String.valueOf(nroTarjeta)); 
			}
			Confirmacion conf = Manejador.confirmarReserva(idReserva);
			Manejador.crearMedioPago(idReserva,idMedioPago,nroTarjeta,fechaVenc,digitoVerificador);
			entrada = new EntradaData( conf.getId());
			File ent1File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent1.jpg");
			File ent2File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent2.jpg");
			File ent3File = new File("C:\\obligatorio1\\middleware\\TicketIncoWsSoap\\src\\main\\resources\\images\\ent3.png");
			Image ent1Img = ImageIO.read(ent1File);
			Image ent2Img = ImageIO.read(ent2File);
			Image ent3Img = ImageIO.read(ent3File);
			entrada.getImagenes().add(ent1Img);
			entrada.getImagenes().add(ent2Img);
			entrada.getImagenes().add(ent3Img);
			} else {
				// error no existe reserva
				throw new NoExisteReservaException("No existe Reserva: "+idReserva.toString());
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ServiceException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al invocar el esb");
			e.printStackTrace();
		}
		return entrada;
	}


	

	
}
