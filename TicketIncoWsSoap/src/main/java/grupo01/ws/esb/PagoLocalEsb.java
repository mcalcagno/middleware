package grupo01.ws.esb;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import esb.ws.IConfirmadorMedioPagoLocal;
import esb.ws.IConfirmadorMedioPagoLocalService;
import esb.ws.IConfirmadorMedioPagoLocalServiceLocator;
import esb.ws.RequestAnulacionMedioPagoLocalData;
import esb.ws.RequestConfirmacionMedioPagoLocalData;
import esb.ws.ResponseAnulacionMedioPagoLocalData;
import esb.ws.ResponseAnulacionPagosYaData;


public class PagoLocalEsb {

	public PagoLocalEsb() {
	}

	public void confirmarPago(String digitoVerif, String fechaVenc, Long idReserva, String monto, String nroTarjeta) throws ServiceException, RemoteException{

		RequestConfirmacionMedioPagoLocalData req = new RequestConfirmacionMedioPagoLocalData(digitoVerif, fechaVenc,idReserva, monto, nroTarjeta);

		IConfirmadorMedioPagoLocalService a = new IConfirmadorMedioPagoLocalServiceLocator();

		//confirmar pago
		System.out.println("Invocando medio pago local - confirmarPago - Inicio...");
		IConfirmadorMedioPagoLocal b = a.getIConfirmadorMedioPagoLocalPort();
		b.confirmarPago(req);
		System.out.println("Invocando medio pago local - confirmarPago - Fin ...");		

	}
	
	public Long cancelarPago(Long idPago) throws ServiceException, RemoteException{
		//Invocar medio pago externo
		IConfirmadorMedioPagoLocalService a = new IConfirmadorMedioPagoLocalServiceLocator();
		RequestAnulacionMedioPagoLocalData req = new RequestAnulacionMedioPagoLocalData();
		req.setIdConfirmacionPago(idPago);
		//cancelar pago

		System.out.println("Invocando medio pago local - cancelarPago - Inicio ...");
		IConfirmadorMedioPagoLocal b = a.getIConfirmadorMedioPagoLocalPort();
		ResponseAnulacionMedioPagoLocalData resAnulacion =  b.anularPago(req);
		System.out.println("Invocando medio pago externo - cancelarPago - Fin ...");

		return resAnulacion.getIdAnulacionPago();
	}
	
}
