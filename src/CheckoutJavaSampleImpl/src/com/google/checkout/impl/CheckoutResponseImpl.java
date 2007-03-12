package com.google.checkout.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.impl.util.Utils;


/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0 - ksim - March 7th, 2007 - 	Initial Version to separate interface and implementation		
 * @todo		Not unit tested yet, but tested fairly well over all.
 * 				Still missing extra function implementations
 *
 */

public class CheckoutResponseImpl extends AbstractCheckoutResponse{
	
	Document document;
	
	public CheckoutResponseImpl() {
		processResponse("");
	}
	
	public CheckoutResponseImpl(String response) {
		processResponse(response);
	}

	protected void processResponse(String response)
	{
	    document = Utils.newDocumentFromString(response);
	}
	
	public boolean isValidRequest()
	{
		return true;
	}

	/**
	 * Gets the serial number. Google attaches a unique serial number to every
	 * response. <value> The serial number, for example
	 * 58ea39d3-025b-4d52-a697-418f0be74bf9. </value>
	 */
	public String getSerialNumber()
	{
		return "";
	}

	/**
	 * If Google responded with an error (IsGood = false) then this property
	 * will contain the human-readable error message. <value> The error message
	 * returned by Google, or an empty string if there was no error. </value>
	 */
	public String getErrorMessage()
	{
		return "";
	}

	/**
	 * If Google indicated a redirect URL in the response, this property will
	 * contain the URL string. <value> The redirect URL, or the empty string if
	 * Google didn't send a redirect URL. </value>
	 */
	public String getRedirectUrl()
	{
		Element redirect = Utils.findElementOrContainer(document, document.getDocumentElement(), "redirect-url");
		if (redirect != null) {return redirect.getTextContent();}
		return "<error!>";
	}

	public String getXml() {
		return Utils.documentToString(document);
	}

	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}
}
