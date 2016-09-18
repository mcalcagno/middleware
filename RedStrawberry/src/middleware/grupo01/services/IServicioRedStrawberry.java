package middleware.grupo01.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(ServicioRedStrawberry.class)
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IServicioRedStrawberry {
	
	@WebMethod
    void recibirOC(String[] lst);
		
}
