package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractSendBuyerMessageRequest extends CheckoutRequestImpl implements
		SendBuyerMessageRequest {
	
	private String googleOrderNo; 
	private String message;
	private boolean sendEmail;

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
		
		public String getGoogleOrderNo()
		{
			return googleOrderNo;
		}

		public void setGoogleOrderNo(String gOrderNo)
		{
			googleOrderNo=gOrderNo;
			return;
		}

		public String getMessage()
		{
			return message;
		}

		public void setMessage(String msg)
		{
			message=msg;
			return;
		}
		
		public boolean isSendEmail()
		{
			return sendEmail;
		}

		public void setSendEmail(boolean sEmail)
		{
			sendEmail=sEmail;
			return;
		}

}
