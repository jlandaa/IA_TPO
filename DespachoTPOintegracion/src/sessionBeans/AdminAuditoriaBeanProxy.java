package sessionBeans;

public class AdminAuditoriaBeanProxy implements sessionBeans.AdminAuditoriaBean {
  private String _endpoint = null;
  private sessionBeans.AdminAuditoriaBean adminAuditoriaBean = null;
  
  public AdminAuditoriaBeanProxy() {
    _initAdminAuditoriaBeanProxy();
  }
  
  public AdminAuditoriaBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initAdminAuditoriaBeanProxy();
  }
  
  private void _initAdminAuditoriaBeanProxy() {
    try {
      adminAuditoriaBean = (new sessionBeans.AdminAuditoriaBeanServiceLocator()).getAdminAuditoriaBeanPort();
      if (adminAuditoriaBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)adminAuditoriaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)adminAuditoriaBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (adminAuditoriaBean != null)
      ((javax.xml.rpc.Stub)adminAuditoriaBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sessionBeans.AdminAuditoriaBean getAdminAuditoriaBean() {
    if (adminAuditoriaBean == null)
      _initAdminAuditoriaBeanProxy();
    return adminAuditoriaBean;
  }
  
  public java.lang.String recepcionarInformes(sessionBeans.MensajeLogVO arg0) throws java.rmi.RemoteException{
    if (adminAuditoriaBean == null)
      _initAdminAuditoriaBeanProxy();
    return adminAuditoriaBean.recepcionarInformes(arg0);
  }
  
  
}