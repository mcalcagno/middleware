package esb.ws;

import java.rmi.RemoteException;
import java.util.Calendar;
import javax.xml.rpc.ServiceException;


public class Main {

	public static void main(String[] args) throws RemoteException, ServiceException {

		//Invocar medio pago externo
		Calendar calendar = Calendar.getInstance();
		RequestConfirmacionPagosYaData req =new RequestConfirmacionPagosYaData(15, calendar,115l, 45d, 45l);
		IPagosYaConfirmadorPagosService a = new IPagosYaConfirmadorPagosServiceLocator();
		
		//confirmar pago
//		a.getIPagosYaConfirmadorPagosPort().confirmarPago(req);
		
		//cancelar pago
//		a.getIPagosYaConfirmadorPagosPort().cancelarPago(new RequestAnulacionPagosYaData(15l));
		//Invocar medio pago local
//		RequestMedioPagoLocalData resLocal = new RequestMedioPagoLocalData("15", "2016-01-01", 654l, "321", "123");
//		IConfirmadorMedioPagoLocalService localSrv = new IConfirmadorMedioPagoLocalServiceLocator();
//		localSrv.getIConfirmadorMedioPagoLocalPort().confirmarPago(resLocal);
	}

}
