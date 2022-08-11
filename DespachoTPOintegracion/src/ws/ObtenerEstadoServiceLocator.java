/**
 * ObtenerEstadoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class ObtenerEstadoServiceLocator extends org.apache.axis.client.Service implements ws.ObtenerEstadoService {

    public ObtenerEstadoServiceLocator() {
    }


    public ObtenerEstadoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ObtenerEstadoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ObtenerEstadoPort
    private java.lang.String ObtenerEstadoPort_address = "http://localhost:8080/Portal/ObtenerEstado";

    public java.lang.String getObtenerEstadoPortAddress() {
        return ObtenerEstadoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ObtenerEstadoPortWSDDServiceName = "ObtenerEstadoPort";

    public java.lang.String getObtenerEstadoPortWSDDServiceName() {
        return ObtenerEstadoPortWSDDServiceName;
    }

    public void setObtenerEstadoPortWSDDServiceName(java.lang.String name) {
        ObtenerEstadoPortWSDDServiceName = name;
    }

    public ws.ObtenerEstado getObtenerEstadoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ObtenerEstadoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getObtenerEstadoPort(endpoint);
    }

    public ws.ObtenerEstado getObtenerEstadoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.ObtenerEstadoServiceSoapBindingStub _stub = new ws.ObtenerEstadoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getObtenerEstadoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setObtenerEstadoPortEndpointAddress(java.lang.String address) {
        ObtenerEstadoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.ObtenerEstado.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.ObtenerEstadoServiceSoapBindingStub _stub = new ws.ObtenerEstadoServiceSoapBindingStub(new java.net.URL(ObtenerEstadoPort_address), this);
                _stub.setPortName(getObtenerEstadoPortWSDDServiceName());
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
        if ("ObtenerEstadoPort".equals(inputPortName)) {
            return getObtenerEstadoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "ObtenerEstadoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "ObtenerEstadoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ObtenerEstadoPort".equals(portName)) {
            setObtenerEstadoPortEndpointAddress(address);
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
