package com.google.checkout;

public interface MerchantConstants {
	public String getEnv();
	public void setEnv(String env);
	
	public String getMerchantId();
	public void setMerchantId(String merchantId);

	public String getMerchantKey();
	public void setMerchantKey(String merchantKey);
	
	public String getCurrencyCode();
	public void setCurrencyCode(String currencyCode);
	
	public String getCheckoutUrl();
	public String getRequestUrl();

    public String getHttpAuth();
}
