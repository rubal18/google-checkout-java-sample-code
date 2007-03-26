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

package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;

/**
 * The default implementation of the AddTrackingDataRequest interface.
 * 
 * @author ksim
 * @version 1.0 - ksim - March 10th, 2007 - Initial Version
 */
public class AddTrackingDataRequestImpl extends AbstractCheckoutRequest
    implements AddTrackingDataRequest {

  private Document document;

  private Element root;

  /**
   * Constructor which takes an instance of MerchantConstants.
   * 
   * @param merchantConstants
   *          The MerchantConstants.
   * 
   * @see MerchantConstants
   */
  public AddTrackingDataRequestImpl(MerchantConstants merchantConstants) {
    super(merchantConstants);

    document = Utils.newEmptyDocument();
    root = (Element) document.createElementNS(Constants.checkoutNamespace,
        "add-tracking-data");
    root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns",
        Constants.checkoutNamespace);
    document.appendChild(root);
  }

  /**
   * Constructor which takes an instance of MerchantConstants, the Google Order
   * Number, the Carrier and the Tracking Number
   * 
   * @param merchantConstants
   *          The MerchantConstants.
   * @param googleOrderNo
   *          The Google Order Number.
   * @param carrier
   *          The Carrier.
   * @param trackingNo
   *          The Tracking Number.
   * 
   * @see MerchantConstants
   */
  public AddTrackingDataRequestImpl(MerchantConstants merchantConstants,
      String googleOrderNo, String carrier, String trackingNo) {
    this(merchantConstants);
    this.setGoogleOrderNo(googleOrderNo);
    this.setCarrier(carrier);
    this.setTrackingNo(trackingNo);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.CheckoutRequest#getXml()
   */
  public String getXml() {
    return Utils.documentToString(document);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.CheckoutRequest#getXmlPretty()
   */
  public String getXmlPretty() {
    return Utils.documentToStringPretty(document);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.CheckoutRequest#getPostUrl()
   */
  public String getPostUrl() {
    return "https://sandbox.google.com/checkout/cws/v2/Merchant/"
        + merchantConstants.getMerchantId() + "/request";
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#getCarrier()
   */
  public String getCarrier() {
    Element trackingDataTag = Utils.findContainerElseCreate(document, root,
        "tracking-data");
    return Utils.getElementStringValue(document, trackingDataTag, "carrier");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#getGoogleOrderNo()
   */
  public String getGoogleOrderNo() {
    return Utils.getElementStringValue(document, root, "google-order-number");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#getTrackingNo()
   */
  public String getTrackingNo() {
    Element trackingDataTag = Utils.findContainerElseCreate(document, root,
        "tracking-data");
    return Utils.getElementStringValue(document, trackingDataTag,
        "tracking-number");
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#setCarrier(java.lang.String)
   */
  public void setCarrier(String carrier) {
    Element trackingDataTag = Utils.findContainerElseCreate(document, root,
        "tracking-data");
    Utils.findElementAndSetElseCreateAndSet(document, trackingDataTag,
        "carrier", carrier);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#setGoogleOrderNo(java.lang.String)
   */
  public void setGoogleOrderNo(String googleOrderNo) {
    root.setAttribute("google-order-number", googleOrderNo);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.orderprocessing.AddTrackingDataRequest#setTrackingNo(java.lang.String)
   */
  public void setTrackingNo(String trackingNo) {
    Element trackingDataTag = Utils.findContainerElseCreate(document, root,
        "tracking-data");
    Utils.findElementAndSetElseCreateAndSet(document, trackingDataTag,
        "tracking-number", trackingNo);
  }
}
