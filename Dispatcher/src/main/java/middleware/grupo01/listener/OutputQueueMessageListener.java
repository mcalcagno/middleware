package middleware.grupo01.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class OutputQueueMessageListener /*implements MessageListener*/ {

	public void onMessage(String message) {
		//try {
			//@SuppressWarnings(value="unused")
			//TextMessage msg = (TextMessage) message;
			System.out.println("Out Consumed message: " );
		/*} catch (JMSException e) {
			e.printStackTrace();
		}*/
	}

}
