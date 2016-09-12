package middleware.grupo01.order.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
	"nroItem",
	"categoria",
	"idProducto",
	"descripcion",
	"cantidad",
	"precio"
})
public class ItemXml {

	@XmlElement(name = "NroItem")
	private Long nroItem;
	@XmlElement(name = "Categoria")
	private CategoryXml categoria;
	@XmlElement(name = "IdProducto")
	private Long idProducto;
	@XmlElement(name = "Descripcion")
	private String descripcion;
	@XmlElement(name = "Cantidad")
	private Integer cantidad;
	@XmlElement(name = "Precio")
	private Double precio;
	
	public CategoryXml getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoryXml categoria) {
		this.categoria = categoria;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getNroItem() {
		return nroItem;
	}
	public void setNroItem(Long nroItem) {
		this.nroItem = nroItem;
	}
	
}