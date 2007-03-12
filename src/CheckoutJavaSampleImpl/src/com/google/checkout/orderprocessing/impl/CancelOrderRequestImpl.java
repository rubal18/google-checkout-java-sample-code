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
	
	public CancelOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason) {
		super(merchantConstants);
		
		if (!isWithinCancelStringLimits(reason, ""))
		{
			reason = "";
			System.err.println(Constants.cancelErrorString);
		}

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "cancel-order"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
	      
	      Element reasonTag;
	      reasonTag =  (Element) document.createElement("reason");
	      root.appendChild(reasonTag);
	      reasonTag.appendChild(document.createTextNode(reason));
	}
	
	public CancelOrderRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String reason, String comment) {
		this(merchantConstants, googleOrderNo, reason);
		
		if (!isWithinCancelStringLimits("", comment))
		{
			comment = "";
			System.err.println(Constants.cancelErrorString);
		}

	    Utils.createNewElementAndSet(document, root, "comment", comment);
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
	
	public void addComment(String cmt)
	{
		if (!isWithinCancelStringLimits("", cmt))
		{
			System.err.println(Constants.cancelErrorString);
			return;
		}
		
		Utils.findElementElseCreateAndSet(document, root, "comment", cmt);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToString(document);

	}

	public String getPostUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getComment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoogleOrderNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReason() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setComment(String comment) {
		// TODO Auto-generated method stub
		
	}

	public void setGoogleOrderNo(String googleOrderNo) {
		// TODO Auto-generated method stub
		
	}

	public void setReason(String reason) {
		// TODO Auto-generated method stub
		
	}
}
