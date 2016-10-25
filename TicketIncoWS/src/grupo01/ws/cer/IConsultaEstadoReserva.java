package grupo01.ws.cer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface IConsultaEstadoReserva {

	@WebMethod
	String consultaEstadoReserva(@WebParam(name="codReserva")String codReserva);
}
