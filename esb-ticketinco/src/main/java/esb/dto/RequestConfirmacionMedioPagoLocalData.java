package esb.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "requestMedioPagoLocalData")
public class RequestConfirmacionMedioPagoLocalData {

	private String numeroTarjeta;
	private String fechaVenc;
	private String digitoVerif;
	private String monto;
	private Long idReserva;
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	@XmlElement( name = "numeroTarjeta")
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getFechaVenc() {
		return fechaVenc;
	}

	@XmlElement( name = "fechaVenc")
	public void setFechaVenc(String fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	public String getDigitoVerif() {
		return digitoVerif;
	}

	@XmlElement( name = "digitoVerif")
	public void setDigitoVerif(String digitoVerif) {
		this.digitoVerif = digitoVerif;
	}

	public String getMonto() {
		return monto;
	}

	@XmlElement( name = "monto")
	public void setMonto(String monto) {
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
