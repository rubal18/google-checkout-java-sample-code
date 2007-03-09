package com.google.checkout.orderprocessing;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.MerchantConstants;

public abstract class AbstractAddTrackingDataRequest extends AbstractCheckoutRequest implements
		AddTrackingDataRequest {
	
	public AbstractAddTrackingDataRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
}
