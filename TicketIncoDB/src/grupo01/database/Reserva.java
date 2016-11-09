package grupo01.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id @GeneratedValue
	private Long id;
	private Integer estado;
	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;
	@ManyToOne
	@JoinColumn(name = "mediopoago_id")
	private MedioPago medioPago;

	
	public MedioPago getMedioPago() {
		return medioPago;
	}
	public void setMedioPago(MedioPago medioPago) {
		this.medioPago = medioPago;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Long getId() {
		return id;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
