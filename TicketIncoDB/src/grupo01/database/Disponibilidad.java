package grupo01.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="disponibilidades")
public class Disponibilidad {
	
	public Disponibilidad(String sector, Double precio, Integer cantidad) {
		super();
		this.sector = sector;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getId() {
		return id;
	}

	@Id @GeneratedValue
	private Long id;
	private String sector;
	private Double precio;
	private Integer cantidad;
	
	public Disponibilidad(){}

}
