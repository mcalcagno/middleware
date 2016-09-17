package middleware.grupo01.mobilesys;


public class MobileSysListener2 {

	public void receive(String message) {
		System.out.println("*************************");
		System.out.println("******RECIVE MESSAGE TWO*****");
		//throw new RuntimeException("ERROR PROCESSING MSG");
		System.out.println(message);
	}
	
}
