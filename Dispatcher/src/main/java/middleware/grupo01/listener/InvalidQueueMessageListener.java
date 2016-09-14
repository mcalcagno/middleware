package middleware.grupo01.listener;

public class InvalidQueueMessageListener {
	
	public void msg(String msg){
		System.out.println("*************************");
		System.out.println("**INVALID QUEUE LISTENER**");
		System.out.println("Received Message:"+msg );
	}
	
}
