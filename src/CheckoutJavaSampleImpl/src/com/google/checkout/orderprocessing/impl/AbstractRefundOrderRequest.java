package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.RefundOrderRequest;

public abstract class AbstractRefundOrderRequest extends AbstractCheckoutRequest implements RefundOrderRequest {

	public AbstractRefundOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractRefundOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason, float amount, String comment) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setAmount(amount);
		this.setComment(comment);
	}
}
