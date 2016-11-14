/**
 * IConfirmadorMedioPagoLocalServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public class IConfirmadorMedioPagoLocalServiceLocator extends org.apache.axis.client.Service implements esb.ws.IConfirmadorMedioPagoLocalService {

    public IConfirmadorMedioPagoLocalServiceLocator() {
    }


    public IConfirmadorMedioPagoLocalServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IConfirmadorMedioPagoLocalServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IConfirmadorMedioPagoLocalPort
    private java.lang.String IConfirmadorMedioPagoLocalPort_address = "http://192.168.43.144:8082/confirmacionMedioPagoLocal";

    public java.lang.String getIConfirmadorMedioPagoLocalPortAddress() {
        return IConfirmadorMedioPagoLocalPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IConfirmadorMedioPagoLocalPortWSDDServiceName = "IConfirmadorMedioPagoLocalPort";

    public java.lang.String getIConfirmadorMedioPagoLocalPortWSDDServiceName() {
        return IConfirmadorMedioPagoLocalPortWSDDServiceName;
    }

    public void setIConfirmadorMedioPagoLocalPortWSDDServiceName(java.lang.String name) {
        IConfirmadorMedioPagoLocalPortWSDDServiceName = name;
    }

    public esb.ws.IConfirmadorMedioPagoLocal getIConfirmadorMedioPagoLocalPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IConfirmadorMedioPagoLocalPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIConfirmadorMedioPagoLocalPort(endpoint);
    }

    public esb.ws.IConfirmadorMedioPagoLocal getIConfirmadorMedioPagoLocalPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            esb.ws.IConfirmadorMedioPagoLocalServiceSoapBindingStub _stub = new esb.ws.IConfirmadorMedioPagoLocalServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIConfirmadorMedioPagoLocalPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIConfirmadorMedioPagoLocalPortEndpointAddress(java.lang.String address) {
        IConfirmadorMedioPagoLocalPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (esb.ws.IConfirmadorMedioPagoLocal.class.isAssignableFrom(serviceEndpointInterface)) {
                esb.ws.IConfirmadorMedioPagoLocalServiceSoapBindingStub _stub = new esb.ws.IConfirmadorMedioPagoLocalServiceSoapBindingStub(new java.net.URL(IConfirmadorMedioPagoLocalPort_address), this);
                _stub.setPortName(getIConfirmadorMedioPagoLocalPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IConfirmadorMedioPagoLocalPort".equals(inputPortName)) {
            return getIConfirmadorMedioPagoLocalPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.esb/", "IConfirmadorMedioPagoLocalService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.esb/", "IConfirmadorMedioPagoLocalPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IConfirmadorMedioPagoLocalPort".equals(portName)) {
            setIConfirmadorMedioPagoLocalPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
