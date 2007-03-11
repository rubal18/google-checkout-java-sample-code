package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractAddTrackingDataRequest extends CheckoutRequestImpl implements
		AddTrackingDataRequest {
	
	private String googleOrderNo;
	private String carrier;
	private String trackingNo;
	
	public AbstractAddTrackingDataRequest(MerchantConstants merchantConstants, String googleOrderNo, String carrier, String trackingNo) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setCarrier(carrier);
		this.setTrackingNo(trackingNo);
	}
	
	public String getGoogleOrderNo()
	{
		return googleOrderNo;
	}

	public void setGoogleOrderNo(String gOrderNo)
	{
		googleOrderNo=gOrderNo;
		return;
	}

	public String getCarrier()
	{
		return carrier;
	}

	public void setCarrier(String carr)
	{
		carrier=carr;
		return;
	}
	
	public String getTrackingNo()
	{
		return trackingNo;
	}

	public void setTrackingNo(String tNo)
	{
		trackingNo=tNo;
		return;
	}
}
