package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractDeliverOrderRequest extends CheckoutRequestImpl implements
		DeliverOrderRequest {
	
	private String googleOrderNo;
	private String carrier;
	private String trackingNo; 
	private boolean sendEmail;

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);

	}

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier,
			String trackingNo, boolean sendEmail) {
		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
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

	public String getCarrier()
	{
		return carrier;
	}

	public void setCarrier(String carr)
	{
		carrier=carr;
		return;
	}
	
	public String getTrackingNo()
	{
		return trackingNo;
	}

	public void setTrackingNo(String tNo)
	{
		trackingNo=tNo;
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
