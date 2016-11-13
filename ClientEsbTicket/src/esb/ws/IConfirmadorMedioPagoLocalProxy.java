package esb.ws;

public class IConfirmadorMedioPagoLocalProxy implements esb.ws.IConfirmadorMedioPagoLocal {
  private String _endpoint = null;
  private esb.ws.IConfirmadorMedioPagoLocal iConfirmadorMedioPagoLocal = null;
  
  public IConfirmadorMedioPagoLocalProxy() {
    _initIConfirmadorMedioPagoLocalProxy();
  }
  
  public IConfirmadorMedioPagoLocalProxy(String endpoint) {
    _endpoint = endpoint;
    _initIConfirmadorMedioPagoLocalProxy();
  }
  
  private void _initIConfirmadorMedioPagoLocalProxy() {
    try {
      iConfirmadorMedioPagoLocal = (new esb.ws.IConfirmadorMedioPagoLocalServiceLocator()).getIConfirmadorMedioPagoLocalPort();
      if (iConfirmadorMedioPagoLocal != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iConfirmadorMedioPagoLocal)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iConfirmadorMedioPagoLocal)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iConfirmadorMedioPagoLocal != null)
      ((javax.xml.rpc.Stub)iConfirmadorMedioPagoLocal)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public esb.ws.IConfirmadorMedioPagoLocal getIConfirmadorMedioPagoLocal() {
    if (iConfirmadorMedioPagoLocal == null)
      _initIConfirmadorMedioPagoLocalProxy();
    return iConfirmadorMedioPagoLocal;
  }
  
  public esb.ws.RequestMedioPagoLocalData confirmarPago(esb.ws.RequestMedioPagoLocalData req) throws java.rmi.RemoteException{
    if (iConfirmadorMedioPagoLocal == null)
      _initIConfirmadorMedioPagoLocalProxy();
    return iConfirmadorMedioPagoLocal.confirmarPago(req);
  }
  
  
}