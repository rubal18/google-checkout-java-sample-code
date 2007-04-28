package com.google.checkout.merchantcalculation;

/**
 * This class encapsulates the &lt;merchant-code-results&gt; tag used as part of the Merchant Calculation API.
 * 
 * @author simonjsmith
 *
 */
public abstract class MerchantCodeResult {

	private String type;
	private boolean valid;
	private float calculatedAmount;
	private float currency;
	private String code;
	private String message;
	
	/**
	 * Retrieves the value of the &lt;calculated-amount&gt; tag.
	 * 
	 * @return The value of the discount.
	 */
	public float getCalculatedAmount() {
		return calculatedAmount;
	}
	
	/**
	 * Sets the value of the &lt;calculated-amount&gt; tag.
	 * 
	 * @param calculatedAmount The value of the discount.
	 */
	public void setCalculatedAmount(float calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	
	/**
	 * Retrieves the value of the &lt;code&gt; tag.
	 * 
	 * @return The code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the value of the &lt;code&gt; tag.
	 * 
	 * @param code The code.
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Retrieves the value of the currency attribute of the &lt;calculated-amount&gt; tag.
	 * 
	 * @return The currency code.
	 */
	public float getCurrency() {
		return currency;
	}
	
	/**
	 * Sets the value of the currency attribute of the &lt;calculated-amount&gt; tag.
	 * 
	 * @param currency The currency code.
	 */
	public void setCurrency(float currency) {
		this.currency = currency;
	}
	
	/**
	 * Retrieves the value of the &lt;message&gt; tag.
	 * 
	 * @return The message to be shown to the user.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Sets the value of the &lt;message&gt; tag.
	 * 
	 * @param message The message to be shown to the user.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Retrieves the type of the result.
	 * 
	 * @return The type of the result.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type of the result.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Retrieves the value of the &lt;valid&gt; tag.
	 * 
	 * @return The valid flag.
	 */
	public boolean isValid() {
		return valid;
	}
	
	/**
	 * Sets the value of the &lt;valid&gt; tag.
	 * 
	 * @param valid The valid flag.
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
