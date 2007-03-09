package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;

public abstract class AbstractDeliverOrderRequest implements
		DeliverOrderRequest {

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		this.setGoogleOrderNo(googleOrderNo);

	}

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier,
			String trackingNo, boolean sendEmail) {

		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
		this.setSendEmail(sendEmail);

	}

}
