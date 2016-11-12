/**
 * RequestConfirmacionPagosYaData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public class RequestConfirmacionPagosYaData  implements java.io.Serializable {
    private int digitoVerif;

    private java.util.Calendar fechaVenc;

    private java.lang.Long idReserva;

    private java.lang.Double monto;

    private java.lang.Long numeroTarjeta;

    public RequestConfirmacionPagosYaData() {
    }

    public RequestConfirmacionPagosYaData(
           int digitoVerif,
           java.util.Calendar fechaVenc,
           java.lang.Long idReserva,
           java.lang.Double monto,
           java.lang.Long numeroTarjeta) {
           this.digitoVerif = digitoVerif;
           this.fechaVenc = fechaVenc;
           this.idReserva = idReserva;
           this.monto = monto;
           this.numeroTarjeta = numeroTarjeta;
    }


    /**
     * Gets the digitoVerif value for this RequestConfirmacionPagosYaData.
     * 
     * @return digitoVerif
     */
    public int getDigitoVerif() {
        return digitoVerif;
    }


    /**
     * Sets the digitoVerif value for this RequestConfirmacionPagosYaData.
     * 
     * @param digitoVerif
     */
    public void setDigitoVerif(int digitoVerif) {
        this.digitoVerif = digitoVerif;
    }


    /**
     * Gets the fechaVenc value for this RequestConfirmacionPagosYaData.
     * 
     * @return fechaVenc
     */
    public java.util.Calendar getFechaVenc() {
        return fechaVenc;
    }


    /**
     * Sets the fechaVenc value for this RequestConfirmacionPagosYaData.
     * 
     * @param fechaVenc
     */
    public void setFechaVenc(java.util.Calendar fechaVenc) {
        this.fechaVenc = fechaVenc;
    }


    /**
     * Gets the idReserva value for this RequestConfirmacionPagosYaData.
     * 
     * @return idReserva
     */
    public java.lang.Long getIdReserva() {
        return idReserva;
    }


    /**
     * Sets the idReserva value for this RequestConfirmacionPagosYaData.
     * 
     * @param idReserva
     */
    public void setIdReserva(java.lang.Long idReserva) {
        this.idReserva = idReserva;
    }


    /**
     * Gets the monto value for this RequestConfirmacionPagosYaData.
     * 
     * @return monto
     */
    public java.lang.Double getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this RequestConfirmacionPagosYaData.
     * 
     * @param monto
     */
    public void setMonto(java.lang.Double monto) {
        this.monto = monto;
    }


    /**
     * Gets the numeroTarjeta value for this RequestConfirmacionPagosYaData.
     * 
     * @return numeroTarjeta
     */
    public java.lang.Long getNumeroTarjeta() {
        return numeroTarjeta;
    }


    /**
     * Sets the numeroTarjeta value for this RequestConfirmacionPagosYaData.
     * 
     * @param numeroTarjeta
     */
    public void setNumeroTarjeta(java.lang.Long numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestConfirmacionPagosYaData)) return false;
        RequestConfirmacionPagosYaData other = (RequestConfirmacionPagosYaData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.digitoVerif == other.getDigitoVerif() &&
            ((this.fechaVenc==null && other.getFechaVenc()==null) || 
             (this.fechaVenc!=null &&
              this.fechaVenc.equals(other.getFechaVenc()))) &&
            ((this.idReserva==null && other.getIdReserva()==null) || 
             (this.idReserva!=null &&
              this.idReserva.equals(other.getIdReserva()))) &&
            ((this.monto==null && other.getMonto()==null) || 
             (this.monto!=null &&
              this.monto.equals(other.getMonto()))) &&
            ((this.numeroTarjeta==null && other.getNumeroTarjeta()==null) || 
             (this.numeroTarjeta!=null &&
              this.numeroTarjeta.equals(other.getNumeroTarjeta())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getDigitoVerif();
        if (getFechaVenc() != null) {
            _hashCode += getFechaVenc().hashCode();
        }
        if (getIdReserva() != null) {
            _hashCode += getIdReserva().hashCode();
        }
        if (getMonto() != null) {
            _hashCode += getMonto().hashCode();
        }
        if (getNumeroTarjeta() != null) {
            _hashCode += getNumeroTarjeta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestConfirmacionPagosYaData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.esb/", "requestConfirmacionPagosYaData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("digitoVerif");
        elemField.setXmlName(new javax.xml.namespace.QName("", "digitoVerif"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaVenc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaVenc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idReserva");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idReserva"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroTarjeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroTarjeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
