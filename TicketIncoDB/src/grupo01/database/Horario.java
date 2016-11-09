package grupo01.database;

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

	@Id @GeneratedValue
	private Long id;
	private String codigo;
	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="horario_disponibilidades",
		joinColumns=@JoinColumn(name="horario_fk"),
		inverseJoinColumns=@JoinColumn(name="disponibilidad_fk"))
	private List<Disponibilidad> disponibilidades;
	
	public String getCodigo() {
		return codigo;
	}

	public Horario(String codigo){
		this.codigo=codigo;
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

}
