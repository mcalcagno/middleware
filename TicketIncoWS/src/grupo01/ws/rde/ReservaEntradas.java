package grupo01.ws.rde;

import javax.jws.WebService;

@WebService(endpointInterface = "grupo01.ws.rde.IReservaEntradas")
public class ReservaEntradas implements IReservaEntradas{

	@Override
	public String[] reservarEntradas(String espectaculo,int cant) {
		String[] ret = {"cod1"};
		return ret;
	}
}
