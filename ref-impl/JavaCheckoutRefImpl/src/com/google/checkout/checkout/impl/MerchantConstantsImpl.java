/*******************************************************************************
 * Copyright (C) 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.google.checkout.checkout.impl;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Base64Coder;

/**
 * Default implementation of the MerchantConstants interface.
 * 
 * @author simonjsmith
 */
public class MerchantConstantsImpl implements MerchantConstants {
	
	private String merchantId;
	private String merchantKey;
	private String env;
	private String currencyCode;
  private String checkoutUrl;
  private String merchantCheckoutUrl;
  private String requestUrl;

  /**
   * The constructor.
   * 
   * @param merchantId The Merchant Id.
   * @param merchantKey The Merchant Key.
   * @param env The Environment Type.
   * @param currencyCode The Currency Code.
   * @param checkoutUrl The Checkout Url
   * @param merchantCheckoutUrl The Merchant Checkout Url
   * @param requestUrl The Request Url
   */
	public MerchantConstantsImpl(String merchantId, String merchantKey, String env, String currencyCode, String checkoutUrl, String merchantCheckoutUrl, String requestUrl) {
		this.merchantId = merchantId;
		this.merchantKey = merchantKey;
		this.env = env;
		this.currencyCode = currencyCode;
    this.checkoutUrl = checkoutUrl;
    this.merchantCheckoutUrl = merchantCheckoutUrl;
    this.requestUrl = requestUrl;
	}
	
	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getCurrencyCode()
	 */
	public String getCurrencyCode() {
		return this.currencyCode;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getEnv()
	 */
	public String getEnv() {
		return this.env;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getMerchantId()
	 */
	public String getMerchantId() {
		return this.merchantId;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getMerchantKey()
	 */
	public String getMerchantKey() {
		return this.merchantKey;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#setCurrencyCode(java.lang.String)
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#setEnv(java.lang.String)
	 */
	public void setEnv(String env) {
		this.env = env;

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#setMerchantId(java.lang.String)
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#setMerchantKey(java.lang.String)
	 */
	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getCheckoutUrl()
	 */
	public String getCheckoutUrl() {
		return checkoutUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getRequestUrl()
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.MerchantConstants#getHttpAuth()
	 */
	public String getHttpAuth() {
	  return Base64Coder.encode(new StringBuffer(getMerchantId()).append(":").append(getMerchantKey()).toString());
	}

  /* (non-Javadoc)
   * @see com.google.checkout.MerchantConstants#getMerchantCheckoutUrl()
   */
  public String getMerchantCheckoutUrl() {
    return merchantCheckoutUrl;
  }

  /* (non-Javadoc)
   * @see com.google.checkout.MerchantConstants#setMerchantCheckoutUrl(java.lang.String)
   */
  public void setMerchantCheckoutUrl(String merchantCheckoutUrl) {
    this.merchantCheckoutUrl = merchantCheckoutUrl;
  }

  /* (non-Javadoc)
   * @see com.google.checkout.MerchantConstants#setCheckoutUrl(java.lang.String)
   */
  public void setCheckoutUrl(String checkoutUrl) {
    this.checkoutUrl = checkoutUrl;
  }

  /* (non-Javadoc)
   * @see com.google.checkout.MerchantConstants#setRequestUrl(java.lang.String)
   */
  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

}
