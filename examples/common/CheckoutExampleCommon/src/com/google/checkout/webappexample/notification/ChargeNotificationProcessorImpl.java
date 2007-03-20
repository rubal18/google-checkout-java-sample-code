package com.google.checkout.webappexample.notification;

import java.util.Date;

import org.w3c.dom.Document;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.notification.ChargeNotificationProcessor;
import com.google.checkout.webappexample.util.GoogleOrder;

public class ChargeNotificationProcessorImpl extends AbstractNotificationProcessor implements
		ChargeNotificationProcessor {

	MerchantConstants merchantConstants;
	
	public ChargeNotificationProcessorImpl(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}
	
	public String process(String callbackXML) {

		String ack = "";
		try {
			Document document = Utils.newDocumentFromString(callbackXML);
			
			String orderNumber = Utils.getElementStringValue(document, document.getDocumentElement(), "google-order-number");
			Date timestamp = Utils.getElementDateValue(document, document.getDocumentElement(), "timestamp");
			
			GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants.getMerchantId(), orderNumber);
			
			order.addIncomingMessage(timestamp, document.getDocumentElement().getNodeName(), Utils.documentToStringPretty(document), ack);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ack;
	}
}
