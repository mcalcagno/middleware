package middleware.grupo01.services.parser;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement( name = "ItemOrden")
public class ItemOrden {

	private Long IdProducto;
	private int Cantidad;
	private String IdItem;
	private String IdOrden;
	
	@XmlElement(name = "FecCreacion", required = true) 
    @XmlJavaTypeAdapter(DateAdapter.class)
	private Date FecCreacion;
	
	public ItemOrden(Long idProducto, int cantidad, String idItem, String idOrden, Date fecCreacion) {
		super();
		IdProducto = idProducto;
		Cantidad = cantidad;
		IdItem = idItem;
		IdOrden = idOrden;
		FecCreacion = fecCreacion;
	}
	
	public Date getFecCreacion() {
		return FecCreacion;
	}

	public void setFecCreacion(Date fecCreacion) {
		FecCreacion = fecCreacion;
	}

	public ItemOrden() {
		super();
	}

	public Long getIdProducto() {
		return IdProducto;
	}

	@XmlElement( name = "IdProducto")
	public void setIdProducto(Long idProducto) {
		IdProducto = idProducto;
	}

	public int getCantidad() {
		return Cantidad;
	}

	@XmlElement( name = "Cantidad")
	public void setCantidad(int cantidad) {
		this.Cantidad = cantidad;
	}

	public String getIdItem() {
		return IdItem;
	}

	@XmlElement( name = "IdItem")
	public void setIdItem(String idItem) {
		this.IdItem = idItem;
	}

	public String getIdOrden() {
		return IdOrden;
	}

	@XmlElement( name = "IdOrden")
	public void setIdOrden(String idOrden) {
		this.IdOrden = idOrden;
	}

	public Date getFecha() {
		return FecCreacion;
	}

	@XmlElement( name = "FecCreacion")
	public void setFecha(Date fecha) {
		this.FecCreacion = fecha;
	}


}
