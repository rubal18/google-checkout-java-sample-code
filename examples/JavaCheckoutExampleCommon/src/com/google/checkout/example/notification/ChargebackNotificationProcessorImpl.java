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

package com.google.checkout.example.notification;

import java.util.Date;

import org.w3c.dom.Document;

import com.google.checkout.CheckoutException;
import com.google.checkout.MerchantConstants;
import com.google.checkout.example.GoogleOrder;
import com.google.checkout.notification.ChargebackNotificationProcessor;
import com.google.checkout.util.Utils;

public class ChargebackNotificationProcessorImpl extends AbstractNotificationProcessor
    implements ChargebackNotificationProcessor {
  
  private MerchantConstants merchantConstants;
  
  public ChargebackNotificationProcessorImpl(MerchantConstants merchantConstants) {
    this.merchantConstants = merchantConstants;
  }
  
  public String process(String callbackXML) throws CheckoutException {
    
    String ack = "";
    try {
      Document document = Utils.newDocumentFromString(callbackXML);
      
      String orderNumber = Utils.getElementStringValue(document, document.getDocumentElement(), "google-order-number");
      Date timestamp = Utils.getElementDateValue(document, document.getDocumentElement(), "timestamp");
      
      GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants.getMerchantId(), orderNumber);
      ack = getAckString();
      
      order.addIncomingMessage(timestamp, document.getDocumentElement().getNodeName(), Utils.documentToStringPretty(document), ack);
    } catch (Exception e) {
      throw new CheckoutException(e);
    }
    return ack;
  }
}
