package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;

public abstract class AbstractAddMerchantOrderNumberRequest 
		extends AbstractCheckoutRequest implements
		AddMerchantOrderNumberRequest {
	
	private String googleOrderNo;
	private String merchantOrderNo;

	public AbstractAddMerchantOrderNumberRequest(MerchantConstants merchantConstants, String googleOrderNo, String merchantOrderNo) {
		
		super(merchantConstants);
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
