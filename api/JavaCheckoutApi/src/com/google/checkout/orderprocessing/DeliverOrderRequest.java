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
 * This class contains methods that construct &lt;deliver-order&gt; API
 * requests.
 */
public interface DeliverOrderRequest extends CheckoutRequest {

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
   * Return the carrier String, which is the value of the &lt;carrier&gt; tag.
   * 
   * @return The carrier String.
   */
  public String getCarrier();

  /**
   * Set the carrier String, which is the value of the &lt;carrier&gt; tag.
   * 
   * @param carrier
   *          The carrier String.
   */
  public void setCarrier(String carrier);

  /**
   * Return the tracking number, which is the value of the
   * &lt;tracking-number&gt; tag.
   * 
   * @return The tracking number.
   */
  public String getTrackingNo();

  /**
   * Set the tracking number, which is the value of the &lt;tracking-number&gt;
   * tag.
   * 
   * @param trackingNo
   *          The tracking number.
   */
  public void setTrackingNo(String trackingNo);

  /**
   * True if an email is to be sent to the buyer. This is the value of the
   * &lt;send-email&gt; tag.
   * 
   * @return The boolean value.
   */
  public boolean isSendEmail();

  /**
   * True if an email is to be sent to the buyer. This is the value of the
   * &lt;send-email&gt; tag.
   * 
   * @param sendEmail
   *          The boolean value.
   */
  public void setSendEmail(boolean sendEmail);
}
