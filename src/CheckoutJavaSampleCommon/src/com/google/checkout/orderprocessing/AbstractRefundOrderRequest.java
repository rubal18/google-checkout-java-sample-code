package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

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
