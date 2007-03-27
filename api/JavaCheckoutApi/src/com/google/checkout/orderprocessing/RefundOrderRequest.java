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

package com.google.checkout.orderprocessing;

import com.google.checkout.CheckoutRequest;

/**
 * This class contains methods that construct &lt;refund-order&gt; API requests.
 */
public interface RefundOrderRequest extends CheckoutRequest {

  /**
   * Return the Google Order Number, which is the value of the
   * google-order-number attribute on the root tag.
   * 
   * @return The Google Order Number.
   */
  public String getGoogleOrderNo();

  /**
   * Set the Google Order Number, which is the value of the google-order-number
   * attribute on the root tag.
   * 
   * @param googleOrderNo
   *          The Google Order Number.
   */
  public void setGoogleOrderNo(String googleOrderNo);

  /**
   * Return the refund amount, which is value of the &lt;amount&gt; tag.
   * 
   * @return The refund amount.
   */
  public float getAmount();

  /**
   * Set the refund amount, which is value of the &lt;amount&gt; tag.
   * 
   * @param amount
   *          The refund amount.
   */
  public void setAmount(float amount);

  /**
   * Return the refund reason String, which is the value of the &lt;reason&gt;
   * tag.
   * 
   * @return The refund reason String.
   */
  public String getReason();

  /**
   * Set the refund reason String, which is the value of the &lt;reason&gt; tag.
   * 
   * @param reason
   *          The refund reason String.
   */
  public void setReason(String reason);

  /**
   * Return the refund comment String, which is the value of the &lt;comment&gt;
   * tag.
   * 
   * @return The refund comment String.
   */
  public String getComment();

  /**
   * Set the refund comment String, which is the value of the &lt;comment&gt;
   * tag.
   * 
   * @param comment
   *          The refund comment String.
   */
  public void setComment(String comment);

}
