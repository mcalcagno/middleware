package middleware.grupo01.order.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Payment")
@XmlEnum
public enum PaymentXml {

	@XmlEnumValue("E") EFECTVO,
	@XmlEnumValue("D") DEBITO,
	@XmlEnumValue("C") CHEQUE,
	@XmlEnumValue("X") CREDITO
	
}

