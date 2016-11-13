package grupo01.ws.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import grupo01.database.Manejador;

@Service
public class Scheduler {

	public Scheduler() {
		// TODO Auto-generated constructor stub
	}
	
	 	@Scheduled(fixedDelay=1800000)
	    public void process() {

	 		System.out.println("Procesando anulacion...");
	 		Manejador.cancelarReservas();
	    }

}
