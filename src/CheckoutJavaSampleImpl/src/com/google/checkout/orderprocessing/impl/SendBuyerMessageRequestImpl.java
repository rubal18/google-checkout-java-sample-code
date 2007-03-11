package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.AbstractSendBuyerMessageRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class SendBuyerMessageRequestImpl extends AbstractSendBuyerMessageRequest{
	Document document;
	Element root;
	
	public SendBuyerMessageRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String message) {
		super(merchantConstants, googleOrderNo, message);
		
		if (!isWithinMessageStringLimits(message))
		{
			message = "";
			System.err.println(Constants.messageErrorString);
		}

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "send-buyer-message"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
	      
	      Element messageTag;
	      messageTag =  (Element) document.createElement("message");
	      root.appendChild(messageTag);
	      messageTag.appendChild(document.createTextNode(message));
	}
	
	public SendBuyerMessageRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String message, boolean sendEmail) {
		this(merchantConstants, googleOrderNo, message);
		
	    Utils.createNewElementAndSet(document, root, "send-email", sendEmail);
	}
	
	public boolean isWithinMessageStringLimits(String message)
	{
		int lenStrMessage = message.length();
		
		if (lenStrMessage <= Constants.messageStrLimit)
			return true;
		else
			return false;
	}
	
	public void addSendEmail(boolean sEmail)
	{
		Utils.findElementElseCreateAndSet(document, root, "send-email", sEmail);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToString(document);

	}
}
