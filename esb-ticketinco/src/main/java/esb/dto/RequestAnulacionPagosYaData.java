package esb.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "requestAnulacionPagosYaData")
public class RequestAnulacionPagosYaData {
	
	private Long idConfirmacionPago;

	public RequestAnulacionPagosYaData(Long confirmacionPago) {
		this.idConfirmacionPago = confirmacionPago;
	}

	public RequestAnulacionPagosYaData() {
	}

	public Long getConfirmacionPago() {
		return idConfirmacionPago;
	}

	@XmlElement( name = "idConfirmacionPago")
	public void setConfirmacionPago(Long confirmacionPago) {
		this.idConfirmacionPago = confirmacionPago;
	}
}