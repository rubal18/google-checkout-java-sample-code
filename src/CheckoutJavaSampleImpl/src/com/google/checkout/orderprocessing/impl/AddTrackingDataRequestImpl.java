package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class AddTrackingDataRequestImpl extends AbstractCheckoutRequest implements AddTrackingDataRequest {
	
	Document document;
	Element root;
	
	public AddTrackingDataRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {
		  super(merchantConstants);
		
	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "add-tracking-data"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
		
		Element trackingDataTag = Utils.findContainerElseCreate(document, root, "tracking-data");	
        Utils.createNewElementAndSet(document, trackingDataTag, "carrier", carrier);
        Utils.createNewElementAndSet(document, trackingDataTag, "tracking-number", trackingNo);	
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

	public String getCarrier() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGoogleOrderNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTrackingNo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCarrier(String carrier) {
		// TODO Auto-generated method stub
		
	}

	public void setGoogleOrderNo(String googleOrderNo) {
		// TODO Auto-generated method stub
		
	}

	public void setTrackingNo(String trackingNo) {
		// TODO Auto-generated method stub
		
	}
}
