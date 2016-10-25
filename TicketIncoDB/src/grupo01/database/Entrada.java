package grupo01.database;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entradas")
public class Entrada {
	
	@Id
	private String codigo;
	private Estado estado;
	
	public Entrada(){}
	
	public Entrada(String codigo, Estado estado) {
		super();
		this.codigo = codigo;
		this.estado = estado;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public enum Estado{
		LIBRE,CONFIRMADA,
	}

}
