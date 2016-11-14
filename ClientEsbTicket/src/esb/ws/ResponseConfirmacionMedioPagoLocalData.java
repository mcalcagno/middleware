/**
 * ResponseConfirmacionMedioPagoLocalData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public class ResponseConfirmacionMedioPagoLocalData  implements java.io.Serializable {
    private long idConfirmacionPago;

    private java.lang.String mensaje;

    private boolean status;

    public ResponseConfirmacionMedioPagoLocalData() {
    }

    public ResponseConfirmacionMedioPagoLocalData(
           long idConfirmacionPago,
           java.lang.String mensaje,
           boolean status) {
           this.idConfirmacionPago = idConfirmacionPago;
           this.mensaje = mensaje;
           this.status = status;
    }


    /**
     * Gets the idConfirmacionPago value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @return idConfirmacionPago
     */
    public long getIdConfirmacionPago() {
        return idConfirmacionPago;
    }


    /**
     * Sets the idConfirmacionPago value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @param idConfirmacionPago
     */
    public void setIdConfirmacionPago(long idConfirmacionPago) {
        this.idConfirmacionPago = idConfirmacionPago;
    }


    /**
     * Gets the mensaje value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the status value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @return status
     */
    public boolean isStatus() {
        return status;
    }


    /**
     * Sets the status value for this ResponseConfirmacionMedioPagoLocalData.
     * 
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseConfirmacionMedioPagoLocalData)) return false;
        ResponseConfirmacionMedioPagoLocalData other = (ResponseConfirmacionMedioPagoLocalData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idConfirmacionPago == other.getIdConfirmacionPago() &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            this.status == other.isStatus();
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
        _hashCode += new Long(getIdConfirmacionPago()).hashCode();
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        _hashCode += (isStatus() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseConfirmacionMedioPagoLocalData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.esb/", "responseConfirmacionMedioPagoLocalData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idConfirmacionPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idConfirmacionPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
