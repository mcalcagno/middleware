package middleware.grupo01.services;


import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import org.apache.commons.codec.binary.Base64;
import middleware.grupo01.services.parser.RedStrawBerryParser;
import java.util.ArrayList;
import java.util.Map;

@WebService(endpointInterface = "middleware.grupo01.services.IServicioRedStrawberry")
public class ServicioRedStrawberry implements IServicioRedStrawberry{

	@Resource
	WebServiceContext wsctx;

	@Override
	public void recibirOC(String[] lst){
		System.out.println("Recibiendo ordenes de compra...");
		try{
			if(!isUserAuthenticated()){
				throw new Exception("Acceso no autorizado.");
			}
			RedStrawBerryParser.unmarshallListOfOrders(lst);
		}
		catch (Exception ex){
			try {
				throw new Exception("Ocurrio un error al recibir la orden de compra.",ex);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isUserAuthenticated() {

		MessageContext mctx = wsctx.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);

		ArrayList list = (ArrayList) http_headers.get("Authorization");
		if (list == null || list.size() == 0) {
			throw new RuntimeException("Fallo en la Autenticacion!");
		}

		String userpass = (String) list.get(0);
		userpass = userpass.substring(5);
		byte[] buf = Base64.decodeBase64(userpass.getBytes());
		String credentials = new String(buf);

		String username = null;
		String password = null;
		int p = credentials.indexOf(":");
		if (p > -1) {
			username = credentials.substring(0, p);
			password = credentials.substring(p + 1);
		} else {
			throw new RuntimeException("Fallo en la Autenticación!");
		}
		// This should be changed to a DB / Ldap authentication check
		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("============== Autenticacion OK =============");
			return true;
		} else {
			throw new RuntimeException("Fallo en la Autenticación!");
		}
	}

}
