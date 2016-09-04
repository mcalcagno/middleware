package middleware.grupo01.order.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Moneda")
@XmlEnum
public enum CurrencyXml {
	@XmlEnumValue("858") PESOS,
	@XmlEnumValue("840") DOLARES
}

