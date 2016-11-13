package grupo01.ws.esb;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import esb.ws.IConfirmadorMedioPagoLocal;
import esb.ws.IConfirmadorMedioPagoLocalService;
import esb.ws.IConfirmadorMedioPagoLocalServiceLocator;
import esb.ws.RequestMedioPagoLocalData;

public class PagoLocalEsb {

	public PagoLocalEsb() {
	}

	public void confirmarPago(String digitoVerif, String fechaVenc, Long idReserva, String monto, String nroTarjeta) throws ServiceException, RemoteException{

		RequestMedioPagoLocalData req = new RequestMedioPagoLocalData(digitoVerif, fechaVenc,idReserva, monto, nroTarjeta);

		IConfirmadorMedioPagoLocalService a = new IConfirmadorMedioPagoLocalServiceLocator();

		//confirmar pago
		System.out.println("Invocando medio pago local - confirmarPago - Inicio...");
		IConfirmadorMedioPagoLocal b = a.getIConfirmadorMedioPagoLocalPort();
		b.confirmarPago(req);
		System.out.println("Invocando medio pago local - confirmarPago - Fin ...");		

	}
	
	public void cancelarPago(Long idPago) throws ServiceException{
		//Invocar medio pago externo
		IConfirmadorMedioPagoLocalService a = new IConfirmadorMedioPagoLocalServiceLocator();

		//cancelar pago

		System.out.println("Invocando medio pago local - cancelarPago - Inicio ...");
		IConfirmadorMedioPagoLocal b = a.getIConfirmadorMedioPagoLocalPort();
		//b.cancelarPago(idPago);
		System.out.println("Invocando medio pago externo - cancelarPago - Fin ...");


	}
	
}
