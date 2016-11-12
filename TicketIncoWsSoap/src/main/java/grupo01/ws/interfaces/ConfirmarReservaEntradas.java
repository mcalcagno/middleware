package grupo01.ws.interfaces;

import java.util.Date;

public interface ConfirmarReservaEntradas {

	Long confirmarReservaVenta(Long idReserva, Long idMedioPago, String nroTarjeta, Date fechaVenc, Integer digitoVerificador);
}
