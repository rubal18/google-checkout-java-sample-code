package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.ChargeOrderRequest;

public abstract class AbstractChargeOrderRequest extends AbstractCheckoutRequest implements ChargeOrderRequest {

	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, float amount) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setAmount(amount);
	}
}
