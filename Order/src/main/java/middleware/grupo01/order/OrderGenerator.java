package middleware.grupo01.order;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import middleware.grupo01.order.xml.CategoryXml;
import middleware.grupo01.order.xml.CurrencyXml;
import middleware.grupo01.order.xml.FacturationXml;
import middleware.grupo01.order.xml.ItemXml;
import middleware.grupo01.order.xml.PaymentXml;
import middleware.grupo01.order.xml.PurcharseOrderXml;

import java.io.StringWriter;
import java.util.Date;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class OrderGenerator 
{
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private static String DISPACHER_QUEUE = "DISPACHER_QUEUE"; 
	
	private static Connection connection;
	private static MessageProducer producer;
	private static Session session; 

	public static void main( String[] args ) throws Exception
    {
		initialize();
		
		PurcharseOrderXml p = new PurcharseOrderXml();
		p.setFecCreacion(new Date());
		p.setIdCliente(1L);
		p.setNroOrden(1L);
		p.setfPago(PaymentXml.EFECTVO);
		FacturationXml f = new FacturationXml();
		f.setCuotas(1);
		f.setMonto(14.0);
		f.setMoneda(CurrencyXml.PESOS);
		p.setFacturacion(f);
		ItemXml i = new ItemXml();
		i.setNroItem(1L);
		i.setCantidad(1);
		i.setCategoria(CategoryXml.DATA);
		i.setDescripcion("desc");
		i.setIdProducto(2L);
		i.setPrecio(1.0);
		p.getItems().add(i);
		ItemXml i2 = new ItemXml();
		i2.setNroItem(2L);
		i2.setCantidad(2);
		i2.setCategoria(CategoryXml.MOBILE);
		i2.setDescripcion("desc2");
		i2.setIdProducto(2L);
		i2.setPrecio(2.0);
		p.getItems().add(i2);
		ItemXml i3 = new ItemXml();
		i3.setNroItem(3L);
		i3.setCantidad(3);
		i3.setCategoria(CategoryXml.RED_STRAWBERRY);
		i3.setDescripcion("desc2");
		i3.setIdProducto(2L);
		i3.setPrecio(3.0);
		p.getItems().add(i3);
		
		
		String poStr = getPurchaseOrderString(p); 

		TextMessage message = session.createTextMessage(poStr);
		
		// SEND
		producer.send(message);
		System.out.println("Sentage ");
		
		finalization();
    }    
	
	private static void initialize() throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(DISPACHER_QUEUE);
		producer = session.createProducer(destination);
	}
	
	private static void finalization() throws JMSException{
		connection.close();
	}
	
	private static String getPurchaseOrderString(PurcharseOrderXml poXml) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(PurcharseOrderXml.class);
		Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(poXml, stringWriter);
        return stringWriter.toString();
	}
	
}
