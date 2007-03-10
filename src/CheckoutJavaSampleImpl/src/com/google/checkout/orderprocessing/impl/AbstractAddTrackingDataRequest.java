package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;

public abstract class AbstractAddTrackingDataRequest extends AbstractCheckoutRequest implements
		AddTrackingDataRequest {
	
	public AbstractAddTrackingDataRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
}
