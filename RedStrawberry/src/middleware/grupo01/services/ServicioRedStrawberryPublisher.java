package middleware.grupo01.services;

import javax.xml.ws.Endpoint;

public class ServicioRedStrawberryPublisher {
	
	public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/RedStrawberry/ServicioRedStrawberry", new ServicioRedStrawberry());
    }

}
