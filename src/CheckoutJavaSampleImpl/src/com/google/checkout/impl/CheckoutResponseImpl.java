package com.google.checkout.impl;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.checkout.impl.AbstractCheckoutResponse;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0
 * @todo		Not unit tested yet.
 *
 */

public class CheckoutResponseImpl extends AbstractCheckoutResponse{
	
	String response;
	
	public CheckoutResponseImpl() {
		processResponse("");
	}
	
	public CheckoutResponseImpl(String response) {
		processResponse(response);
	}

	protected void processResponse(String response)
	{
		this.response = response;
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
		return "";
	}

	/**
	 * Gets the response XML sent by Google. <value>The response XML sent by
	 * Google.</value>
	 */
	public String getResponseXml()
	{
		return response;
	}
}
