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
	
	public ChargeOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo) {
		super(merchantConstants);

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "charge-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
	}
	
	public ChargeOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, float amt) {
		this(merchantConstants, googleOrderNo);
	    Utils.findElementElseCreateAndSetAndAttribute(document, root, "amount", new Float(amt).toString(), "currency", merchantConstants.getCurrencyCode());	
	}
	
	public void addAmount(float amt)
	{
		Utils.findElementElseCreateAndSetAndAttribute(document, root, "amount", new Float(amt).toString(), "currency", merchantConstants.getCurrencyCode());	
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToString(document);

	}

	public float getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getGoogleOrderNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAmount(float amount) {
		// TODO Auto-generated method stub
		
	}

	public void setGoogleOrderNo(String googleOrderNo) {
		// TODO Auto-generated method stub
		
	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}
