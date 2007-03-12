package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class UnarchiveOrderRequestImpl extends AbstractCheckoutRequest implements UnarchiveOrderRequest {
	
	Document document;
	Element root;
	
	public UnarchiveOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo) {
		super(merchantConstants);

		
	      document = Utils.newEmptyDocument();
	      root = (Element) document.createElementNS(Constants.checkoutNamespace, "unarchive-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToString(document);
	}

	public String getGoogleOrderNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGoogleOrderNo(String googleOrderNo) {
		// TODO Auto-generated method stub
		
	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}
