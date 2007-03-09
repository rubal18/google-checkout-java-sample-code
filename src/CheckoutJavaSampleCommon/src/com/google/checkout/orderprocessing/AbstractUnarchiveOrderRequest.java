package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractUnarchiveOrderRequest implements
		UnarchiveOrderRequest {

	public AbstractUnarchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		this.setGoogleOrderNo(googleOrderNo);

	}

}
