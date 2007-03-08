package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;

public abstract class AbstractAddMerchantOrderNumberRequest 
		extends AbstractCheckoutRequest implements
		AddMerchantOrderNumberRequest {
	
	private String googleOrderNo;
	private String merchantOrderNo;

	public AbstractAddMerchantOrderNumberRequest(String merchantId, String merchantKey,
		      String env, String googleOrderNo, String merchantOrderNo) {
		
		this.setMerchantId(merchantId);
		this.setMerchantKey(merchantKey);
		this.setEnv(env);
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
