package grupo01.ws.crve;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IConfirmacionReservaVentaEntradas {

	@WebMethod
	void confirmacionReservaVentaEntradas(@WebParam(name="codReserva")String codReserva);
	
}
