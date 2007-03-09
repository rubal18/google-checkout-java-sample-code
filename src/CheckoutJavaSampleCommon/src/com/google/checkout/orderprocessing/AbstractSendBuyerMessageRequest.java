package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractSendBuyerMessageRequest extends AbstractCheckoutRequest implements
		SendBuyerMessageRequest {

	public AbstractSendBuyerMessageRequest(MerchantConstants merchantConstants, String googleOrderNo, String message) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setMessage(message);
	}

		public AbstractSendBuyerMessageRequest(MerchantConstants merchantConstants, String googleOrderNo, String message, boolean sendEmail) {
 
			super(merchantConstants);
			this.setGoogleOrderNo(googleOrderNo);
			this.setMessage(message);
			this.setSendEmail(sendEmail);
			
		}

}
