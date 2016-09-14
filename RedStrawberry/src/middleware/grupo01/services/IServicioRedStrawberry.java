package middleware.grupo01.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.GregorianCalendar;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IServicioRedStrawberry {
	
	@WebMethod
    void recibirOC(Long idProduct, Long cantidad, String transactionId, GregorianCalendar date);

}
