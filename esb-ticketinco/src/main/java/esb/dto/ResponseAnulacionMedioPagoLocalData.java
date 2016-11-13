package esb.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "responseAnulacionMedioPagoLocalData")
public class ResponseAnulacionMedioPagoLocalData {

	private Long idAnulacionPago;

	public ResponseAnulacionMedioPagoLocalData(Long idAnulacionPago) {
		this.idAnulacionPago = idAnulacionPago;
	}

	public ResponseAnulacionMedioPagoLocalData() {
	}

	public Long getIdAnulacionPago() {
		return idAnulacionPago;
	}

	@XmlElement( name = "idAnulacionPago")
	public void setIdAnulacionPago(Long idAnulacionPago) {
		this.idAnulacionPago = idAnulacionPago;
	}
	
	
	
}
