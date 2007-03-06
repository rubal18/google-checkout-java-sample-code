package com.google.checkout.orderprocessing;

public abstract class AbstractUnarchiveOrderRequest implements
		UnarchiveOrderRequest {

	public AbstractUnarchiveOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);

	}

}
