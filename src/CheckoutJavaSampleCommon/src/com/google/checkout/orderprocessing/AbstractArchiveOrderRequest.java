package com.google.checkout.orderprocessing;

public abstract class AbstractArchiveOrderRequest implements
		ArchiveOrderRequest {

	public AbstractArchiveOrderRequest(String merchantId, String merchantKey, 
		      String env, String googleOrderNo) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
	}

}
