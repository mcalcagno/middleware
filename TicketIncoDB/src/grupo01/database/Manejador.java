package grupo01.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Manejador {
	
	private final String persistence_unit = "TicketIncoDB";
	
	public Manejador(){}

	public Espectaculo crearEspectaculo(String name, int cantEntradas){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Espectaculo esp = new Espectaculo(name);
		for(int i=0;i<cantEntradas;i++){
			esp.getEntradas().add(new Entrada(name+"#"+i,Entrada.Estado.LIBRE));
		}
		em.persist(esp);
		em.getTransaction().commit();
		em.close();
		emf.close();
		return esp;
	}
	
	public Espectaculo getEspectaculo(String name){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Espectaculo e WHERE name=:name",Espectaculo.class);
		q.setParameter("name", name);
		Espectaculo esp = (Espectaculo)q.getSingleResult();
		em.close();
		emf.close();
		return esp;
	}
	
	public Entrada getEntrada(String codEntrada){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence_unit);
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("SELECT e FROM Entrada e WHERE codigo=:code",Entrada.class);
		q.setParameter("code", codEntrada);
		Entrada ent = (Entrada)q.getSingleResult();
		em.close();
		emf.close();
		return ent;
	}
	
}
