
package grupo01.ws.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.8
 * Fri Oct 28 00:32:58 GMT-03:00 2016
 * Generated source version: 3.1.8
 */

@XmlRootElement(name = "anularVentaEntrada", namespace = "http://ws.grupo01/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anularVentaEntrada", namespace = "http://ws.grupo01/")

public class AnularVentaEntrada {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

