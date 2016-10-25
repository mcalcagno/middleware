package grupo01.ws.crve;

import javax.jws.WebService;

@WebService(endpointInterface = "grupo01.ws.crve.IConfirmacionReservaVentaEntradas")
public class ConfirmacionReservaVentaEntradas implements IConfirmacionReservaVentaEntradas{

	@Override
	public void confirmacionReservaVentaEntradas(String codReserva) {
		System.out.println("ddddddd");	
	}
}
