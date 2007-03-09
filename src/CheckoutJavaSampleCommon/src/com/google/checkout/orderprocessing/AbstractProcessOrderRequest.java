package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractProcessOrderRequest extends AbstractCheckoutRequest implements
		ProcessOrderRequest {

	public AbstractProcessOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}
}
