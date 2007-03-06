package com.google.checkout;

public abstract class AbstractCheckoutResponse implements CheckoutResponse {

	public AbstractCheckoutResponse(String response) {
		processResponse(response);
	}

	protected abstract void processResponse(String response);
}
