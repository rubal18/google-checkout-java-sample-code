/*************************************************
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*************************************************/

package com.google.checkout;

public interface CheckoutRequest {
	
	public String getPostUrl();	 
	public String getXml();
	public CheckoutResponse send();	

	public String getEnv();
	public void setEnv(String env);
	
	public String getMerchantId();
	public void setMerchantId(String merchantId);

	public String getMerchantKey();
	public void setMerchantKey(String merchantKey);
	
	public String getCurrencyCode();
	public void setCurrencyCode(String currencyCode);
}
