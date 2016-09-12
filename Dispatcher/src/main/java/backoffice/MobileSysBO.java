package backoffice;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

public class MobileSysBO {

	public void onMessage(String message) {
		//try {
			//@SuppressWarnings(value="unused")
			//TextMessage msg = (TextMessage) message;
			System.out.println("MobileSysBO Consumed message: " );
		/*} catch (JMSException e) {
			e.printStackTrace();
		}*/
	}
	
}
