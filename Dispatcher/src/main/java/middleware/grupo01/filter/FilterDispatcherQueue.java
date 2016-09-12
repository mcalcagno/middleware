package middleware.grupo01.filter;

import org.springframework.integration.core.MessageSelector;

public class FilterDispatcherQueue /*implements MessageSelector*/ {

	/*
	public boolean accept(org.springframework.messaging.Message<?> arg0) {

		String msg = "message";
		return false;
		
	}*/
	
	public boolean isValid(String msg){
		
		System.out.println("FILTER");
		System.out.println("*******");
		return true;
		
	}

		
}
