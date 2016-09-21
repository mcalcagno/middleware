package middleware.grupo01.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "DataSysItemOrden")
public class DataSysItemOrden {

	private Long IdCliente;
	private Long IdProducto;
	private int Cantidad;
	private Long IdItem;
	private Long IdOrden;
	
	public DataSysItemOrden() {
		super();
	}

	public DataSysItemOrden(Long idCliente, Long idProducto, int cantidad, Long idItem, Long idOrden) {
		super();
		IdCliente = idCliente;
		IdProducto = idProducto;
		Cantidad = cantidad;
		IdItem = idItem;
		IdOrden = idOrden;
	}
	
	public Long getIdCliente() {
		return IdCliente;
	}
	
	@XmlElement( name = "IdCliente")
	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
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
		Cantidad = cantidad;
	}
	
	public Long getIdItem() {
		return IdItem;
	}
	
	@XmlElement( name = "IdItem")
	public void setIdItem(Long idItem) {
		IdItem = idItem;
	}
	
	public Long getIdOrden() {
		return IdOrden;
	}
	
	@XmlElement( name = "IdOrden")
	public void setIdOrden(Long idOrden) {
		IdOrden = idOrden;
	}

}
