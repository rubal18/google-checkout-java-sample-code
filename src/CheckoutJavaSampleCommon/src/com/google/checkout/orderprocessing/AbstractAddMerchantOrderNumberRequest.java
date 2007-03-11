package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1 - ksim - March 6th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractAddMerchantOrderNumberRequest 
		extends CheckoutRequestImpl implements
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
