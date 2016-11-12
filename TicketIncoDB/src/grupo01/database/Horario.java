package grupo01.database;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="horarios")
public class Horario {

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Id @GeneratedValue
	private Long id;
	private String codigo;
	private Date fechaHora;
	
	
	@OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name="horario_disponibilidades",
		joinColumns=@JoinColumn(name="horario_fk"),
		inverseJoinColumns=@JoinColumn(name="disponibilidad_fk"))
	private List<Disponibilidad> disponibilidades;
	
	public String getCodigo() {
		return codigo;
	}

	public Horario(String codigo, Date fechaHora){
		this.codigo=codigo;
		this.fechaHora = fechaHora;
	}

	public List<Disponibilidad> getDisponibilidades() {
		if(disponibilidades==null){
			disponibilidades=new LinkedList<>();
		}
		return disponibilidades;
	}

	public Long getId(){
		return id;
	}
	
	public Horario(){}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	
	
}
