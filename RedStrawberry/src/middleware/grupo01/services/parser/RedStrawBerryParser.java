package middleware.grupo01.services.parser;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class RedStrawBerryParser {

	public static void unmarshallListOfOrders(String[] lst) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(ItemOrden.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		System.out.println("Procesando ordenes de compras recibidas por RedStrawberry...");
		for(String orderItem : lst){
			ItemOrden item = (ItemOrden) unmarshaller.unmarshal(new StringReader(orderItem));
			System.out.println("IdProducto: " + item.getIdProducto() + " - Cantidad: " + item.getCantidad() + " - Id. transaccion: " + 
					item.getIdOrden()+":"+item.getIdItem() + " - Fecha: " + item.getFecha());
		}
		System.out.println("Ordenes de compras procesadas...");
	}

}
