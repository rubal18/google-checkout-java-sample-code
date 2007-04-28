package com.google.checkout.merchantcalculation;

/**
 * This class encapsulates the &lt;gift-certificate-result&gt; tag used as part of the Merchant Calculation API.
 * 
 * @author simonjsmith
 * 
 * @see MerchantCodeResult
 */
public class GiftCertificateResult extends MerchantCodeResult {

	/**
	 * A constructor which takes all the relevant parameters.
	 * 
	 * @param valid Whether the code is valid.
	 * @param calculatedAmount The discount amount.
	 * @param currency The currency.
	 * @param code The gift certificate code.
	 * @param message The message to display to the user.
	 */
	private GiftCertificateResult(boolean valid, float calculatedAmount, float currency, String code, String message) {
		this.setType("gift-certificate-result");
		this.setValid(valid);
		this.setCalculatedAmount(calculatedAmount);
		this.setCurrency(currency);
		this.setCode(code);
		this.setMessage(message);		
	}
	
}
