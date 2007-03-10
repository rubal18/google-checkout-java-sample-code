package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;

public abstract class AbstractArchiveOrderRequest extends AbstractCheckoutRequest implements
		ArchiveOrderRequest {

	public AbstractArchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}

}
