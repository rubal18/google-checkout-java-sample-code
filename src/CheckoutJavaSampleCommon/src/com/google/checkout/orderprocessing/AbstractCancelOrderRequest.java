package com.google.checkout.orderprocessing;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.CheckoutRequestImpl;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 10th, 2007
 * @version		1.1 - ksim - March 10th, 2007 - Added in variables and getters and setters
 *
 */

public abstract class AbstractCancelOrderRequest extends CheckoutRequestImpl implements CancelOrderRequest {

	private String googleOrderNo;
	private String reason; 
	private String comment;
	
	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
	}

	public AbstractCancelOrderRequest(MerchantConstants merchantConstants, String googleOrderNo, String reason, String comment) {

		super(merchantConstants);
		this.setGoogleOrderNo(googleOrderNo);
		this.setReason(reason);
		this.setComment(comment);

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

	public String getReason()
	{
		return reason;
	}

	public void setReason(String rsn)
	{
		reason=rsn;
		return;
	}
	
	public String getComment()
	{
		return comment;
	}

	public void setComment(String cmt)
	{
		comment=cmt;
		return;
	}
}
