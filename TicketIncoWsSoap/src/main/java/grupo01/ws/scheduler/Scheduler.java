package grupo01.ws.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import grupo01.database.Manejador;

@Service
public class Scheduler {

	public Scheduler() {
		// TODO Auto-generated constructor stub
	}
	
	 	@Scheduled(fixedDelay=60000)
	    public void process() {

	 		System.out.println("Procesando anulacion...");
	 		Integer cantReservas = Manejador.cancelarReservas();
	 		System.out.println("Se anularon "+cantReservas+" reservas");
	 		
	    }

}
