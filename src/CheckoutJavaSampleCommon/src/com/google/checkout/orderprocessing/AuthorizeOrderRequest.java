package com.google.checkout.orderprocessing;

import com.google.checkout.CheckoutRequest;

/**
 * This class contains methods that construct &lt;authorize-order&gt; API
 * requests.
 */
public interface AuthorizeOrderRequest extends CheckoutRequest {

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
}
