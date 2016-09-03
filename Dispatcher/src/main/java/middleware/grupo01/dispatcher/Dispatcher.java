package middleware.grupo01.dispatcher;

<<<<<<< HEAD
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
=======
import javax.jms.Connection;
>>>>>>> 8a6103e94d433bc7c5b4dd58834982a603ad7eb1
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import backoffice.DataSysBO;

public class Dispatcher 
{
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String DISPACHER_QUEUE = "DISPACHER_QUEUE"; 
	private static String INVALID_QUEUE = "INVALID_QUEUE"; 
	
	private static Connection connection;
	private static Session session;
	private static MessageConsumer consumer;
	private static MessageProducer invalidProducer;
	
    public static void main( String[] args ) throws JMSException
    {
<<<<<<< HEAD
        System.out.println( "DISPATCHER INICIO" );
 		
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
=======
    	 ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

    	 DataSysBO obj = (DataSysBO) context.getBean("idPrueba");
    	
        System.out.println(obj.getPrueba());
       //thread(new DispatcherConsumer(), false);
       // thread(new DispatcherConsumer(), false);
>>>>>>> 8a6103e94d433bc7c5b4dd58834982a603ad7eb1
    }
    
    private static void initialize() throws JMSException{
    	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
 		connection = connectionFactory.createConnection();
 		connection.start();
 		session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
 		Destination destination = session.createQueue(DISPACHER_QUEUE);
 		Destination destinationInvalidQueue = session.createQueue(INVALID_QUEUE);
 		consumer = session.createConsumer(destination);
 		invalidProducer = session.createProducer(destinationInvalidQueue);
    }
    
    private static void finalization() throws JMSException{
    	connection.close();
    }

	private static boolean validateMessage(Message message) {
		return false;
	}
    
}
