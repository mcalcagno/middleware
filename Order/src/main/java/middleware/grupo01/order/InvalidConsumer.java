package middleware.grupo01.order;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class InvalidConsumer implements Runnable{
	
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private static String INVALID_QUEUE = "INVALID_QUEUE";
	
	public void run(){
		while(true){
			try{
				ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
				Connection connection = connectionFactory.createConnection();
				connection.start();
				Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
				Destination destinationInvalidQueue = session.createQueue(INVALID_QUEUE);
				MessageConsumer invalidConsumer = session.createConsumer(destinationInvalidQueue);
				Message invalidMessage = invalidConsumer.receive();
				if(invalidMessage instanceof TextMessage){
					TextMessage tMsg = (TextMessage) invalidMessage;
					System.out.println("Recivido Invalid Queue: "+tMsg.getText());
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
