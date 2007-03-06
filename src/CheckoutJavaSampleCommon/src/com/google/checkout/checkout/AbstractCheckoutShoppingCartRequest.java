package com.google.checkout.checkout;

import com.google.checkout.AbstractCheckoutRequest;

public abstract class AbstractCheckoutShoppingCartRequest extends
		AbstractCheckoutRequest implements CheckoutShoppingCartRequest {

	public AbstractCheckoutShoppingCartRequest(String merchantId,
			String merchantKey, String env, String currencyCode,
			int expirationMinutesFromNow) {
		
	}
}
