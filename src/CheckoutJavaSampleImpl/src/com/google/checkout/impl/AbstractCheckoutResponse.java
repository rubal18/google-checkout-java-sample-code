package com.google.checkout.impl;

import com.google.checkout.CheckoutResponse;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1
 * @todo		Not unit tested yet.
 *
 */

public abstract class AbstractCheckoutResponse implements CheckoutResponse {
	
	public AbstractCheckoutResponse() {
		processResponse("");
	}

	public AbstractCheckoutResponse(String response) {
		processResponse(response);
	}

	protected abstract void processResponse(String response);
}
