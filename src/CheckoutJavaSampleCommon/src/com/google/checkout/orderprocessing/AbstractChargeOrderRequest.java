package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractChargeOrderRequest implements ChargeOrderRequest {

	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, float amount) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setAmount(amount);
	}
}
