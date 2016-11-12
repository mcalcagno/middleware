package grupo01;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import grupo01.database.Disponibilidad;
import grupo01.database.Evento;
import grupo01.database.Horario;

public class App {

	private final static String persistence_unit = "TicketIncoDB";
	
	public static void main(String[] args){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Evento evento = new Evento();
		evento.setId(1);
		evento.setFecha(new Date());
		List<Horario> horarios = evento.getHorarios();
		for(int i=0;i<3;i++){
			Horario h = new Horario(String.valueOf(i), new Date());
			
			List<Disponibilidad> disponibilidades = h.getDisponibilidades();
			for(int j=0;j<5;j++){
				Disponibilidad d = new Disponibilidad();
				d.setSector("Sector"+j);
				d.setPrecio(10.0);
				d.setCantidad(4);
				disponibilidades.add(d);
			}
			horarios.add(h);
		}
		em.persist(evento);
		em.getTransaction().commit();
	}
	
}
