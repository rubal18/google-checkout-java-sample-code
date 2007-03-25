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

package com.google.checkout;

/**
 * This class encapsulates the various merchant specific settings. An instance
 * of this class will be required by most of the other classes in order to
 * properly parameterise the API requests.
 * 
 * @author simonjsmith
 */
public interface MerchantConstants {

  /**
   * Return the Environment Type value.
   * 
   * @return The Environment Type.
   * 
   * @see EnvironmentType
   */
  public String getEnv();

  /**
   * Set the Environment Type value.
   * 
   * @param env The Environment Type.
   * 
   * @see EnvironmentType
   */
  public void setEnv(String env);

  /**
   * Return the Merchant Id.
   * 
   * @return The Merchant Id.
   */
  public String getMerchantId();

  /**
   * Set the Merchant Id.
   * 
   * @param merchantId
   *          The Merchant Id.
   */
  public void setMerchantId(String merchantId);

  /**
   * Return the Merchant Key.
   * 
   * @return The Merchant Key.
   */
  public String getMerchantKey();

  /**
   * Set the Merchant Key.
   * 
   * @param merchantKey
   *          The Merchant Key.
   */
  public void setMerchantKey(String merchantKey);

  /**
   * Return the Currency Code.
   * 
   * @return The Currency Code.
   */
  public String getCurrencyCode();

  /**
   * Set the Currency Code.
   * 
   * @param currencyCode
   *          The Currency Code.
   */
  public void setCurrencyCode(String currencyCode);

  /**
   * Return the Checkout URL.
   * 
   * @return The Checkout URL.
   */
  public String getCheckoutUrl();

  /**
   * Return the Request URL.
   * 
   * @return The Request URL.
   */
  public String getRequestUrl();

  /**
   * Return the HTTP Auth value.
   * 
   * @return The HTTP Auth value.
   */
  public String getHttpAuth();
  
  /**
   * Return the Merchant Checkout URL.
   * 
   * @return The Checkout URL.
   */
  public String getMerchantCheckoutUrl();

  /**
   * Set the Merchant Checkout URL.
   * 
   * @param merchantCheckoutUrl The Merchant Checkout URL.
   */  
  public void setMerchantCheckoutUrl(String merchantCheckoutUrl);

  /**
   * Set the Checkout URL.
   * 
   * @param checkoutUrl The Checkout URL.
   */  
  public void setCheckoutUrl(String checkoutUrl);

  /**
   * Set the Request URL.
   * 
   * @param requestUrl The Checkout URL.
   */ 
  public void setRequestUrl(String requestUrl);
}
