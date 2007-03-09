package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractArchiveOrderRequest extends AbstractCheckoutRequest implements
		ArchiveOrderRequest {

	public AbstractArchiveOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
	}

}
