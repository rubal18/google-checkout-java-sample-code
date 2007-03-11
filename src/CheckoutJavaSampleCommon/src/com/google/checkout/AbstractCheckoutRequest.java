package com.google.checkout;



import com.google.checkout.AbstractCheckoutRequest;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1 - ksim - March 6th, 2007 - Added in initial send and getPostUrl methods
 * @version		1.2 - ksim - March 10th, 2007 - To maintain the interface, abstracted out send and getPostUrl methods to impl
 * 
 */

public abstract class AbstractCheckoutRequest implements CheckoutRequest {

	private MerchantConstants merchantConstants; 
	
	public AbstractCheckoutRequest(MerchantConstants mConstants) {
		merchantConstants = mConstants;
		merchantConstants.setEnv(EnvironmentType.Sandbox);
	}

    protected abstract String getAuthorization(String user, String password);
    
    /** <summary>Send the Message to Google Checkout</summary> */
    public abstract CheckoutResponse send();

    /** <summary> Get the post URL to output </summary> */
    public abstract String getPostUrl();
    
	public String getCurrencyCode() {
      return merchantConstants.getCurrencyCode();
	}

	public String getEnv() {
		return merchantConstants.getEnv();
	}

	public String getMerchantId() {
		return merchantConstants.getMerchantId();
	}

	public String getMerchantKey() {
      return merchantConstants.getMerchantKey();
	}

	public void setCurrencyCode(String currencyCode) {
      merchantConstants.setCurrencyCode(currencyCode);
	}

	public void setEnv(String env) {
		merchantConstants.setEnv(env);
	}

	public void setMerchantId(String merchantId) {
		merchantConstants.setMerchantId(merchantId);
	}

	public void setMerchantKey(String merchantKey) {
		merchantConstants.setMerchantKey(merchantKey);
	}
}
