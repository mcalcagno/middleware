package grupo01.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "responseAnulacionPagosYaData")
public class ResponseAnulacionPagosYaData {
	
	private Long idAnulacionPago;

	public ResponseAnulacionPagosYaData(Long confirmacionPago) {
		this.idAnulacionPago = confirmacionPago;
	}

	public ResponseAnulacionPagosYaData() {
	}

	public Long getConfirmacionPago() {
		return idAnulacionPago;
	}

	@XmlElement( name = "idAnulacionPago")
	public void setConfirmacionPago(Long confirmacionPago) {
		this.idAnulacionPago = confirmacionPago;
	}
	
}
