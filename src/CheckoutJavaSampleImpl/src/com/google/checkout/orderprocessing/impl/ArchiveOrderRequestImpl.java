package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class ArchiveOrderRequestImpl extends AbstractCheckoutRequest implements ArchiveOrderRequest {
	
	Document document;
	Element root;

	public ArchiveOrderRequestImpl(MerchantConstants merchantConstants) {
		  
		  super(merchantConstants);

	      document = Utils.newEmptyDocument();
	      root = (Element) document.createElementNS(Constants.checkoutNamespace, "archive-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	}

	public ArchiveOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo) {
		  this(merchantConstants);
		  this.setGoogleOrderNo(googleOrderNo);
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

	public void setGoogleOrderNo(String googleOrderNo) {
		root.setAttribute("google-order-number", googleOrderNo);
	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
	    return "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";	
	}

}
