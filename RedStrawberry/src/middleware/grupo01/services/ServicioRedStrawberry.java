package middleware.grupo01.services;


import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.codec.binary.Base64;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

@WebService(endpointInterface = "middleware.grupo01.services.IServicioRedStrawberry")
public class ServicioRedStrawberry implements IServicioRedStrawberry{
	
	@Resource
    WebServiceContext wsctx;
	
	@Override
	public void recibirOC(Long idProduct, Long cantidad, String transactionId, GregorianCalendar date){
		
		try{
            if(!isUserAuthenticated()){
            	throw new Exception("Acceso no autorizado.");
            }
        }
        catch (Exception ex){
        	try {
				throw new Exception("Ocurrio un error al recibir la orden de compra.",ex);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        finally {
            SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            fmt.setCalendar(date);
            appendToLog((new java.util.Date()) + "" + idProduct + "-" + cantidad + "-" + transactionId + "-" +
                            fmt.format(date.getTime()),
                    (ServletContext) wsctx.getMessageContext().get(MessageContext.SERVLET_CONTEXT));
        }
		
	}
	
	 private boolean appendToLog(String text, ServletContext context){

	        String path = context.getRealPath("/");

	        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "/logServicioEntradas.txt", true)))) {
	            out.append(text);
	            return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return  false;
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
