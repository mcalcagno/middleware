package grupo01.database;

import java.util.Date;
import java.util.List;

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

	public static Integer updateCantidadDisponible(Disponibilidad disp, Integer cantidad) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Integer cantidadReserva = 0;
		
		if (disp.getCantidad() >= cantidad){
			cantidadReserva = disp.getCantidad() - cantidad;			
		} 
		disp.setCantidad(cantidadReserva);
		
		em.merge(disp);
		em.getTransaction().commit();
	    em.close();
	    emf.close();
	    
	    return cantidadReserva;
	}

	public static Long crearReserva(Evento evento, List<Horario> horarios) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Reserva reserva = new Reserva();
		try{

			reserva.setEstado(1);
			reserva.setEvento(evento);
			reserva.setHorarios(horarios);
			
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
		em.getTransaction().begin();
		em.merge(reserva);
		em.persist(conf);
		em.getTransaction().commit();
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
		em.getTransaction().begin();
		em.persist(m);
		em.merge(r);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
	
	public static Anulacion createAnulacion(Long idConfirmacion){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT e FROM Confirmacion e WHERE id=:id",Confirmacion.class);
		q.setParameter("id", idConfirmacion);
		Confirmacion conf = (Confirmacion)q.getSingleResult();
		Anulacion anul = new Anulacion(conf);
		em.persist(anul);
		Reserva reserva = conf.getReserva();
		reserva.setEstado(0);
		em.merge(reserva);
		
		Evento evento = reserva.getEvento();
		List<Horario> horariosEvento = evento.getHorarios();
		
		for (Horario horarioReserva: reserva.getHorarios()){
			
			for (Horario horarioEvento: horariosEvento){
				if (horarioEvento.getCodigo().equals(horarioReserva.getCodigo())){
					for (Disponibilidad dispReserva: horarioReserva.getDisponibilidades()){
						for (Disponibilidad dispEvento: horarioEvento.getDisponibilidades()){
							
							if (dispReserva.getSector().equals(dispEvento.getSector())){
								dispEvento.setCantidad(dispEvento.getCantidad()+dispReserva.getCantidad());
								em.merge(dispEvento);
							}
						}
					}
					
				}
			}
			
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return anul;
	}
	
	public static void cancelarReservas(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT e FROM Reserva e WHERE estado = 1",Reserva.class);
		List<Reserva> reservas = q.getResultList();
		
		for (Reserva r: reservas){
			r.setEstado(0);
			em.merge(r);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
	
}
