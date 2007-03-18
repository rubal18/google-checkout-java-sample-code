package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.CancelOrderRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class CancelOrderRequestImpl extends AbstractCheckoutRequest implements CancelOrderRequest {
	Document document;
	Element root;
	
	public CancelOrderRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);

		document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "cancel-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	}

	
	public CancelOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	    this.setReason(reason);  		
	}
	
	public CancelOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason, String comment) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setComment(comment);
	}
	
	public boolean isWithinCancelStringLimits(String reason, String comment)
	{
		int lenStrReason = reason.length();
		int lenStrComment = comment.length();
		
		if (lenStrReason <= Constants.cancelStrLimit && lenStrComment <= Constants.cancelStrLimit)
			return true;
		else
			return false;
	}
		
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		
		return Utils.documentToStringPretty(document);
	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
	      return "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";	
	}

	public String getComment() {

		return Utils.getElementStringValue(document, root, "comment");
	}

	public String getGoogleOrderNo() {
		
		return root.getAttribute("google-order-number");
	}

	public String getReason() {
		
		return Utils.getElementStringValue(document, root, "reason");
	}

	public void setComment(String comment) {

		if (!isWithinCancelStringLimits("", comment))
		{
			comment = "";
			System.err.println(Constants.cancelErrorString);
		}

	    Utils.createNewElementAndSet(document, root, "comment", comment);
	}

	public void setGoogleOrderNo(String googleOrderNo) {

	      root.setAttribute("google-order-number", googleOrderNo);		
	}

	public void setReason(String reason) {

		if (!isWithinCancelStringLimits(reason, ""))
		{
			reason = "";
			System.err.println(Constants.cancelErrorString);
		}	
		
	    Element reasonTag;
	    reasonTag =  (Element) document.createElement("reason");
	    root.appendChild(reasonTag);
	    reasonTag.appendChild(document.createTextNode(reason));
	}
}
