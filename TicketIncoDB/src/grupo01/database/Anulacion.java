package grupo01.database;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="anulaciones")
public class Anulacion {

	@Id 
	private Long id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "confirmacion_id")
	private Confirmacion confirmacion;

	public Anulacion(Confirmacion confirmacion) {
		super();
		this.confirmacion = confirmacion;
	}



	public Confirmacion getConfirmacion() {
		return confirmacion;
	}



	public void setConfirmacion(Confirmacion confirmacion) {
		this.confirmacion = confirmacion;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Anulacion() {}

}
