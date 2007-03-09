package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractArchiveOrderRequest implements
		ArchiveOrderRequest {

	public AbstractArchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {
		
		this.setGoogleOrderNo(googleOrderNo);
	}

}
