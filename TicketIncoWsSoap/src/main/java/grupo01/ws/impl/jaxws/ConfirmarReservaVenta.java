
package grupo01.ws.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.1.8
 * Sun Nov 13 21:21:26 GMT-03:00 2016
 * Generated source version: 3.1.8
 */

@XmlRootElement(name = "confirmarReservaVenta", namespace = "http://ws.grupo01/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmarReservaVenta", namespace = "http://ws.grupo01/", propOrder = {"idReserva", "medioPago", "nroTarjeta", "fechaVenc", "digitoVerificador"})

public class ConfirmarReservaVenta {

    @XmlElement(name = "idReserva")
    private java.lang.Long idReserva;
    @XmlElement(name = "medioPago")
    private java.lang.Long medioPago;
    @XmlElement(name = "nroTarjeta")
    private java.lang.String nroTarjeta;
    @XmlElement(name = "fechaVenc")
    private java.util.Date fechaVenc;
    @XmlElement(name = "digitoVerificador")
    private java.lang.Integer digitoVerificador;

    public java.lang.Long getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(java.lang.Long newIdReserva)  {
        this.idReserva = newIdReserva;
    }

    public java.lang.Long getMedioPago() {
        return this.medioPago;
    }

    public void setMedioPago(java.lang.Long newMedioPago)  {
        this.medioPago = newMedioPago;
    }

    public java.lang.String getNroTarjeta() {
        return this.nroTarjeta;
    }

    public void setNroTarjeta(java.lang.String newNroTarjeta)  {
        this.nroTarjeta = newNroTarjeta;
    }

    public java.util.Date getFechaVenc() {
        return this.fechaVenc;
    }

    public void setFechaVenc(java.util.Date newFechaVenc)  {
        this.fechaVenc = newFechaVenc;
    }

    public java.lang.Integer getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public void setDigitoVerificador(java.lang.Integer newDigitoVerificador)  {
        this.digitoVerificador = newDigitoVerificador;
    }

}

