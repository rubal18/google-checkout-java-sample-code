package com.google.checkout.notification;

public interface ChargebackNotificationProcessor {

	public String process(String callbackXML);

}
