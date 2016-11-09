package grupo01.database;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn; 

@Entity
@Table(name="eventos")
public class Evento {
	
	@Id	
	private Integer id;
	private Date fecha;
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="evento_horarios",
		joinColumns=@JoinColumn(name="evento_fk"),
		inverseJoinColumns=@JoinColumn(name="horario_fk"))
	private List<Horario> horarios;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="evento_reservas",
		joinColumns=@JoinColumn(name="evento_fk"),
		inverseJoinColumns=@JoinColumn(name="reserva_fk"))
	private List<Reserva> reservas;
	
	public Evento(){}

	public void setId(Integer id) {
		this.id=id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Horario> getHorarios() {
		if(horarios==null){
			horarios=new LinkedList<>();
		}
		return horarios;
	}
	
	public List<Reserva> getReservas() {
		if(reservas==null){
			reservas=new LinkedList<>();
		}
		return reservas;
	}
	
}
