package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractProcessOrderRequest implements
		ProcessOrderRequest {

	public AbstractProcessOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		this.setGoogleOrderNo(googleOrderNo);
	}
}
