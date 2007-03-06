package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;

public abstract class AbstractAddMerchantOrderNumberRequest implements
		AddMerchantOrderNumberRequest {

	public AbstractAddMerchantOrderNumberRequest(String merchantId, String merchantKey,
		      String env, String googleOrderNo, String merchantOrderNo) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMerchantOrderNo(merchantOrderNo);
	}
}
