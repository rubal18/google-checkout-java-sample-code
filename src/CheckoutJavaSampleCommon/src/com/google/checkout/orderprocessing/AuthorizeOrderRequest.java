package com.google.checkout.orderprocessing;

import com.google.checkout.CheckoutRequest;

public interface AuthorizeOrderRequest extends CheckoutRequest {

	public String getGoogleOrderNo();

	public void setGoogleOrderNo(String googleOrderNo);
}
