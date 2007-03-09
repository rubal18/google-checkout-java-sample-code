package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractSendBuyerMessageRequest implements
		SendBuyerMessageRequest {

	public AbstractSendBuyerMessageRequest(MerchantConstants merchantConstants, String googleOrderNo, String message) {
		
		this.setGoogleOrderNo(googleOrderNo);
		this.setMessage(message);
	}

		public AbstractSendBuyerMessageRequest(String merchantId, String merchantKey,
				String env, String googleOrderNo, String message, boolean sendEmail) {
 
			this.setGoogleOrderNo(googleOrderNo);
			this.setMessage(message);
			this.setSendEmail(sendEmail);
			
		}

}
