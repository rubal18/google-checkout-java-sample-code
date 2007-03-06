package com.google.checkout.orderprocessing;

public abstract class AbstractSendBuyerMessageRequest implements
		SendBuyerMessageRequest {

	public AbstractSendBuyerMessageRequest(String merchantId, String merchantKey,
			String env, String googleOrderNo, String message) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMessage(message);
	}

		public AbstractSendBuyerMessageRequest(String merchantId, String merchantKey,
				String env, String googleOrderNo, String message, boolean sendEmail) {
			
			this.setMerchantId(merchantId);
			this.setMerchantKey(merchantKey);
			this.setEnv(env);
			this.setGoogleOrderNo(googleOrderNo);
			this.setMessage(message);
			this.setSendEmail(sendEmail);
			
		}

}
