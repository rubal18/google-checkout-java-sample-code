package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.ProcessOrderRequest;

public abstract class AbstractProcessOrderRequest extends AbstractCheckoutRequest implements
		ProcessOrderRequest {

	public AbstractProcessOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}
}
