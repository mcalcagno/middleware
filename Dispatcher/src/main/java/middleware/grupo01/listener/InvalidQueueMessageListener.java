package middleware.grupo01.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class InvalidQueueMessageListener /*implements MessageListener */{
	
	public void onMessage(java.lang.String message) {
		//try {
			//@SuppressWarnings(value="unused")
			//TextMessage msg = (TextMessage) message;
			System.out.println("Invalid Consumed message: " );
		/*} catch (JMSException e) {
			e.printStackTrace();
		}*/
	}
	/*
	public void onMessage(com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl var){
		System.out.println("Invalid Consumed message: " );
	}
	*/
	public void msg(Message msg){
		System.out.println("Invalid Consumed message: " );
	}
	
}
