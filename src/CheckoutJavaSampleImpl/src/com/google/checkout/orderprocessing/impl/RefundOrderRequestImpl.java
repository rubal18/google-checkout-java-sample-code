package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.RefundOrderRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class RefundOrderRequestImpl extends AbstractCheckoutRequest implements RefundOrderRequest {
	Document document;
	Element root;
	
	public RefundOrderRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);
	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "refund-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);	
	}
	
	public RefundOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
	}
	
	public RefundOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason, float amount, String comment) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setAmount(amount);
		this.setComment(comment);
	}
	
	public boolean isWithinRefundStringLimits(String reason, String comment)
	{
		int lenStrReason = reason.length();
		int lenStrComment = comment.length();
		
		if (lenStrReason <= Constants.refundStrLimit && lenStrComment <= Constants.refundStrLimit)
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

	public float getAmount() {
		return Utils.getElementFloatValue(document, root, "amount");
	}

	public String getComment() {
		return Utils.getElementStringValue(document, root, "comment");
	}

	public String getGoogleOrderNo() {
		return Utils.getElementStringValue(document, root, "google-order-number");
	}

	public String getReason() {
		return Utils.getElementStringValue(document, root, "reason");
	}

	public void setAmount(float amount) {	    
		Element e = Utils.findElementAndSetElseCreateAndSet(document, root, "amount", amount);
		e.setAttribute("currency", merchantConstants.getCurrencyCode());
	}

	public void setComment(String comment) {
		if (!isWithinRefundStringLimits("", comment))
		{
			comment = "";
			System.err.println(Constants.refundErrorString);
		}
		
	    Utils.createNewElementAndSet(document, root, "comment", comment);
	}

	public void setGoogleOrderNo(String googleOrderNo) {
	      root.setAttribute("google-order-number", googleOrderNo);
	}

	public void setReason(String reason) {
		if (!isWithinRefundStringLimits(reason, ""))
		{
			reason = "";
			System.err.println(Constants.refundErrorString);
		}

	      
	      Element reasonTag;
	      reasonTag =  (Element) document.createElement("reason");
	      root.appendChild(reasonTag);
	      reasonTag.appendChild(document.createTextNode(reason));
	}
}
