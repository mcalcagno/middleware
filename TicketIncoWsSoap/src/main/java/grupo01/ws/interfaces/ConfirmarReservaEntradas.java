package grupo01.ws.interfaces;

import java.util.Date;

import grupo01.ws.data.EntradaData;

public interface ConfirmarReservaEntradas {

	EntradaData confirmarReservaVenta(Long idReserva, Long idMedioPago, String nroTarjeta, Date fechaVenc, Integer digitoVerificador);
}
