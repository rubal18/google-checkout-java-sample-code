package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

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
