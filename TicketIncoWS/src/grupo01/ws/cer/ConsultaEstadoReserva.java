package grupo01.ws.cer;

import javax.jws.WebService;

@WebService(endpointInterface = "grupo01.ws.cer.IConsultaEstadoReserva")
public class ConsultaEstadoReserva implements IConsultaEstadoReserva{

	@Override
	public String consultaEstadoReserva(String codReserva) {
		return "estado";
	}
	
}
