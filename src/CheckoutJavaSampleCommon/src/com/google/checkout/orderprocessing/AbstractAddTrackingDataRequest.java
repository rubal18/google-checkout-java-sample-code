package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractAddTrackingDataRequest implements
		AddTrackingDataRequest {
	
	public AbstractAddTrackingDataRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
}
