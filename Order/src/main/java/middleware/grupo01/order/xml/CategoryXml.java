package middleware.grupo01.order.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Categoria")
@XmlEnum
public enum CategoryXml {
	@XmlEnumValue("1") DATA,
	@XmlEnumValue("2") MOBILE,
	@XmlEnumValue("3") RED_STRAWBERRY
}
