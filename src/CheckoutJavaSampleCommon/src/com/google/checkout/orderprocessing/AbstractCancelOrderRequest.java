package com.google.checkout.orderprocessing;

public abstract class AbstractCancelOrderRequest implements CancelOrderRequest {

	public AbstractCancelOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String reason) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
	}

	public AbstractCancelOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String reason, String comment) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setComment(comment);

	}

}
