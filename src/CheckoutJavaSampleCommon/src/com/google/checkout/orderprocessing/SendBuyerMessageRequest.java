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
 * This class contains methods that construct &lt;send-buyer-message&gt; API
 * requests.
 */
public interface SendBuyerMessageRequest extends CheckoutRequest {

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
   * Return the message which is to be sent to the buyer. This is the value of
   * the &lt;message&gt; tag.
   * 
   * @return The message.
   */
  public String getMessage();

  /**
   * Set the message which is to be sent to the customer. This is the value of
   * the &lt;message&gt; tag.
   * 
   * @param message
   *          The message.
   */
  public void setMessage(String message);

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
