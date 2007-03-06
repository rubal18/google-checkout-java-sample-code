package com.google.checkout.orderprocessing;

public abstract class AbstractRefundOrderRequest implements RefundOrderRequest {

	public AbstractRefundOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String reason) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractRefundOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String reason,
			String currencyCode, float amount, String comment) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setCurrencyCode(currencyCode);
		this.setAmount(amount);
		this.setComment(comment);
	}
}
