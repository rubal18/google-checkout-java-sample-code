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
package com.google.checkout.webappexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.checkout.MerchantConstants;
import com.google.checkout.example.MerchantConstantsFactory;
import com.google.checkout.example.notification.AuthorizationAmountNotificationProcessorImpl;
import com.google.checkout.example.notification.ChargeAmountNotificationProcessorImpl;
import com.google.checkout.example.notification.ChargebackAmountNotificationProcessorImpl;
import com.google.checkout.example.notification.NewOrderNotificationProcessorImpl;
import com.google.checkout.example.notification.OrderStateChangeNotificationProcessorImpl;
import com.google.checkout.example.notification.RefundNotificationProcessorImpl;
import com.google.checkout.example.notification.RiskInformationNotificationProcessorImpl;
import com.google.checkout.notification.AuthorizationAmountNotification;
import com.google.checkout.notification.AuthorizationAmountNotificationProcessor;
import com.google.checkout.notification.ChargeAmountNotification;
import com.google.checkout.notification.ChargeAmountNotificationProcessor;
import com.google.checkout.notification.ChargebackAmountNotification;
import com.google.checkout.notification.ChargebackAmountNotificationProcessor;
import com.google.checkout.notification.NewOrderNotification;
import com.google.checkout.notification.NewOrderNotificationProcessor;
import com.google.checkout.notification.OrderStateChangeNotification;
import com.google.checkout.notification.OrderStateChangeNotificationProcessor;
import com.google.checkout.notification.RefundAmountNotification;
import com.google.checkout.notification.RefundAmountNotificationProcessor;
import com.google.checkout.notification.RiskInformationNotification;
import com.google.checkout.notification.RiskInformationNotificationProcessor;

/**
 * TODO
 */
public class NotificationServlet extends javax.servlet.http.HttpServlet {

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MerchantConstants mc = MerchantConstantsFactory.getMerchantConstants();

		try {
			String auth = request.getHeader("Authorization");
			if (auth == null || !auth.equals("Basic " + mc.getHttpAuth())) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						"Authentication Failed.");
				return;
			}

			String notification = getNotificationBody(request.getInputStream());
			String ret = dispatch(notification);

			PrintWriter out = response.getWriter();
			out.print(ret);

		} catch (Exception ex) {
			ex.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex
					.getMessage());
		}
	}

	private String dispatch(String notificationString) throws Exception {

		MerchantConstants mc = MerchantConstantsFactory.getMerchantConstants();

		if (notificationString.indexOf("new-order-notification") > -1) {
			NewOrderNotificationProcessor processor = new NewOrderNotificationProcessorImpl(
					mc);
			NewOrderNotification notification = new NewOrderNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("risk-information-notification") > -1) {
			RiskInformationNotificationProcessor processor = new RiskInformationNotificationProcessorImpl(
					mc);
			RiskInformationNotification notification = new RiskInformationNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("order-state-change-notification") > -1) {
			OrderStateChangeNotificationProcessor processor = new OrderStateChangeNotificationProcessorImpl(
					mc);
			OrderStateChangeNotification notification = new OrderStateChangeNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("charge-amount-notification") > -1) {
			ChargeAmountNotificationProcessor processor = new ChargeAmountNotificationProcessorImpl(
					mc);
			ChargeAmountNotification notification = new ChargeAmountNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("refund-amount-notification") > -1) {
			RefundAmountNotificationProcessor processor = new RefundNotificationProcessorImpl(
					mc);
			RefundAmountNotification notification = new RefundAmountNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("chargeback-amount-notification") > -1) {
			ChargebackAmountNotificationProcessor processor = new ChargebackAmountNotificationProcessorImpl(
					mc);
			ChargebackAmountNotification notification = new ChargebackAmountNotification(
					notificationString);
			return processor.process(notification);
		}
		if (notificationString.indexOf("authorization-amount-notification") > -1) {
			AuthorizationAmountNotificationProcessor processor = new AuthorizationAmountNotificationProcessorImpl(
					mc);
			AuthorizationAmountNotification notification = new AuthorizationAmountNotification(
					notificationString);
			return processor.process(notification);
		}
		throw new Exception("Notification not recoginsed.");
	}

	private String getNotificationBody(InputStream inputStream)
			throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));
		StringBuffer xml = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {
			xml.append(line + "\n");
		}
		reader.close();

		return xml.toString();
	}
}
