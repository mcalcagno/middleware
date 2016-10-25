package grupo01.ws.ced;

import javax.jws.WebService;

@WebService(endpointInterface = "grupo01.ws.ced.IConsultaEntradasDisponibles")
public class ConsultaEntradasDisponibles implements IConsultaEntradasDisponibles{

	@Override
	public int getEntradasDisponibles(String espectaculo){
		return 1;
	};
	
}
