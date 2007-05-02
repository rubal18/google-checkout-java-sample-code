package com.google.checkout.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.google.checkout.util.Utils;

public abstract class MerchantCodes {
	
	protected Document document;
	protected Element element;
 	
	public float getAppliedAmount() {
		return Utils.getElementFloatValue(document, element, "applied-amount");
	}
	
	public float getCalculatedAmount() {
		return Utils.getElementFloatValue(document, element, "calculated-amount");
	}
	
	public String getCode() {
		return Utils.getElementStringValue(document, element, "code");
	}
	
	public String getMessage() {
		return Utils.getElementStringValue(document, element, "message");
	}
}
