/**
 * PortalWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package iaPortalWeb;

public interface PortalWebService extends javax.xml.rpc.Service {
    public java.lang.String getPortalWebPortAddress();

    public iaPortalWeb.PortalWeb getPortalWebPort() throws javax.xml.rpc.ServiceException;

    public iaPortalWeb.PortalWeb getPortalWebPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
