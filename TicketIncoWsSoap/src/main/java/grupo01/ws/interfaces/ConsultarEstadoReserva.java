package grupo01.ws.interfaces;

import grupo01.ws.fault.NoExisteReservaException;

public interface ConsultarEstadoReserva {

	Integer consultarEstadoReserva(Long idReserva) throws NoExisteReservaException;
}
