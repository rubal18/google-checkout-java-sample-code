package com.google.checkout.orderprocessing;

public abstract class AbstractAddTrackingDataRequest implements
		AddTrackingDataRequest {
	
	public AbstractAddTrackingDataRequest(String merchantId, String merchantKey, 
		      String env, String googleOrderNo, String carrier, String trackingNo) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
}
