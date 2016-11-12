package grupo01.database;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="confirmaciones")
public class Confirmacion {

	@Id @GeneratedValue
	private Long id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "reserva_id")
	private Reserva reserva;

	
	public Confirmacion(Reserva reserva) {
		super();
		this.reserva = reserva;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public Long getId() {
		return id;
	}


	public Confirmacion() {}
	

}
