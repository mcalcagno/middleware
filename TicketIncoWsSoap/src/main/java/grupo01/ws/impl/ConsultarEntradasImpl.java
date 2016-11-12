package grupo01.ws.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
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
import grupo01.ws.interfaces.ConsultarEntradas;

@WebService(targetNamespace = "http://impl.ws.grupo01/", portName = "ConsultarEntradasImplPort", serviceName = "ConsultarEntradasImplService")
public class ConsultarEntradasImpl implements ConsultarEntradas{

	public ConsultarEntradasImpl() {
		// TODO Auto-generated constructor stub
	}
	

	@WebMethod(operationName = "consultarEntradasDisponibles", action = "urn:ConsultarEntradasDisponibles")
	@Override
	public @WebResult(name="Horario") List<HorarioData> consultarEntradasDisponibles(@WebParam(name = "idEvento") Integer idEvento,
			@WebParam(name = "fecha") Date fecha) {
		Evento evento =  Manejador.getEvento(idEvento);
		List<HorarioData> list = new LinkedList<>();
		for(Horario h : evento.getHorarios()){
			List<DisponibilidadData> disp = new LinkedList<>();
			for(Disponibilidad d : h.getDisponibilidades()){
				DisponibilidadData dData = new DisponibilidadData(d.getId(), d.getSector(), d.getPrecio(), d.getCantidad());
				disp.add(dData);
			}
			HorarioData hd = new HorarioData(h.getId(), h.getCodigo(), disp, h.getFechaHora());
			list.add(hd);	
		}
		return list;
	}

	
	
}
