package com.google.checkout.notification;

import java.io.InputStream;

import com.google.checkout.util.Utils;

public class ChargeAmountNotification extends CheckoutNotification {

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public ChargeAmountNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public ChargeAmountNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
	}
	
	public float getLatestChargeAmount() {
		return Utils.getElementFloatValue(document, root, "latest-charge-amount");
	}

	public float getTotalChargeAmount() {
		return Utils.getElementFloatValue(document, root, "total-charge-amount");
	}

	public String getCurrencyCode() {
		return Utils.findElementOrContainer(document, root, "latest-charge-amount").getAttribute("currency");
	}

}
