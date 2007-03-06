package com.google.checkout.orderprocessing;

public abstract class AbstractProcessOrderRequest implements
		ProcessOrderRequest {

	public AbstractProcessOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
	}
}
