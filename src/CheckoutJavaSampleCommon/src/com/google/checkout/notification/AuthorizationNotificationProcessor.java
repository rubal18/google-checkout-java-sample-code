package com.google.checkout.notification;

public interface AuthorizationNotificationProcessor {

	public String process(String callbackXML);

}
