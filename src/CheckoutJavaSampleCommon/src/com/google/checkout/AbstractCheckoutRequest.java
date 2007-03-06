package com.google.checkout;

public abstract class AbstractCheckoutRequest implements CheckoutRequest {

	private String merchantId;
	private String merchantKey;
	private String env;
	private String currencyCode;

	public String getCurrencyCode() {
      return currencyCode;
	}

	public String getEnv() {
		return env;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getMerchantKey() {
      return merchantKey;
	}

	public CheckoutResponse send() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
	}

	public void setEnv(String env) {
      this.env = env;
	}

	public void setMerchantId(String merchantId) {
      this.merchantId = merchantId;
	}

	public void setMerchantKey(String merchantKey) {
      this.merchantKey = merchantKey;
	}
}
