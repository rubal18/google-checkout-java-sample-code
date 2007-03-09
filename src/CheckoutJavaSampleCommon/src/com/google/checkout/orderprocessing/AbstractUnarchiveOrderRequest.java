package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractUnarchiveOrderRequest extends AbstractCheckoutRequest implements
		UnarchiveOrderRequest {

	public AbstractUnarchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		super(merchantConstants);		
		this.setGoogleOrderNo(googleOrderNo);

	}

}
