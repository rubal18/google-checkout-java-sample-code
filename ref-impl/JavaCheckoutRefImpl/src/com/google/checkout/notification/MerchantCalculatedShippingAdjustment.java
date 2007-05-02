package com.google.checkout.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MerchantCalculatedShippingAdjustment extends Shipping {

	/**
	 * A constructor which takes the document and element pointing to the
	 * &lt;merchant-calculated-shipping-adjustment&gt; tag.
	 * 
	 * @param document
	 *            The document.
	 * @param element
	 *            The element.
	 */
	public MerchantCalculatedShippingAdjustment(Document document, Element element) {
		this.document = document;
		this.element = element;
	}
}
