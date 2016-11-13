package grupo01.ws.esb;

import java.rmi.RemoteException;
import java.util.Calendar;

import esb.ws.IPagosYaConfirmadorPagos;
import esb.ws.IPagosYaConfirmadorPagosService;
import esb.ws.IPagosYaConfirmadorPagosServiceLocator;
import esb.ws.RequestConfirmacionPagosYaData;
import javax.xml.rpc.ServiceException;

public class ServicioEsb {

	public ServicioEsb() {
		// TODO Auto-generated constructor stub
	}

	public void execute(){
	//Invocar medio pago externo
			Calendar calendar = Calendar.getInstance();
			RequestConfirmacionPagosYaData req =new RequestConfirmacionPagosYaData(15, calendar,115l, 45d, 45l);
			IPagosYaConfirmadorPagosService a = new IPagosYaConfirmadorPagosServiceLocator();
			
			//confirmar pago
			try {
				IPagosYaConfirmadorPagos b = a.getIPagosYaConfirmadorPagosPort();
				b.confirmarPago(req);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//cancelar pago
//			a.getIPagosYaConfirmadorPagosPort().cancelarPago(new RequestAnulacionPagosYaData(15l));
			//Invocar medio pago local
//			RequestMedioPagoLocalData resLocal = new RequestMedioPagoLocalData("15", "2016-01-01", 654l, "321", "123");
//			IConfirmadorMedioPagoLocalService localSrv = new IConfirmadorMedioPagoLocalServiceLocator();
//			localSrv.getIConfirmadorMedioPagoLocalPort().confirmarPago(resLocal);
	}
}
