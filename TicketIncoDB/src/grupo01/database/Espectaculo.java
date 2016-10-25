package grupo01.database;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn; 
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="expectaculos")
public class Espectaculo {
	
	@Id
	private String name;
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="espectaculo_entradas",
		joinColumns=@JoinColumn(name="espectaculo_fk"),
		inverseJoinColumns=@JoinColumn(name="entrada_fk"),
		uniqueConstraints={@UniqueConstraint(columnNames = {"espectaculo_fk", "entrada_fk"})})
	private List<Entrada> entradas;

	public Espectaculo(){}
	public Espectaculo(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Entrada> getEntradas() {
		if(entradas==null){
			entradas=new LinkedList<>();
		}
		return entradas;
	}
}
