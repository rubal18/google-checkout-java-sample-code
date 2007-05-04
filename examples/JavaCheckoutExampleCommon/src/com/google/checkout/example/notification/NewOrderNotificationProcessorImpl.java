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

import com.google.checkout.CheckoutException;
import com.google.checkout.MerchantConstants;
import com.google.checkout.example.GoogleOrder;
import com.google.checkout.notification.ChargeAmountNotificationProcessor;
import com.google.checkout.notification.NewOrderNotification;
import com.google.checkout.notification.NewOrderNotificationProcessor;

/**
 * An example implementation of the NewOrderNotificationProcessor
 * interface.
 * 
 * @author simonjsmith
 * 
 * @see NewOrderNotificationProcessor
 */
public class NewOrderNotificationProcessorImpl extends
		AbstractNotificationProcessor implements NewOrderNotificationProcessor {

	private MerchantConstants merchantConstants;

	/**
	 * Constructor which takes an instance of MerchantConstants.
	 * 
	 * @param merchantConstants
	 *            The MerchantConstants.
	 * 
	 * @see MerchantConstants
	 */
	public NewOrderNotificationProcessorImpl(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.checkout.notification.NewOrderNotificationProcessor#process(com.google.checkout.notification.NewOrderNotification)
	 */
	public String process(NewOrderNotification notification)
			throws CheckoutException {
		try {
			String ack = getAckString();
			GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants
					.getMerchantId(), notification.getGoogleOrderNo());
			
			order.setLastFulStatus(notification.getFulfillmentOrderState()
					.toString());
			order.setLastFinStatus(notification.getFinancialOrderState()
					.toString());
			order.setBuyerEmail(notification.getBuyerBillingAddress()
					.getEmail());
			order.setOrderAmount("" + notification.getOrderTotal());
			order.addIncomingMessage(notification.getTimestamp(), notification
					.getRootNodeName(), notification.getXmlPretty(), ack);
			return ack;
		} catch (Exception e) {
			throw new CheckoutException(e);
		}
	}
}
