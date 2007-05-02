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
import com.google.checkout.notification.AuthorizationAmountNotification;
import com.google.checkout.notification.AuthorizationAmountNotificationProcessor;
import com.google.checkout.util.Utils;

/**
 * TODO
 * 
 * @author simonjsmith
 * 
 */
public class AuthorizationAmountNotificationProcessorImpl extends
		AbstractNotificationProcessor implements
		AuthorizationAmountNotificationProcessor {

	private MerchantConstants merchantConstants;

	/**
	 * TODO
	 * 
	 * @param merchantConstants
	 */
	public AuthorizationAmountNotificationProcessorImpl(
			MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.checkout.notification.AuthorizationAmountNotificationProcessor#process(com.google.checkout.notification.AuthorizationAmountNotification)
	 */
	public String process(AuthorizationAmountNotification notification)
			throws CheckoutException {
		try {
			String ack = getAckString();
			GoogleOrder order = GoogleOrder.findOrCreate(merchantConstants
					.getMerchantId(), notification.getGoogleOrderNo());
			order.addIncomingMessage(notification.getTimestamp(), notification
					.getRootNodeName(), notification.getXmlPretty(), ack);
			return ack;
		} catch (Exception e) {
			throw new CheckoutException(e);
		}
	}
}
