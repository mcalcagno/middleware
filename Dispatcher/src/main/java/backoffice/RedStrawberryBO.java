package backoffice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import middleware.grupo01.services.IServicioRedStrawberry;
import middleware.grupo01.services.ServicioRedStrawberry;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

public class RedStrawberryBO {

	@WebServiceRef(wsdlLocation="http://localhost:8080/RedStrawberry/ServicioRedStrawberry?wsdl")
	
	 public static void main (String [ ] args) throws MalformedURLException {
		List<String> lst = new ArrayList<String>();
		String a = new String("<ItemOrden><IdProducto>1</IdProducto> <Cantidad>1</Cantidad> "
				+ "<IdOrden>1</IdOrden>"+ "<IdItem>1</IdItem>" + "<FecCreacion>12/12/2016</FecCreacion></ItemOrden>");
		String b = new String ("<ItemOrden><IdProducto>2</IdProducto>  <Cantidad>2</Cantidad> "
				+ "<IdOrden>2</IdOrden>"+ "<IdItem>2</IdItem>" + "<FecCreacion>12/12/2016</FecCreacion></ItemOrden>");
		String c = new String ("<ItemOrden><IdProducto>3</IdProducto> <Cantidad>3</Cantidad>  "
				+ "<IdOrden>3</IdOrden>"+ "<IdItem>3</IdItem>" + "<FecCreacion>12/12/2016</FecCreacion></ItemOrden>");
		lst.add(a);
		lst.add(b);
		lst.add(c);
		receive(lst);
		}

	public static void receive(List<String> message) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/RedStrawberry/ServicioRedStrawberry?wsdl");
		QName qname = new QName("http://services.grupo01.middleware/", "ServicioRedStrawberryService");
		Service service = Service.create(url, qname);
		IServicioRedStrawberry strawBerry = service.getPort(IServicioRedStrawberry.class);
		BindingProvider prov = (BindingProvider) strawBerry;
        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
		String[] string = message.toArray(new String[0]);
		strawBerry.recibirOC(string);
	}
	
//	static {
//		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
//			    new javax.net.ssl.HostnameVerifier(){
//			 
//			        public boolean verify(String hostname,
//			                javax.net.ssl.SSLSession sslSession) {
//			            if (hostname.equals("localhost")) {
//			                return true;
//			            }
//			            return false;
//			        }
//			    });
//	}

}
