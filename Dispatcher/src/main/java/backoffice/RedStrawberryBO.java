package backoffice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import middleware.grupo01.xslt.XSLTTransformer;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;

import backoffice.redstrawberry.wsclient.IServicioRedStrawberry;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

public class RedStrawberryBO {

	static { 
		HttpsURLConnection.setDefaultHostnameVerifier(
				new HostnameVerifier() { 
					public boolean verify(String hostname, SSLSession session) {
						// ip address of the service URL(like.23.28.244.244) 
						if (hostname.equals("172.16.143.109")) 
							return true; 
						return false; 
					} 
				}); 
	}
	
	public static void receive(String message) throws MalformedURLException, TransformerException {
		System.out.println("redStrawberryMsg");
		String xmlStrawberry = XSLTTransformer.transform(message,XSLTTransformer.TO_REDSTRAWBERRY);
		System.out.println(message);
		URL url = new URL("https://172.16.143.109:8443/RedStrawberry/ServicioRedStrawberry?wsdl");
		//URL url = new URL("http://172.16.143.109:8080/RedStrawberry/ServicioRedStrawberry?wsdl");
		QName qname = new QName("http://services.grupo01.middleware/", "ServicioRedStrawberryService");
		Service service = Service.create(url, qname);
		IServicioRedStrawberry strawBerry = service.getPort(IServicioRedStrawberry.class);
		BindingProvider prov = (BindingProvider) strawBerry;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        strawBerry.recibirOC(xmlStrawberry);
        System.out.println("********************");
        System.out.println("****WS INVOCADO***");
	}
	
	
}	