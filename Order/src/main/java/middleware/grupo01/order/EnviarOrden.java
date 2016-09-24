package middleware.grupo01.order;

import java.io.StringWriter;

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

import org.apache.activemq.ActiveMQConnectionFactory;

import middleware.grupo01.order.util.ConstantsUtil;
import middleware.grupo01.order.xml.PurcharseOrderXml;

public class EnviarOrden {

	private static Connection connection;
	private static MessageProducer producer;
	private static Session session; 
	
	
	public static void enviar(PurcharseOrderXml orden){

		try {
			initialize();
			String poStr;
			poStr = getPurchaseOrderString(orden);
			TextMessage message = session.createTextMessage(poStr);

			// SEND
			producer.send(message);
			System.out.println("############################################################################");
			System.out.println("############################################################################");
			System.out.println("Se ha enviado la Orden de Compra ");

			finalization();

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 


	}

	private static String getPurchaseOrderString(PurcharseOrderXml poXml) throws JAXBException{
		JAXBContext jc = JAXBContext.newInstance(PurcharseOrderXml.class);
		Marshaller marshaller = jc.createMarshaller();
	    //marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
	    StringWriter stringWriter = new StringWriter();
	    marshaller.marshal(poXml, stringWriter);
	    return stringWriter.toString();
	}
	
	private static void initialize() throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ConstantsUtil.url);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(ConstantsUtil.DISPACHER_QUEUE);
		producer = session.createProducer(destination);
	}
	
	private static void finalization() throws JMSException{
		connection.close();
	}
}
