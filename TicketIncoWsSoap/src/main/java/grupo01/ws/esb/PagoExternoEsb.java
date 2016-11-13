package grupo01.ws.esb;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

import esb.ws.IPagosYaConfirmadorPagos;
import esb.ws.IPagosYaConfirmadorPagosService;
import esb.ws.IPagosYaConfirmadorPagosServiceLocator;
import esb.ws.RequestAnulacionPagosYaData;
import esb.ws.RequestConfirmacionPagosYaData;
import esb.ws.ResponseAnulacionPagosYaData;

public class PagoExternoEsb {

	public PagoExternoEsb() {
		// TODO Auto-generated constructor stub
	}

	public void confirmarPago(Integer digitoVerif, Calendar fechaVenc, Long idReserva, Double monto, Long nroTarjeta) throws ServiceException, RemoteException{

		//Invocar medio pago externo
		RequestConfirmacionPagosYaData req = new RequestConfirmacionPagosYaData(digitoVerif, fechaVenc,idReserva, monto, nroTarjeta);
		IPagosYaConfirmadorPagosService a = new IPagosYaConfirmadorPagosServiceLocator();

		//confirmar pago

		System.out.println("Invocando medio pago externo - confirmarPago - Inicio...");
		IPagosYaConfirmadorPagos b = a.getIPagosYaConfirmadorPagosPort();
		b.confirmarPago(req);
		System.out.println("Invocando medio pago externo - confirmarPago - Fin...");

	}
	
	public Long cancelarPago(Long idPago) throws ServiceException, RemoteException{
		//Invocar medio pago externo
		RequestAnulacionPagosYaData req = new RequestAnulacionPagosYaData(idPago);
		IPagosYaConfirmadorPagosService a = new IPagosYaConfirmadorPagosServiceLocator();

		//confirmar pago		
		System.out.println("Invocando medio pago externo - cancelarPago - Inicio...");
		IPagosYaConfirmadorPagos b = a.getIPagosYaConfirmadorPagosPort();
		ResponseAnulacionPagosYaData anulacion =  b.cancelarPago(req);
		System.out.println("Invocando medio pago externo - cancelarPago - Fin...");		
		
		return anulacion.getIdAnulacionPago();
	}
}
