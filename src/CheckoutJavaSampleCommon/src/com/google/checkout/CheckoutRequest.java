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
 * The parent for all Checkout requests.
 * 
 * @author simonjsmith@google.com
 */
public interface CheckoutRequest {

  /**
   * Return the URL to POST the request to.
   * 
   * @return The POST URL.
   */
  public String getPostUrl();

  /**
   * Return the XML request String.
   * 
   * @return The XML request String.
   */
  public String getXml();

  /**
   * Return the nicely formatted XML request String.
   * 
   * @return The nicely formatted XML request String.
   */
  public String getXmlPretty();

  /**
   * Submit the request to the POST URL and return a CheckoutResonse.
   * 
   * @return The CheckoutResponse object.
   * 
   * @see CheckoutResponse.
   */
  public CheckoutResponse send();
}
