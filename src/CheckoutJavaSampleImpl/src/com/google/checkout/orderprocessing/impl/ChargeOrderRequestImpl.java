package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.ChargeOrderRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class ChargeOrderRequestImpl extends AbstractCheckoutRequest implements ChargeOrderRequest {
	Document document;
	Element root;

	public ChargeOrderRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "charge-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	}

	public ChargeOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo) {
		  
		this(merchantConstants);
	      setGoogleOrderNo(googleOrderNo);
	}	
	
	public ChargeOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, float amt) {
	 	
		this(merchantConstants);
	 	this.setGoogleOrderNo(googleOrderNo);
        this.setAmount(amt);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}

	public float getAmount() {
		return Utils.getElementFloatValue(document, root, "amount");
	}

	public String getGoogleOrderNo() {
		return root.getAttribute("google-order-number");
	}

	public void setAmount(float amount) {
		Element e = Utils.findElementAndSetElseCreateAndSet(document, root, "amount", amount);
		e.setAttribute("currency", merchantConstants.getCurrencyCode());
	}

	public void setGoogleOrderNo(String googleOrderNo) {
	      root.setAttribute("google-order-number", googleOrderNo);
	}

	public String getPostUrl() {
		//TODO
	      return "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";	
	}
}
