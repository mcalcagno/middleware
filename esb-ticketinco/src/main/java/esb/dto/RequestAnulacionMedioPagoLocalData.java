package esb.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "requestAnulacionMedioPagoLocalData")
public class RequestAnulacionMedioPagoLocalData {
	
	private Long idConfirmacionPago;

	public RequestAnulacionMedioPagoLocalData(Long idConfirmacionPago) {
		this.idConfirmacionPago = idConfirmacionPago;
	}

	public RequestAnulacionMedioPagoLocalData() {
	}

	public Long getIdConfirmacionPago() {
		return idConfirmacionPago;
	}

	@XmlElement( name = "idConfirmacionPago")
	public void setIdConfirmacionPago(Long idConfirmacionPago) {
		this.idConfirmacionPago = idConfirmacionPago;
	}
	
	

}
