package grupo01.ws.ave;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IAnulacionVentaEntradas {

	@WebMethod
	void anulacionVentaEntradas(@WebParam(name="codEntrada")String codEntrada);
	
}
