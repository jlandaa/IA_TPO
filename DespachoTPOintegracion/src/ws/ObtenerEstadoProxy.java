package ws;

public class ObtenerEstadoProxy implements ws.ObtenerEstado {
  private String _endpoint = null;
  private ws.ObtenerEstado obtenerEstado = null;
  
  public ObtenerEstadoProxy() {
    _initObtenerEstadoProxy();
  }
  
  public ObtenerEstadoProxy(String endpoint) {
    _endpoint = endpoint;
    _initObtenerEstadoProxy();
  }
  
  private void _initObtenerEstadoProxy() {
    try {
      obtenerEstado = (new ws.ObtenerEstadoServiceLocator()).getObtenerEstadoPort();
      if (obtenerEstado != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)obtenerEstado)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)obtenerEstado)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (obtenerEstado != null)
      ((javax.xml.rpc.Stub)obtenerEstado)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.ObtenerEstado getObtenerEstado() {
    if (obtenerEstado == null)
      _initObtenerEstadoProxy();
    return obtenerEstado;
  }
  
  public boolean cambioEstadoEntrega(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (obtenerEstado == null)
      _initObtenerEstadoProxy();
    return obtenerEstado.cambioEstadoEntrega(arg0, arg1);
  }
  
  
}