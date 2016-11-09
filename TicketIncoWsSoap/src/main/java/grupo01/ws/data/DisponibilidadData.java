package grupo01.ws.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Disponibilidad")
public class DisponibilidadData {
	
	@XmlElement(name = "Id")
	private Long id;
	@XmlElement(name = "Sector")
	private String sector;
	@XmlElement(name = "Precio")
	private Double precio;
	@XmlElement(name = "Cantidad")
	private Integer cantidad;
	public DisponibilidadData(Long id, String sector, Double precio, Integer cantidad) {
		super();
		this.id = id;
		this.sector = sector;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public DisponibilidadData(){}
	
}
