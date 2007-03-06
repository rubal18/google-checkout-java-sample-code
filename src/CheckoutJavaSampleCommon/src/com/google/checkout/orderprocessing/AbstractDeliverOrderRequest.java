package com.google.checkout.orderprocessing;

public abstract class AbstractDeliverOrderRequest implements
		DeliverOrderRequest {

	public AbstractDeliverOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);

	}

	public AbstractDeliverOrderRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String carrier,
			String trackingNo, boolean sendEmail) {

		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
		this.setSendEmail(sendEmail);

	}

}
