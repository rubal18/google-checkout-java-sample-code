package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;

public abstract class AbstractUnarchiveOrderRequest extends AbstractCheckoutRequest implements
		UnarchiveOrderRequest {

	public AbstractUnarchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		super(merchantConstants);		
		this.setGoogleOrderNo(googleOrderNo);

	}

}
