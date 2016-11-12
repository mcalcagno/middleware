package grupo01.ws.data;

import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.IIOImage;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Entrada")
public class EntradaData {
	
	@XmlElement(name = "IdConfirmacion")
	private Long idConfirmacion;
	private List<Image> imagenes;
	
	public EntradaData() {
	}

	public Long getIdConfirmacion() {
		return idConfirmacion;
	}

	public void setIdConfirmacion(Long idConfirmacion) {
		this.idConfirmacion = idConfirmacion;
	}

	public List<Image> getImagenes() {
		if(imagenes==null){
			imagenes= new LinkedList<>();
		}
		return imagenes;
	}

	public EntradaData(Long idConfirmacion) {
		super();
		this.idConfirmacion = idConfirmacion;
	}

	
}
