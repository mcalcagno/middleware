package esb.ws;

public class IPagosYaConfirmadorPagosProxy implements esb.ws.IPagosYaConfirmadorPagos {
  private String _endpoint = null;
  private esb.ws.IPagosYaConfirmadorPagos iPagosYaConfirmadorPagos = null;
  
  public IPagosYaConfirmadorPagosProxy() {
    _initIPagosYaConfirmadorPagosProxy();
  }
  
  public IPagosYaConfirmadorPagosProxy(String endpoint) {
    _endpoint = endpoint;
    _initIPagosYaConfirmadorPagosProxy();
  }
  
  private void _initIPagosYaConfirmadorPagosProxy() {
    try {
      iPagosYaConfirmadorPagos = (new esb.ws.IPagosYaConfirmadorPagosServiceLocator()).getIPagosYaConfirmadorPagosPort();
      if (iPagosYaConfirmadorPagos != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iPagosYaConfirmadorPagos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iPagosYaConfirmadorPagos)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iPagosYaConfirmadorPagos != null)
      ((javax.xml.rpc.Stub)iPagosYaConfirmadorPagos)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public esb.ws.IPagosYaConfirmadorPagos getIPagosYaConfirmadorPagos() {
    if (iPagosYaConfirmadorPagos == null)
      _initIPagosYaConfirmadorPagosProxy();
    return iPagosYaConfirmadorPagos;
  }
  
  public esb.ws.ResponseConfirmacionPagosYaData confirmarPago(esb.ws.RequestConfirmacionPagosYaData req) throws java.rmi.RemoteException{
    if (iPagosYaConfirmadorPagos == null)
      _initIPagosYaConfirmadorPagosProxy();
    return iPagosYaConfirmadorPagos.confirmarPago(req);
  }
  
  public esb.ws.ResponseAnulacionPagosYaData cancelarPago(esb.ws.RequestAnulacionPagosYaData idConfirmacionPago) throws java.rmi.RemoteException{
    if (iPagosYaConfirmadorPagos == null)
      _initIPagosYaConfirmadorPagosProxy();
    return iPagosYaConfirmadorPagos.cancelarPago(idConfirmacionPago);
  }
  
  
}