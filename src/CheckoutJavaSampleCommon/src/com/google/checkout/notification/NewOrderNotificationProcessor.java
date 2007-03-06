package com.google.checkout.notification;

public interface NewOrderNotificationProcessor {

	public String process(String callbackXML);

}
