package com.google.checkout.notification;

import java.io.InputStream;

import com.google.checkout.util.Utils;

public class RefundAmountNotification extends CheckoutNotification {

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public RefundAmountNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public RefundAmountNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
	}
	
	public float getLatestRefundAmount() {
		return Utils.getElementFloatValue(document, root, "latest-refund-amount");	
	}

	public float getTotalRefundAmount() {
		return Utils.getElementFloatValue(document, root, "total-refund-amount");	
	}
	
	public String getCurrencyCode() {
		return Utils.findElementOrContainer(document, root, "latest-refund-amount").getAttribute("currency");
	}
}
