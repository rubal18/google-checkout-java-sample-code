package com.google.checkout.orderprocessing;

public abstract class AbstractChargeOrderRequest implements ChargeOrderRequest {

	public AbstractChargeOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractChargeOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String currencyCode, float amount) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCurrencyCode(currencyCode);
		this.setAmount(amount);
	}

}
