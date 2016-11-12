package esb.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="requestConfirmacionPagosYaData")
public class RequestConfirmacionPagosYaData {
	
	private Long numeroTarjeta;
	private Date fechaVenc;
	private int digitoVerif;
	private Double monto;
	private Long idReserva;
	
	public Long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	
	@XmlElement( name = "numeroTarjeta")
	public void setNumeroTarjeta(Long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Date getFechaVenc() {
		return fechaVenc;
	}

	@XmlElement( name = "fechaVenc")
	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public int getDigitoVerif() {
		return digitoVerif;
	}

	@XmlElement( name = "digitoVerif")
	public void setDigitoVerif(int digitoVerif) {
		this.digitoVerif = digitoVerif;
	}

	public Double getMonto() {
		return monto;
	}

	@XmlElement( name = "monto")
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	@XmlElement( name = "idReserva")
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

}
