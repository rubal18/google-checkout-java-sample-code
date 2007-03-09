package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractRefundOrderRequest implements RefundOrderRequest {

	public AbstractRefundOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason) {

		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractRefundOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason, float amount, String comment) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setAmount(amount);
		this.setComment(comment);
	}
}
