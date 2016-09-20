package ws.client;

import java.rmi.RemoteException;


public class IServicioRedStrawberryProxy implements ws.client.IServicioRedStrawberry {
  private String _endpoint = null;
  private ws.client.IServicioRedStrawberry iServicioRedStrawberry = null;
  
  public IServicioRedStrawberryProxy() {
    _initIServicioRedStrawberryProxy();
  }
  
  public IServicioRedStrawberryProxy(String endpoint) {
    _endpoint = endpoint;
    _initIServicioRedStrawberryProxy();
  }
  
  private void _initIServicioRedStrawberryProxy() {
    try {
      iServicioRedStrawberry = (new ws.client.ServicioRedStrawberryServiceLocator()).getServicioRedStrawberryPort();
      if (iServicioRedStrawberry != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iServicioRedStrawberry)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iServicioRedStrawberry)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iServicioRedStrawberry != null)
      ((javax.xml.rpc.Stub)iServicioRedStrawberry)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.client.IServicioRedStrawberry getIServicioRedStrawberry() {
    if (iServicioRedStrawberry == null)
      _initIServicioRedStrawberryProxy();
    return iServicioRedStrawberry;
  }
  
  public void recibirOC(java.lang.String[] arg0) throws RemoteException{
    if (iServicioRedStrawberry == null)
      _initIServicioRedStrawberryProxy();
    iServicioRedStrawberry.recibirOC(arg0);
  }
  
  
}