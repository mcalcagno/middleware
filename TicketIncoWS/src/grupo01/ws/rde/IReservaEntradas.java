package grupo01.ws.rde;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IReservaEntradas {

	@WebMethod
	String[] reservarEntradas(@WebParam(name="espectaculo")String espectaculo,@WebParam(name="cant") int cant); 
	
}
