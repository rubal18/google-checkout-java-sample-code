/**
 * 
 */
package com.google.checkout.checkout.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.USArea;
import com.google.checkout.impl.util.Utils;

/**
 * @author simonjsmith
 *
 */
public class ShippingRestrictionsImpl implements ShippingRestrictions {

	Document document;
	Element root;
	
	public ShippingRestrictionsImpl() {
		
		document = Utils.newEmptyDocument();
	    root =  (Element) document.createElement("shipping-restrictions"); 
	    document.appendChild(root);
	}
	
	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedCountryArea(com.google.checkout.checkout.USArea)
	 */
	public void addAllowedCountryArea(USArea countryArea) {
        
		Element allowedAreas = Utils.findContainerElseCreate(document, root, "allowed-areas");        
        Element usCountry = Utils.createNewContainer(document, allowedAreas, "us-country-area");
        usCountry.setAttribute("country-area", countryArea.toString());
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedStateCode(java.lang.String)
	 */
	public void addAllowedStateCode(String stateCode) {
        
		Element allowedAreas = Utils.findContainerElseCreate(document, root, "allowed-areas");        
        Element usState = Utils.createNewContainer(document, allowedAreas, "us-state-area");
        Utils.createNewElementAndSet(document, usState, "state", stateCode);        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedZipPattern(java.lang.String)
	 */
	public void addAllowedZipPattern(String zipPattern) {

		Element allowedAreas = Utils.findContainerElseCreate(document, root, "allowed-areas");        
        Element usZip = Utils.createNewContainer(document, allowedAreas, "us-zip-area");
        Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedCountryArea(com.google.checkout.checkout.USArea)
	 */
	public void addExcludedCountryArea(USArea countryArea) {
		
        Element excludedAreas = Utils.findContainerElseCreate(document, root, "excluded-areas");
        Element usCountry = Utils.createNewContainer(document, excludedAreas, "us-country-area");
        usCountry.setAttribute("country-area", countryArea.toString());
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedStateCode(java.lang.String)
	 */
	public void addExcludedStateCode(String stateCode) {

		Element excludedAreas = Utils.findContainerElseCreate(document, root, "excluded-areas");
        Element usState = Utils.createNewContainer(document, excludedAreas, "us-state-area");
        Utils.createNewElementAndSet(document, usState, "state", stateCode);    
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedZipPattern(java.lang.String)
	 */
	public void addExcludedZipPattern(String zipPattern) {

		Element excludedAreas = Utils.findContainerElseCreate(document, root, "excluded-areas");
        Element usZip = Utils.createNewContainer(document, excludedAreas, "us-zip-area");
        Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.ShippingRestrictions#getRootElement()
	 */
	public Element getRootElement() {
		return root;
	}
}
