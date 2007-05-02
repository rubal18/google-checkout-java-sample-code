package com.google.checkout.notification;

import java.io.InputStream;

import com.google.checkout.util.Utils;

public class ChargebackAmountNotification extends CheckoutNotification {

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public ChargebackAmountNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public ChargebackAmountNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
	}
	
	public float getLatestChargebackAmount() {
		return Utils.getElementFloatValue(document, root, "latest-chargeback-amount");
	}

	public float getTotalChargebackAmount() {
		return Utils.getElementFloatValue(document, root, "total-chargeback-amount");	}

	public String getCurrencyCode() {
		return Utils.findElementOrContainer(document, root, "latest-chargeback-amount").getAttribute("currency");
	}
}
