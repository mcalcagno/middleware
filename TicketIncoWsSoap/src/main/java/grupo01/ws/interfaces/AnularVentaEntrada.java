package grupo01.ws.interfaces;

import grupo01.ws.fault.NoExistePagoException;

public interface AnularVentaEntrada {

	Long anularVentaEntrada(Long idConfirmacion, Long idMedioPago) throws NoExistePagoException;
}
