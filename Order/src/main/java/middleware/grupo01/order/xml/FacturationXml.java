package middleware.grupo01.order.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Facturacion", propOrder = {
	"monto",
	"moneda",
	"cuotas"
})
public class FacturationXml {

	@XmlElement(name = "Monto")
	private Double monto;
	@XmlElement(name = "Moneda")
	private CurrencyXml moneda;
	@XmlElement(name = "Cuotas")
	private Integer cuotas;
	
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public CurrencyXml getMoneda() {
		return moneda;
	}
	public void setMoneda(CurrencyXml moneda) {
		this.moneda = moneda;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
}
