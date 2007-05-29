/**
 * TaxDataBasicLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.strikeiron.ws.taxdatabasic;

public class TaxDataBasicLocator extends org.apache.axis.client.Service implements com.strikeiron.ws.taxdatabasic.TaxDataBasic {

    public TaxDataBasicLocator() {
    }


    public TaxDataBasicLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TaxDataBasicLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TaxDataBasicSoap
    private java.lang.String TaxDataBasicSoap_address = "http://ws.strikeiron.com/StrikeIron/taxdatabasic";

    public java.lang.String getTaxDataBasicSoapAddress() {
        return TaxDataBasicSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TaxDataBasicSoapWSDDServiceName = "TaxDataBasicSoap";

    public java.lang.String getTaxDataBasicSoapWSDDServiceName() {
        return TaxDataBasicSoapWSDDServiceName;
    }

    public void setTaxDataBasicSoapWSDDServiceName(java.lang.String name) {
        TaxDataBasicSoapWSDDServiceName = name;
    }

    public com.strikeiron.ws.taxdatabasic.TaxDataBasicSoap getTaxDataBasicSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TaxDataBasicSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTaxDataBasicSoap(endpoint);
    }

    public com.strikeiron.ws.taxdatabasic.TaxDataBasicSoap getTaxDataBasicSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.strikeiron.ws.taxdatabasic.TaxDataBasicSoapStub _stub = new com.strikeiron.ws.taxdatabasic.TaxDataBasicSoapStub(portAddress, this);
            _stub.setPortName(getTaxDataBasicSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTaxDataBasicSoapEndpointAddress(java.lang.String address) {
        TaxDataBasicSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.strikeiron.ws.taxdatabasic.TaxDataBasicSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.strikeiron.ws.taxdatabasic.TaxDataBasicSoapStub _stub = new com.strikeiron.ws.taxdatabasic.TaxDataBasicSoapStub(new java.net.URL(TaxDataBasicSoap_address), this);
                _stub.setPortName(getTaxDataBasicSoapWSDDServiceName());
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
        if ("TaxDataBasicSoap".equals(inputPortName)) {
            return getTaxDataBasicSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.strikeiron.com", "TaxDataBasic");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.strikeiron.com", "TaxDataBasicSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TaxDataBasicSoap".equals(portName)) {
            setTaxDataBasicSoapEndpointAddress(address);
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
