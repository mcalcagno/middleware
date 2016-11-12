package grupo01.database;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mediospago")
public class MedioPago {

	@Id 
	private Long id;
	private String numeroTarjeta;
	private Date fechaVencimiento;
	private int digitoVerificador;
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public int getDigitoVerificador() {
		return digitoVerificador;
	}
	public void setDigitoVerificador(int digitoVerificador) {
		this.digitoVerificador = digitoVerificador;
	}
	public Long getId() {
		return id;
	}
	public MedioPago(Long id, String numeroTarjeta, Date fechaVencimiento, int digitoVerificador) {
		super();
		this.id = id;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.digitoVerificador = digitoVerificador;
	}
	
	public MedioPago(){}
	
	
	
	
}
