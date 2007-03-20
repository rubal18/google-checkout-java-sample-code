package com.google.checkout.example.notification;

import java.util.Date;

import org.w3c.dom.Document;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.notification.OrderStateChangeNotificationProcessor;
import com.google.checkout.webappexample.util.GoogleOrder;

public class OrderStateChangeNotificationProcessorImpl extends AbstractNotificationProcessor implements
		OrderStateChangeNotificationProcessor {

	MerchantConstants merchantConstants;
	
	public OrderStateChangeNotificationProcessorImpl(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}
	
	public String process(String callbackXML) {

		String ack = "";
		try {
			Document document = Utils.newDocumentFromString(callbackXML);
			
			String orderNumber = Utils.getElementStringValue(document, document.getDocumentElement(), "google-order-number");
			Date timestamp = Utils.getElementDateValue(document, document.getDocumentElement(), "timestamp");
			String lastFulStatus = Utils.getElementStringValue(document, document.getDocumentElement(), "new-fulfillment-order-state");
			String lastFinStatus = Utils.getElementStringValue(document, document.getDocumentElement(), "new-financial-order-state");
			
			GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants.getMerchantId(), orderNumber);			
			order.setLastFulStatus(lastFulStatus);
			order.setLastFinStatus(lastFinStatus);
			ack = getAckString();
			
			order.addIncomingMessage(timestamp, document.getDocumentElement().getNodeName(), Utils.documentToStringPretty(document), ack);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ack;
	}

}
