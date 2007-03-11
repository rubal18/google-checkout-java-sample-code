package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractChargeOrderRequest extends CheckoutRequestImpl implements ChargeOrderRequest {

	private String googleOrderNo;
	private float amount;
	
	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}

	public AbstractChargeOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, float amount) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setAmount(amount);
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

	public float getAmount()
	{
		return amount;
	}

	public void setAmount(float amt)
	{
		amount=amt;
		return;
	}
}
