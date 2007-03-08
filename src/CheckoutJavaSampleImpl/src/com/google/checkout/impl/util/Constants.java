package com.google.checkout.impl.util;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0
 * @todo		Not unit tested yet.
 *
 */

public class Constants {

	// Encode Helper Constants
	public static final String ampReplaceStr = "&#x26;";
	public static final String lessThanReplaceStr = "&#x3c;";
	public static final String greaterThanReplaceStr = "&#x3e;";
      
	public static final String ampStr = "&";
	public static final String lessThanStr = "<";
	public static final String greaterThanStr = ">";
	
	// Checkout Post URL
	public static final String sandboxPostURL = "https://sandbox.google.com/checkout/cws/v2/Merchant/{0}/merchantCheckout";
	public static final String checkoutPostURL = "https://checkout.google.com/checkout/cws/v2/Merchant/{0}/merchantCheckout";
}
