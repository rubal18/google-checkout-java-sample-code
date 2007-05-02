package com.google.checkout.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FlatRateShippingAdjustment extends Shipping {
	
	/**
	 * A constructor which takes the document and element pointing to the
	 * &lt;flat-rate-shipping-adjustment&gt; tag.
	 * 
	 * @param document
	 *            The document.
	 * @param element
	 *            The element.
	 */
	public FlatRateShippingAdjustment(Document document, Element element) {
		this.document = document;
		this.element = element;
	}
}
