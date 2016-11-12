package grupo01.ws.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import grupo01.database.Disponibilidad;
import grupo01.database.Evento;
import grupo01.database.Horario;
import grupo01.database.Manejador;
import grupo01.ws.data.DisponibilidadData;
import grupo01.ws.data.HorarioData;
import grupo01.ws.interfaces.ReservarEntradas;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ReservarEntradasImplPort", serviceName = "ReservarEntradasImplService")
public class ReservarEntradasImpl implements ReservarEntradas{

	public ReservarEntradasImpl() {
		// TODO Auto-generated constructor stub
	}

	@WebResult(name = "idReserva")
	@WebMethod(operationName = "reservarEntradas", action = "urn:ReservarEntradas")
	@Override
	public Long reservarEntradas(@WebParam(name = "idEvento") Integer idEvento, @WebParam(name="fecha") Date fecha, 
			@WebParam(name="horarios")List<HorarioData> horarios) {
		// TODO Auto-generated method stub
		Evento evento =  Manejador.getEvento(idEvento);
		Integer cantidad;
		List<Horario> horariosReserva = new ArrayList<Horario>();
		Horario hReserva;
		Disponibilidad dispReserva;
		
		for (HorarioData horarioData : horarios){
			List<Horario> horariosEvento = evento.getHorarios();
			hReserva = new Horario();
			hReserva.setFechaHora(horarioData.getFechaHorario());
			hReserva.setCodigo(horarioData.getCodigo());
			
			for (int i=0;i<horariosEvento.size();i++){
				Horario horarioEvento = horariosEvento.get(i);
				if (horarioEvento.getId() == horarioData.getId()){
					for (DisponibilidadData dispData: horarioData.getDisponibilidades()){
						
						for(Disponibilidad disp: horarioEvento.getDisponibilidades()){
							
							if (disp.getSector().trim().equals(dispData.getSector())){
								
								cantidad = Manejador.updateCantidadDisponible(disp,dispData.getCantidad());
								dispReserva = new Disponibilidad(dispData.getSector(), dispData.getPrecio(), cantidad);
								hReserva.getDisponibilidades().add(dispReserva);
								break;
							}
						}
						
					}
				}
				
			}
			
			horariosReserva.add(hReserva);
		}
		Long idReserva = Manejador.crearReserva(evento,horariosReserva);
		
		return idReserva;
	}

	
	
}
