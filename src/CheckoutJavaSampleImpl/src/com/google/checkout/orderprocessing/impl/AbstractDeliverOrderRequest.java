package com.google.checkout.orderprocessing.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.orderprocessing.DeliverOrderRequest;

public abstract class AbstractDeliverOrderRequest extends AbstractCheckoutRequest implements
		DeliverOrderRequest {

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);

	}

	public AbstractDeliverOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier,
			String trackingNo, boolean sendEmail) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
		this.setSendEmail(sendEmail);

	}

}
