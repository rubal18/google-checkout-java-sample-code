package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractAddMerchantOrderNumberRequest 
		extends AbstractCheckoutRequest implements
		AddMerchantOrderNumberRequest {
	
	private String googleOrderNo;
	private String merchantOrderNo;

	public AbstractAddMerchantOrderNumberRequest(MerchantConstants merchantConstants, String googleOrderNo, String merchantOrderNo) {
		
		this.setGoogleOrderNo(googleOrderNo);
		this.setMerchantOrderNo(merchantOrderNo);
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

	public String getMerchantOrderNo()
	{
		return merchantOrderNo;
	}

	public void setMerchantOrderNo(String mOrderNo)
	{
		merchantOrderNo=mOrderNo;
		return;
	}

}
