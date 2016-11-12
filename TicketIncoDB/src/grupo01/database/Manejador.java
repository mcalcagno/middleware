package grupo01.database;

import java.util.Date;

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

	public static void updateCantidadDisponible(Disponibilidad disp, Integer cantidad) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		if (disp.getCantidad() >= cantidad){
			disp.setCantidad(disp.getCantidad() - cantidad);
		} else {
			disp.setCantidad(0);
		}
		em.merge(disp);
		em.getTransaction().commit();
	    em.close();
	    emf.close();
	}

	public static Long crearReserva(Evento evento) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Reserva reserva = new Reserva();
		try{
		
		reserva.setEstado(1);
		reserva.setEvento(evento);
		em.persist(reserva);
		evento.getReservas().add(reserva);
		em.merge(evento);
		em.getTransaction().commit();
	    em.close();
	    emf.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	    return reserva.getId();
		
	}

	public static Reserva getReserva(Long idReserva) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Reserva e WHERE id=:id",Reserva.class);
		q.setParameter("id", idReserva);
		Reserva reserva = (Reserva)q.getSingleResult();
		em.close();
		emf.close();
		return reserva;
	}

	public static Confirmacion confirmarReserva(Long idReserva) {
		// TODO Auto-generated method stub
		
		Reserva reserva = getReserva(idReserva);
		reserva.setEstado(2);
		Confirmacion conf = new Confirmacion(reserva);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.merge(reserva);
		em.persist(conf);
		em.close();
		emf.close();
		return conf;
	}

	public static void crearMedioPago(Long idReserva, Long idMedioPago, String nroTarjeta, Date fechaVenc,
			Integer digitoVerificador) {
		// TODO Auto-generated method stub
		
		MedioPago m = new MedioPago(idMedioPago, nroTarjeta, fechaVenc, digitoVerificador);
		Reserva r = getReserva(idReserva);
		r.setMedioPago(m);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.persist(m);
		em.merge(r);
		em.close();
		emf.close();
		
	}	
	
}
