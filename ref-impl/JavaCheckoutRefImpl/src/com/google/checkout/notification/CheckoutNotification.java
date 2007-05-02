package com.google.checkout.notification;

import java.io.InputStream;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.util.Utils;

public abstract class CheckoutNotification {

	protected Document document;

	protected Element root;
	
	/**
	   * Return the Google Order Number for this notification.
	   *  
	   * @return The Google Order Number.
	   */
	  public String getGoogleOrderNo() {
		  return Utils.getElementStringValue(document, root, "google-order-number");
	  }
	  
	  
	  public Date getTimestamp() {
		  return Utils.getElementDateValue(document, root, "timestamp");
		  }
	  
	  public String getSerialNumber() {
		  return root.getAttribute("serial-number");
		  }
}
