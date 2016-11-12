/**
 * IPagosYaConfirmadorPagosServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package esb.ws;

public class IPagosYaConfirmadorPagosServiceLocator extends org.apache.axis.client.Service implements esb.ws.IPagosYaConfirmadorPagosService {

    public IPagosYaConfirmadorPagosServiceLocator() {
    }


    public IPagosYaConfirmadorPagosServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IPagosYaConfirmadorPagosServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IPagosYaConfirmadorPagosPort
    private java.lang.String IPagosYaConfirmadorPagosPort_address = "http://localhost:8081/confirmacionMedioPagoExterno";

    public java.lang.String getIPagosYaConfirmadorPagosPortAddress() {
        return IPagosYaConfirmadorPagosPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IPagosYaConfirmadorPagosPortWSDDServiceName = "IPagosYaConfirmadorPagosPort";

    public java.lang.String getIPagosYaConfirmadorPagosPortWSDDServiceName() {
        return IPagosYaConfirmadorPagosPortWSDDServiceName;
    }

    public void setIPagosYaConfirmadorPagosPortWSDDServiceName(java.lang.String name) {
        IPagosYaConfirmadorPagosPortWSDDServiceName = name;
    }

    public esb.ws.IPagosYaConfirmadorPagos getIPagosYaConfirmadorPagosPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IPagosYaConfirmadorPagosPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIPagosYaConfirmadorPagosPort(endpoint);
    }

    public esb.ws.IPagosYaConfirmadorPagos getIPagosYaConfirmadorPagosPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            esb.ws.IPagosYaConfirmadorPagosServiceSoapBindingStub _stub = new esb.ws.IPagosYaConfirmadorPagosServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIPagosYaConfirmadorPagosPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIPagosYaConfirmadorPagosPortEndpointAddress(java.lang.String address) {
        IPagosYaConfirmadorPagosPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (esb.ws.IPagosYaConfirmadorPagos.class.isAssignableFrom(serviceEndpointInterface)) {
                esb.ws.IPagosYaConfirmadorPagosServiceSoapBindingStub _stub = new esb.ws.IPagosYaConfirmadorPagosServiceSoapBindingStub(new java.net.URL(IPagosYaConfirmadorPagosPort_address), this);
                _stub.setPortName(getIPagosYaConfirmadorPagosPortWSDDServiceName());
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
        if ("IPagosYaConfirmadorPagosPort".equals(inputPortName)) {
            return getIPagosYaConfirmadorPagosPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.esb/", "IPagosYaConfirmadorPagosService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.esb/", "IPagosYaConfirmadorPagosPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IPagosYaConfirmadorPagosPort".equals(portName)) {
            setIPagosYaConfirmadorPagosPortEndpointAddress(address);
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
