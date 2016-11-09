package grupo01.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Manejador {
	
	private final static String persistence_unit = "TicketIncoDB";
	
	public static Evento getEvento(Integer idEvento){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Evento e WHERE id=:id",Evento.class);
		q.setParameter("id", idEvento);
		Evento evento = (Evento)q.getSingleResult();
		em.close();
		emf.close();
		return evento;
	}
	
	
}
