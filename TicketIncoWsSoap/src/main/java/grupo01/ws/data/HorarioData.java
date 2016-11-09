package grupo01.ws.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Horario")
public class HorarioData {
	
	@XmlElement(name = "Id")
	private Long id;
	@XmlElement(name = "Codigo")
	private String codigo;
	@XmlElement(name = "Disponibilidades")
	private List<DisponibilidadData> disponibilidades;
	public HorarioData(Long id, String codigo, List<DisponibilidadData> disponibilidades) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.disponibilidades = disponibilidades;
	}
	public HorarioData(){};

}
