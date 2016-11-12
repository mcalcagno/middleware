package grupo01.ws.data;

import java.util.Date;
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
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@XmlElement(name = "FechaHorario")
	private Date fechaHorario;
	
	@XmlElement(name = "Disponibilidades")
	private List<DisponibilidadData> disponibilidades;
	public HorarioData(Long id, String codigo, List<DisponibilidadData> disponibilidades, Date fechaHorario) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.disponibilidades = disponibilidades;
		this.fechaHorario = fechaHorario;
	}
	public HorarioData(){}
	
	public Long getId() {
		return id;
	}
	public List<DisponibilidadData> getDisponibilidades() {
		return disponibilidades;
	}
	public Date getFechaHorario() {
		return fechaHorario;
	};
	
	
	

}
