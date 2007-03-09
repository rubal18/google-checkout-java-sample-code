package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractCancelOrderRequest implements CancelOrderRequest {

	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
	}

	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason, String comment) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setComment(comment);

	}

}
