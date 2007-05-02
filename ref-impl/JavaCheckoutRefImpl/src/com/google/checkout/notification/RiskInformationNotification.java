package com.google.checkout.notification;

import java.io.InputStream;

import org.w3c.dom.Element;

import com.google.checkout.util.Utils;

public class RiskInformationNotification extends CheckoutNotification {

	Element riskInfo;
	
	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public RiskInformationNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
		riskInfo = Utils.findElementOrContainer(document, root, "risk-information");
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public RiskInformationNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
		riskInfo = Utils.findElementOrContainer(document, root, "risk-information");
	}
	
	public boolean isEligibleForProtection() {
		return Utils.getElementBooleanValue(document, riskInfo, "eligible-for-protection");
	}

	public Address getBillingAddress() {
		Element address = Utils.findElementOrContainer(document, riskInfo, "billing-address");
		return new Address(document, address);
	}

	public String getAvsResponse() {
		return Utils.getElementStringValue(document, riskInfo, "avs-response");
	}

	public String getCvnResponse() {
		return Utils.getElementStringValue(document, riskInfo, "cvn-response");
	}

	public String getPartialCcNumber() {
		return Utils.getElementStringValue(document, riskInfo, "partial-cc-number");
	}

	public int getBuyerAccountAge() {
		return Utils.getElementIntValue(document, riskInfo, "buyer-account-age");
	}

	public String getIpAddress() {
		return Utils.getElementStringValue(document, riskInfo, "ip-address");
	}
}
