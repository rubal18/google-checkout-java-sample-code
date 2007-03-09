/**
 * 
 */
package com.google.checkout.checkout.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.USArea;
import com.google.checkout.impl.util.Utils;

/**
 * @author simonjsmith
 *
 */
public class TaxAreaImpl implements TaxArea {

	Document document;
	Element root;
	
	public TaxAreaImpl() {
		
		document = Utils.newEmptyDocument();
	    root =  (Element) document.createElement("tax-area"); 
	    document.appendChild(root);
	}
	
	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.TaxArea#addCountryArea(com.google.checkout.checkout.USArea)
	 */
	public void addCountryArea(USArea countryArea) {

		Element usCountry = Utils.createNewContainer(document, root, "us-country-area");
        usCountry.setAttribute("country-area", countryArea.toString());
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.TaxArea#addStateCode(java.lang.String)
	 */
	public void addStateCode(String stateCode) {

        Element usState = Utils.createNewContainer(document, root, "us-state-area");
        Utils.createNewElementAndSet(document, usState, "state", stateCode);        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.TaxArea#addZipPattern(java.lang.String)
	 */
	public void addZipPattern(String zipPattern) {

        Element usZip = Utils.createNewContainer(document, root, "us-zip-area");
        Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.TaxArea#getRootElement()
	 */
	public Element getRootElement() {
		return root;
	}

}
