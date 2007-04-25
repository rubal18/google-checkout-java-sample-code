/*************************************************
 * Copyright (C) 2006 Google Inc.
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
package com.google.checkout.j2eeexample;

import javax.jms.TextMessage;

import com.google.checkout.example.CheckoutRequestFactory;
import com.google.checkout.notification.AuthorizationNotificationProcessor;
import com.google.checkout.notification.ChargeNotificationProcessor;
import com.google.checkout.notification.ChargebackNotificationProcessor;
import com.google.checkout.notification.NewOrderNotificationProcessor;
import com.google.checkout.notification.OrderStateChangeNotificationProcessor;
import com.google.checkout.notification.RefundNotificationProcessor;
import com.google.checkout.notification.RiskInformationNotificationProcessor;

/**
 * The Class JmsCallBackProcessorMdb.
 */
public class NotificationEjb implements javax.ejb.MessageDrivenBean,
    javax.jms.MessageListener {
  
  private javax.ejb.MessageDrivenContext messageContext = null;
  
  /* (non-Javadoc)
   * @see javax.ejb.MessageDrivenBean#setMessageDrivenContext(javax.ejb.MessageDrivenContext)
   */
  public void setMessageDrivenContext(
      javax.ejb.MessageDrivenContext messageContext)
      throws javax.ejb.EJBException {
    this.messageContext = messageContext;
  }
  
  /* (non-Javadoc)
   * @see javax.ejb.MessageDrivenBean#ejbCreate()
   */
  public void ejbCreate() {
    messageContext = null;
  }
  
  /* (non-Javadoc)
   * @see javax.ejb.MessageDrivenBean#ejbRemove()
   */
  public void ejbRemove() {
    messageContext = null;
  }
  
  /* (non-Javadoc)
   * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
   */
  public void onMessage(javax.jms.Message message) {
    try {
      String contents = ((TextMessage)message).getText();
      dispatch(contents);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private String dispatch(String notification) throws Exception {
    
    if (notification.indexOf("new-order-notification") > -1) {
      NewOrderNotificationProcessor processor = CheckoutRequestFactory.newNewOrderNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("risk-information-notification") > -1) {
      RiskInformationNotificationProcessor processor = CheckoutRequestFactory.newRiskInformationNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("order-state-change-notification") > -1) {
      OrderStateChangeNotificationProcessor processor = CheckoutRequestFactory.newOrderStateChangeNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("charge-amount-notification") > -1) {
      ChargeNotificationProcessor processor = CheckoutRequestFactory.newChargeNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("refund-amount-notification") > -1) {
      RefundNotificationProcessor processor = CheckoutRequestFactory.newRefundNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("chargeback-amount-notification") > -1) {
      ChargebackNotificationProcessor processor = CheckoutRequestFactory.newChargeBackNotificationProcessor();
      return processor.process(notification);
    }
    if (notification.indexOf("authorization-amount-notification") > -1) {
      AuthorizationNotificationProcessor processor = CheckoutRequestFactory.newAuthorizationNotificationProcessor();
      return processor.process(notification);
    }
    throw new Exception("Notification not recoginsed.");
  }
}
