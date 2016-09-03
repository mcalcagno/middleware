package middleware.grupo01.order.xml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "Orden")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PurcharseOrder", propOrder = {
	"nroOrden",
	"fecCreacion",
	"idCliente",
	"fPago",
	"facturacion",
	"items"
})
public class PurcharseOrderXml {

	@XmlElement(name = "NroOrden")
	private Long nroOrden;
	@XmlElement(name = "FecCreacion")
	private Date fecCreacion;
	@XmlElement(name = "IdCliente")
	private Long idCliente;
	@XmlElement(name = "FormaPago")
	private PaymentXml fPago;
	@XmlElement(name = "Facturacion")
	private FacturationXml facturacion;
	@XmlElement(name = "Item")
	List<ItemXml> items;
	public Long getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(Long nroOrden) {
		this.nroOrden = nroOrden;
	}
	public Date getFecCreacion() {
		return fecCreacion;
	}
	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public PaymentXml getfPago() {
		return fPago;
	}
	public void setfPago(PaymentXml fPago) {
		this.fPago = fPago;
	}
	public FacturationXml getFacturacion() {
		return facturacion;
	}
	public void setFacturacion(FacturationXml facturacion) {
		this.facturacion = facturacion;
	}
	public List<ItemXml> getItems(){
		if(items==null){
			items = new ArrayList<ItemXml>();
		}
		return items;
	}
	
}
