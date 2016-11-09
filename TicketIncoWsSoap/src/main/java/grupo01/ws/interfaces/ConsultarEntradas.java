package grupo01.ws.interfaces;

import java.util.Date;
import java.util.List;

import grupo01.database.Horario;
import grupo01.ws.data.HorarioData;

public interface ConsultarEntradas {

	List<HorarioData> consultarEntradasDisponibles(Integer idEvento,Date fecha);
}
