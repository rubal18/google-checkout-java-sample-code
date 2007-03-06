package com.google.checkout.notification;

public interface OrderStateChangeNotificationProcessor {

	public String process(String callbackXML);

}
