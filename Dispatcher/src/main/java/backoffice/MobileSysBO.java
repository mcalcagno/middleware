package backoffice;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.transform.TransformerException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import middleware.grupo01.dispatcher.Dispatcher;
import middleware.grupo01.xslt.XSLTTransformer;

public class MobileSysBO {

	
	private static String MOBILE_SYS_QUEUE = "MOBILE_SYS_QUEUE"; 
	private static MessageProducer prodMobileSys;
	private static Session session; 
	private static Connection connection;
	
	public void receive(String message) {
		//try {

			try {
				String transform = XSLTTransformer.transformItemOrdenToMobileSys(message);
				System.out.println("MobileSysBO Consumed message: " );
				
				initialize();
				TextMessage messageSend = session.createTextMessage(transform);
				prodMobileSys.send(messageSend);
				
				finalization();
				
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
	
	private static void initialize() throws JMSException{
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(MOBILE_SYS_QUEUE);
		prodMobileSys = session.createProducer(destination);
	}
	
	private static void finalization() throws JMSException{
		connection.close();
	}
	
	
}
