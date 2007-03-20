package com.google.checkout.example.notification;

import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.notification.NewOrderNotificationProcessor;
import com.google.checkout.webappexample.util.GoogleOrder;

public class NewOrderNotificationProcessorImpl extends AbstractNotificationProcessor implements
		NewOrderNotificationProcessor {

	MerchantConstants merchantConstants;
	
	public NewOrderNotificationProcessorImpl(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}
	
	public String process(String callbackXML) {

		String ack = "";
		try {
			Document document = Utils.newDocumentFromString(callbackXML);
			
			String orderNumber = Utils.getElementStringValue(document, document.getDocumentElement(), "google-order-number");
			Date timestamp = Utils.getElementDateValue(document, document.getDocumentElement(), "timestamp");
			String lastFulStatus = Utils.getElementStringValue(document, document.getDocumentElement(), "fulfillment-order-state");
			String lastFinStatus = Utils.getElementStringValue(document, document.getDocumentElement(), "financial-order-state");
			Element billing = Utils.findElementOrContainer(document, document.getDocumentElement(), "buyer-billing-address");
			String buyerEmail = Utils.getElementStringValue(document, billing, "email");
			String orderAmount = Utils.getElementStringValue(document, document.getDocumentElement(), "order-total");
			
			GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants.getMerchantId(), orderNumber);			
			order.setLastFulStatus(lastFulStatus);
			order.setLastFinStatus(lastFinStatus);
			order.setBuyerEmail(buyerEmail);
			order.setOrderAmount(orderAmount);			
			ack = getAckString();
			
			order.addIncomingMessage(timestamp, document.getDocumentElement().getNodeName(), Utils.documentToStringPretty(document), ack);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ack;
	}

}
