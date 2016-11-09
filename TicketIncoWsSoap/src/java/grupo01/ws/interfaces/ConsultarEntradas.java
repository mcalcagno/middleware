package grupo01.ws.interfaces;

import java.util.Date;
import java.util.List;

import grupo01.database.Horario;

public interface ConsultarEntradas {

	List<Horario> consultarEntradasDisponibles(Integer idEvento,Date fecha);
}
