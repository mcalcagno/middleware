package grupo01.ws.interfaces;

import java.util.Date;
import java.util.List;

import grupo01.ws.data.HorarioData;

public interface ReservarEntradas {

	
	Long reservarEntradas(Integer idEvento, Date fecha, List<HorarioData> horarios);
}
