package middleware.grupo01.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class OrderMessageListener implements MessageListener {

	public void onMessage(Message message) {
		//try {
			@SuppressWarnings(value="unused")
			TextMessage msg = (TextMessage) message;
			System.out.println("Input Consumed message: " );
		/*} catch (JMSException e) {
			e.printStackTrace();
		}*/
	}

}
