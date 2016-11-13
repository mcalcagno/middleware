package grupo01.helper;

import java.util.Date;

import grupo01.dto.RequestAnulacionPagosYaData;
import grupo01.dto.RequestConfirmacionPagosYaData;
import grupo01.dto.ResponseAnulacionPagosYaData;
import grupo01.dto.ResponseConfirmacionPagosYaData;

public class PagosHelper {

	private long idConfirmacionPago=0;

	public ResponseConfirmacionPagosYaData procesarPago(RequestConfirmacionPagosYaData pago) {

		System.out.println("Procesando pago...");
		System.out.println("Numero de tarjeta de credito: "+pago.getNumeroTarjeta());
		System.out.println("Fecha vencimiento: "+pago.getFechaVenc());
		System.out.println("Digito verificador: "+pago.getDigitoVerif());
		System.out.println("Monto: "+pago.getMonto());
		String message="";
		ResponseConfirmacionPagosYaData resultPago = new ResponseConfirmacionPagosYaData();
		try {
			
			if ((new Date()).before(pago.getFechaVenc())){
				throw  new Exception("La tarjeta de credito esta vencida");
			}
			
			if (pago.getMonto() < 1){
				throw  new Exception("El monto debe ser positivo");
			}

			idConfirmacionPago++;
			resultPago.setIdConfirmacionPago(idConfirmacionPago);
			resultPago.setMensaje("Pago procesado correctamente");
			resultPago.setStatus(true);
			message="Pago procesado correctamente";
		} catch (Exception e) {
			message="Ocurrio un error al procesar el pago";
			resultPago.setIdConfirmacionPago(-1);
			resultPago.setMensaje("Pago fallido");
			resultPago.setStatus(false);
		}

		System.out.println(message);
		return resultPago;
	}
	
	public ResponseAnulacionPagosYaData anularPago(RequestAnulacionPagosYaData idConfirmacionPago) {
		ResponseAnulacionPagosYaData result = new ResponseAnulacionPagosYaData(156l);
		return result;
	}

}
