package middleware.grupo01.mobilesys;

import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class SomeHandler implements ErrorHandler {

	public void handleError(Throwable arg0) {
		System.out.println("Llego al error");
		
	}

    
}
