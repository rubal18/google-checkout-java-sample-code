package com.google.checkout.notification;

import java.io.InputStream;
import java.util.Date;

import com.google.checkout.util.Utils;

public class AuthorizationAmountNotification extends CheckoutNotification {

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public AuthorizationAmountNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public AuthorizationAmountNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
	}

	

	public String getAvsResponse() {
		return Utils.getElementStringValue(document, root, "avs-response");
	  }
	
	public String getCvnResponse() {
		return Utils.getElementStringValue(document, root, "cvn-response");
	  }
	
	public float getAuthorizationAmount() {
		return Utils.getElementFloatValue(document, root, "authorization-amount");
	  }
	
	public String getCurrentyCode() {
		return Utils.findElementOrContainer(document, root, "authorization-amount").getAttribute("currency");
	  }
	
	public Date getAuthorizationExpirationDate() {
		
	    return Utils.getElementDateValue(document, root, "authorization-expiration-date");
	  }
	
}
