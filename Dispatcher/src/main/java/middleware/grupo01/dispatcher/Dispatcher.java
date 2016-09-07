package middleware.grupo01.dispatcher;


import org.apache.activemq.ActiveMQConnection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Dispatcher 
{
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static final String DISPACHER_QUEUE = "DISPACHER_QUEUE"; 
	//private static final String INVALID_QUEUE = "INVALID_QUEUE"; 

	private static final String ORDEN_MONTO_EXP = "/Orden/Facturacion/Monto";
	private static final String ORDEN_CANT_EXP = "/Orden/Item/Cantidad";
	private static final String ORDEN_PRECIO_EXP = "/Orden/Item/Precio";
	private static final String ORDEN_PAYMENT_EXP = "/Orden/FormaPago";
	private static final String ORDEN_CUOTAS_EXP = "/Orden/Facturacion/Cuotas";
	
	private static Connection connection;
	private static Session session;
	private static MessageConsumer consumer;
	private static MessageProducer invalidProducer;
	
    public static void main( String[] args ) throws JMSException
    {
        
    	
    	System.out.println( "DISPATCHER INICIO" );
    	AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/consumer-jms-context.xml", Dispatcher.class);
        /*
        initialize();
        
 		Message message = consumer.receive();

 		if (message instanceof TextMessage) {
 			TextMessage textMessage = (TextMessage) message;
 			
 			if(validateMessage(message)){
 				System.out.println("Mensaje Recibido\n" + textMessage.getText());
 			}else{
 				System.out.println("Mensaje Invalido");
 				TextMessage messageIQ = session.createTextMessage("Invalid message");
 				invalidProducer.send(messageIQ);
 			}
 		}
 		
 		finalization();
 		
 		*/

    }
    
    private static void initialize() throws JMSException{
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
 		connection = connectionFactory.createConnection();
 		connection.start();
 		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
 		Destination destination = session.createQueue(DISPACHER_QUEUE);
 		consumer = session.createConsumer(destination);
    }
    
    private static void finalization() throws JMSException{
    	connection.close();
    }

	private static boolean validateMessage(Message message) {
		boolean ret = false;
		try {
			String strXml = ((TextMessage) message).getText();
			XPath xpath = XPathFactory.newInstance().newXPath();
			Node nodePayment = (Node) xpath.evaluate(ORDEN_PAYMENT_EXP, new InputSource(new StringReader(strXml)), XPathConstants.NODE);
			Node nodeCuotas = (Node) xpath.evaluate(ORDEN_CUOTAS_EXP, new InputSource(new StringReader(strXml)), XPathConstants.NODE);
			if(((nodePayment.getFirstChild().getNodeValue().equals("E") ||
					nodePayment.getFirstChild().getNodeValue().equals("C") ||
					nodePayment.getFirstChild().getNodeValue().equals("D")) && 
					nodeCuotas.getFirstChild().getNodeValue().equals("1")) ||
				(nodePayment.getFirstChild().getNodeValue().equals("X") &&
					Integer.valueOf(nodeCuotas.getFirstChild().getNodeValue()) > 1)	){
				Node nodeMonto = (Node) xpath.evaluate(ORDEN_MONTO_EXP, new InputSource(new StringReader(strXml)), XPathConstants.NODE);
				NodeList nodesPrecio = (NodeList) xpath.evaluate(ORDEN_PRECIO_EXP, new InputSource(new StringReader(strXml)), XPathConstants.NODESET);
				NodeList nodesCant = (NodeList) xpath.evaluate(ORDEN_CANT_EXP, new InputSource(new StringReader(strXml)), XPathConstants.NODESET);
				Double monto = new Double(nodeMonto.getFirstChild().getNodeValue());
				double acumItem = 0.0;
				if(nodesPrecio.getLength()==nodesCant.getLength()){
					for(int i = 0;i<nodesPrecio.getLength();i++){
						acumItem += new Double(nodesPrecio.item(i).getFirstChild().getNodeValue())
								* new Double(nodesCant.item(i).getFirstChild().getNodeValue());
					}
					return monto.equals(new Double(acumItem));
				}
			}
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return ret;
	}
}
