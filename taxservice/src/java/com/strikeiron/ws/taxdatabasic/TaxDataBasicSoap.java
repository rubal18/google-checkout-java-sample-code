/**
 * TaxDataBasicSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.strikeiron.ws.taxdatabasic;

public interface TaxDataBasicSoap extends java.rmi.Remote {

    /**
     * Get tax rate of a zipcode in US
     */
    public com.strikeiron.ws.taxdatabasic.TaxRateUSAData getTaxRateUS(java.lang.String zip_code) throws java.rmi.RemoteException;

    /**
     * Get tax rate of a province in Canada
     */
    public com.strikeiron.ws.taxdatabasic.TaxRateCanadaData getTaxRateCanada(java.lang.String province) throws java.rmi.RemoteException;
    public void getRemainingHits() throws java.rmi.RemoteException;
}
