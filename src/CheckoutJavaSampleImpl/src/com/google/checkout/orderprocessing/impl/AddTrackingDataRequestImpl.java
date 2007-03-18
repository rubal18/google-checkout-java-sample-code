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

	public AddTrackingDataRequestImpl(MerchantConstants merchantConstants) {
		super(merchantConstants);

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS(Constants.checkoutNamespace, "add-tracking-data"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	}


	public AddTrackingDataRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {
		this(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
	
	public String getXml() {
		return Utils.documentToString(document);
	}
	
	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}

	public String getPostUrl() {
		return "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";	
	}

	public String getCarrier() {
		Element trackingDataTag = Utils.findContainerElseCreate(document, root, "tracking-data");	
        return Utils.getElementStringValue(document, trackingDataTag, "carrier");		
	}

	public String getGoogleOrderNo() {
		return Utils.getElementStringValue(document, root, "google-order-number");
	}

	public String getTrackingNo() {
		Element trackingDataTag = Utils.findContainerElseCreate(document, root, "tracking-data");	
        return Utils.getElementStringValue(document, trackingDataTag, "tracking-number");	
	}

	public void setCarrier(String carrier) {
		Element trackingDataTag = Utils.findContainerElseCreate(document, root, "tracking-data");	
        Utils.createNewElementAndSet(document, trackingDataTag, "carrier", carrier);
	}

	public void setGoogleOrderNo(String googleOrderNo) {
	      root.setAttribute("google-order-number", googleOrderNo);
	}

	public void setTrackingNo(String trackingNo) {
		Element trackingDataTag = Utils.findContainerElseCreate(document, root, "tracking-data");	
        Utils.createNewElementAndSet(document, trackingDataTag, "tracking-number", trackingNo);	
	}
}
