package middleware.grupo01.mobilesys;

import org.springframework.messaging.MessageHandlingException;

public class DeadLetterChannelListener {


	public void receive(MessageHandlingException error) {
		System.out.println("*************************");
		System.out.println("****PROCESADO ERROR******");
		System.out.println((String)error.getFailedMessage().getPayload());
	}
	
}
