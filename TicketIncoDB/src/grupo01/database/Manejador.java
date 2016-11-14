package grupo01.database;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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
			reserva.setFechaIngreso(new Date());
			
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
		
		Reserva reserva = null;
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Reserva e WHERE id=:id",Reserva.class);
		q.setParameter("id", idReserva);
		reserva = (Reserva)q.getSingleResult();
		em.close();
		emf.close();
		} catch(NoResultException e){
			reserva = null;
			System.out.println("No existe la reserva con identificador: "+idReserva.toString());
		}

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
	
	public static Confirmacion getConfirmacion(Long idConfirmacion){

		Confirmacion conf;

		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
			EntityManager em = emf.createEntityManager();
			Query q = em.createQuery("SELECT e FROM Confirmacion e WHERE id=:id",Confirmacion.class);
			q.setParameter("id", idConfirmacion);
			conf = (Confirmacion)q.getSingleResult();
			em.close();
			emf.close();

		} catch(NoResultException e){
			conf = null;
			System.out.println("No existe un pago con identificador: "+idConfirmacion.toString());
		}

		return conf;
	}
	
	public static Anulacion createAnulacion(Long idConfirmacion, Long idAnulacion){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Confirmacion conf = getConfirmacion(idConfirmacion);
		Anulacion anul = new Anulacion(conf);
		anul.setId(idAnulacion);
		em.persist(anul);
		Reserva reserva = conf.getReserva();
		reserva.setEstado(0);
		em.merge(reserva);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		habilitarDisponibilidades(reserva);
		
		
		return anul;
	}
	
	public static void habilitarDisponibilidades(Reserva reserva) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
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
	}

	public static Integer cancelarReservas(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT e FROM Reserva e WHERE estado = 1",Reserva.class);
		List<Reserva> reservas = q.getResultList();
		Integer cantReservas = 0;
		Date horaActual = new Date();
		
		for (Reserva r: reservas){
			
			if ((horaActual.getTime() - r.getFechaIngreso().getTime()) > 60000){
				r.setEstado(0);
				cantReservas++;
				em.merge(r);
			}
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		for (Reserva r: reservas){
			habilitarDisponibilidades(r);
		}
		
		return cantReservas;
		
	}

	public static Double getMontoReserva(Long idReserva) {
		// TODO Auto-generated method stub
		return 100.0;
	}
	
}
