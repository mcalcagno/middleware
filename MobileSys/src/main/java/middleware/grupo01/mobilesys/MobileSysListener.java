package middleware.grupo01.mobilesys;


public class MobileSysListener {

	public void receive(String message) {
		System.out.println("*************************");
		System.out.println("******RECIVE MESSAGE*****");
		//throw new RuntimeException("ERROR PROCESSING MSG");
		System.out.println(message);
	}
	
}
