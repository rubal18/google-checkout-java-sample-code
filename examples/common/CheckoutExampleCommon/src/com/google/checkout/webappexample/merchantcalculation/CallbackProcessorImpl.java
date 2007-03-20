package com.google.checkout.webappexample.merchantcalculation;

import com.google.checkout.MerchantConstants;
import com.google.checkout.merchantcalculation.CallbackProcessor;

public class CallbackProcessorImpl implements CallbackProcessor {

	MerchantConstants merchantConstants;
	
	public CallbackProcessorImpl(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}
	
	public String process(String callbackXML) {
		// TODO Auto-generated method stub
		return null;
	}

}
