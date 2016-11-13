package esb.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "responseMedioPagoLocalData")
public class ResponseConfirmacionMedioPagoLocalData {
	
	private boolean status;
    private String mensaje;
    private long idConfirmacionPago;
    
	public ResponseConfirmacionMedioPagoLocalData(boolean status, String mensaje, long idConfirmacionPago) {
		this.status = status;
		this.mensaje = mensaje;
		this.idConfirmacionPago = idConfirmacionPago;
	}

	public ResponseConfirmacionMedioPagoLocalData() {}

	public boolean isStatus() {
		return status;
	}

	@XmlElement( name = "status")
	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	@XmlElement( name = "mensaje")
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public long getIdConfirmacionPago() {
		return idConfirmacionPago;
	}

	@XmlElement( name = "idConfirmacionPago")
	public void setIdConfirmacionPago(long idConfirmacionPago) {
		this.idConfirmacionPago = idConfirmacionPago;
	}

}
