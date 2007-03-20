package com.google.checkout.example.notification;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;

public class AbstractNotificationProcessor {

	protected String getAckString() {
	      Document document = Utils.newEmptyDocument();
	      Element root = (Element) document.createElementNS(Constants.checkoutNamespace, "notification-acknowledgment"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", Constants.checkoutNamespace);
	      document.appendChild(root);
	      return Utils.documentToStringPretty(document);
	}
}
