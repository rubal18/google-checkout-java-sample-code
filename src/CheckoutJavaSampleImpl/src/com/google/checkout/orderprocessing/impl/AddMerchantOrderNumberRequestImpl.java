package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0 - ksim - March 6th, 2007 - 	Initial Version
 * 				1.1 - ksim - March 10th, 2007 - Fixed and made changes to reference correct Util functions.
 *
 */

public final class AddMerchantOrderNumberRequestImpl extends AbstractCheckoutRequest implements AddMerchantOrderNumberRequest {

	Document document;
	Element root;

	public AddMerchantOrderNumberRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "add-merchant-order-number"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);      	
	}
	
	public AddMerchantOrderNumberRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String merchantOrderNo) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMerchantOrderNo(merchantOrderNo);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);

	}

	public String getGoogleOrderNo() {
		return root.getAttribute("google-order-number");
	}

	public String getMerchantOrderNo() {
		return Utils.getElementStringValue(document, root, "merchant-order-number");
	}

	public void setGoogleOrderNo(String googleOrderNo) {
		root.setAttribute("google-order-number", googleOrderNo);
	}

	public void setMerchantOrderNo(String merchantOrderNo) {
		Utils.createNewElementAndSet(document, root, "merchant-order-number", merchantOrderNo);
	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
	    return "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";	
	}
}
