package com.google.checkout.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.google.checkout.util.Utils;

public class Shipping {

	protected Document document;
	protected Element element;
 	
	public float getShippingCost() {
		return Utils.getElementFloatValue(document, element, "shipping-cost");
	}

	public String getShippingName() {
		return Utils.getElementStringValue(document, element, "shipping-name");
	}
}
