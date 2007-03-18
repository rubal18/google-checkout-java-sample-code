package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class SendBuyerMessageRequestImpl extends AbstractCheckoutRequest implements SendBuyerMessageRequest {
	Document document;
	Element root;
	
	public SendBuyerMessageRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);
	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "send-buyer-message"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	}
	
	public SendBuyerMessageRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String message) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMessage(message);
	}
	
	public SendBuyerMessageRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String message, boolean sendEmail) {
		this(merchantConstants, googleOrderNo, message);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMessage(message);
		this.setSendEmail(sendEmail);
	}
	
	public boolean isWithinMessageStringLimits(String message)
	{
		int lenStrMessage = message.length();
		
		if (lenStrMessage <= Constants.messageStrLimit)
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

	public String getGoogleOrderNo() {
		return root.getAttribute("google-order-number");
	}

	public String getMessage() {
		return Utils.getElementStringValue(document, root, "message");
	}

	public boolean isSendEmail() {
		return Utils.getElementBooleanValue(document, root, "send-email");
	}

	public void setGoogleOrderNo(String googleOrderNo) {
	      root.setAttribute("google-order-number", googleOrderNo);
	}

	public void setMessage(String message) {
		if (!isWithinMessageStringLimits(message))
		{
			message = "";
			System.err.println(Constants.messageErrorString);
		}

	      
	      Element messageTag;
	      messageTag =  (Element) document.createElement("message");
	      root.appendChild(messageTag);
	      messageTag.appendChild(document.createTextNode(message));
	}

	public void setSendEmail(boolean sendEmail) {
        Utils.createNewElementAndSet(document, root, "send-email", sendEmail);		
	}
}
