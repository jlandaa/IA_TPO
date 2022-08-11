package iaPortalWeb;

public class PortalWebProxy implements iaPortalWeb.PortalWeb {
  private String _endpoint = null;
  private iaPortalWeb.PortalWeb portalWeb = null;
  
  public PortalWebProxy() {
    _initPortalWebProxy();
  }
  
  public PortalWebProxy(String endpoint) {
    _endpoint = endpoint;
    _initPortalWebProxy();
  }
  
  private void _initPortalWebProxy() {
    try {
      portalWeb = (new iaPortalWeb.PortalWebServiceLocator()).getPortalWebPort();
      if (portalWeb != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)portalWeb)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)portalWeb)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (portalWeb != null)
      ((javax.xml.rpc.Stub)portalWeb)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public iaPortalWeb.PortalWeb getPortalWeb() {
    if (portalWeb == null)
      _initPortalWebProxy();
    return portalWeb;
  }
  
  public boolean cambioEstadoEntrega(int arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (portalWeb == null)
      _initPortalWebProxy();
    return portalWeb.cambioEstadoEntrega(arg0, arg1);
  }
  
  
}