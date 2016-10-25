package grupo01.ws.ave;

import javax.jws.WebService;

@WebService(endpointInterface = "grupo01.ws.ave.IAnulacionVentaEntradas")
public class AnulacionVentaEntradas implements IAnulacionVentaEntradas{

	@Override
	public void anulacionVentaEntradas(String codEntrada) {
		System.out.println("aaaaaaaaaa");
	}
	
}
