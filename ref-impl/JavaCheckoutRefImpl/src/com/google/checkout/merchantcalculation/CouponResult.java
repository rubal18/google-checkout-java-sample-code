package com.google.checkout.merchantcalculation;

/**
 * This class encapsulates the &lt;coupon-result&gt; tag used as part of the Merchant Calculation API.
 * 
 * @author simonjsmith
 * 
 * @see MerchantCodeResult
 */
public class CouponResult extends MerchantCodeResult {

	/**
	 * A constructor which takes all the relevant parameters.
	 * 
	 * @param valid Whether the code is valid.
	 * @param calculatedAmount The discount amount.
	 * @param currency The currency.
	 * @param code The coupon code.
	 * @param message The message to display to the user.
	 */
	public CouponResult(boolean valid, float calculatedAmount, String currency, String code, String message) {
		this.setType("coupon-result");
		this.setValid(valid);
		this.setCalculatedAmount(calculatedAmount);
		this.setCurrency(currency);
		this.setCode(code);
		this.setMessage(message);		
	}

}
