/**
 * ServicioRedStrawberryServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws.client;

public class ServicioRedStrawberryServiceLocator extends org.apache.axis.client.Service implements ws.client.ServicioRedStrawberryService {

    public ServicioRedStrawberryServiceLocator() {
    }


    public ServicioRedStrawberryServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioRedStrawberryServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioRedStrawberryPort
    private java.lang.String ServicioRedStrawberryPort_address = "http://localhost:8080/RedStrawberry/ServicioRedStrawberry";

    public java.lang.String getServicioRedStrawberryPortAddress() {
        return ServicioRedStrawberryPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioRedStrawberryPortWSDDServiceName = "ServicioRedStrawberryPort";

    public java.lang.String getServicioRedStrawberryPortWSDDServiceName() {
        return ServicioRedStrawberryPortWSDDServiceName;
    }

    public void setServicioRedStrawberryPortWSDDServiceName(java.lang.String name) {
        ServicioRedStrawberryPortWSDDServiceName = name;
    }

    public ws.client.IServicioRedStrawberry getServicioRedStrawberryPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioRedStrawberryPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioRedStrawberryPort(endpoint);
    }

    public ws.client.IServicioRedStrawberry getServicioRedStrawberryPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.client.ServicioRedStrawberryPortBindingStub _stub = new ws.client.ServicioRedStrawberryPortBindingStub(portAddress, this);
            _stub.setPortName(getServicioRedStrawberryPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioRedStrawberryPortEndpointAddress(java.lang.String address) {
        ServicioRedStrawberryPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.client.IServicioRedStrawberry.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.client.ServicioRedStrawberryPortBindingStub _stub = new ws.client.ServicioRedStrawberryPortBindingStub(new java.net.URL(ServicioRedStrawberryPort_address), this);
                _stub.setPortName(getServicioRedStrawberryPortWSDDServiceName());
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
        if ("ServicioRedStrawberryPort".equals(inputPortName)) {
            return getServicioRedStrawberryPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.grupo01.middleware/", "ServicioRedStrawberryService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.grupo01.middleware/", "ServicioRedStrawberryPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioRedStrawberryPort".equals(portName)) {
            setServicioRedStrawberryPortEndpointAddress(address);
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
