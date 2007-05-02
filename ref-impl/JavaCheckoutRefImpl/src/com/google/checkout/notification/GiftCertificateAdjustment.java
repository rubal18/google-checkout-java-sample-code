package com.google.checkout.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GiftCertificateAdjustment extends MerchantCodes {

	/**
	 * A constructor which takes the document and element pointing to the
	 * &lt;gift-certificate-adjustment&gt; tag.
	 * 
	 * @param document
	 *            The document.
	 * @param element
	 *            The element.
	 */
	public GiftCertificateAdjustment(Document document, Element element) {
		this.document = document;
		this.element = element;
	}
}
