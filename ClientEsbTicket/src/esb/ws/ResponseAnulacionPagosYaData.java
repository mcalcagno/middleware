/**
 * ResponseAnulacionPagosYaData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public class ResponseAnulacionPagosYaData  implements java.io.Serializable {
    private java.lang.Long idAnulacionPago;

    public ResponseAnulacionPagosYaData() {
    }

    public ResponseAnulacionPagosYaData(
           java.lang.Long idAnulacionPago) {
           this.idAnulacionPago = idAnulacionPago;
    }


    /**
     * Gets the idAnulacionPago value for this ResponseAnulacionPagosYaData.
     * 
     * @return idAnulacionPago
     */
    public java.lang.Long getIdAnulacionPago() {
        return idAnulacionPago;
    }


    /**
     * Sets the idAnulacionPago value for this ResponseAnulacionPagosYaData.
     * 
     * @param idAnulacionPago
     */
    public void setIdAnulacionPago(java.lang.Long idAnulacionPago) {
        this.idAnulacionPago = idAnulacionPago;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResponseAnulacionPagosYaData)) return false;
        ResponseAnulacionPagosYaData other = (ResponseAnulacionPagosYaData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.idAnulacionPago==null && other.getIdAnulacionPago()==null) || 
             (this.idAnulacionPago!=null &&
              this.idAnulacionPago.equals(other.getIdAnulacionPago())));
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
        if (getIdAnulacionPago() != null) {
            _hashCode += getIdAnulacionPago().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseAnulacionPagosYaData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.esb/", "responseAnulacionPagosYaData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAnulacionPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAnulacionPago"));
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
