package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractArchiveOrderRequest extends CheckoutRequestImpl implements
		ArchiveOrderRequest {
	
	private String googleOrderNo;

	public AbstractArchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
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

}
