/*******************************************************************************
 * Copyright (C) 2006 Google Inc.
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

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.checkout.MerchantConstants;
import com.google.checkout.example.CheckoutRequestFactory;
import com.google.checkout.example.notification.NotificationAcknowledgment;

/**
 * 
 */
public class JmsNotificationServlet extends javax.servlet.http.HttpServlet {

  private static final String queueName = "queue/GoogleCheckoutInbox";

  private static final String qcfName = "QueueConnectionFactory";

  private static QueueConnectionFactory queueConnectionFactory = null;

  private Queue queue = null;

  private TextMessage message;

  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#HttpServlet()
   */
  public JmsNotificationServlet() {
    try {
      Context jndiContext = new InitialContext();
      queueConnectionFactory = (QueueConnectionFactory) jndiContext
          .lookup(qcfName);
      queue = (Queue) jndiContext.lookup(queueName);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
   *      HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /*
   * (non-Java-doc)
   * 
   * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
   *      HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MerchantConstants mc = CheckoutRequestFactory.getMerchantConstants();

    try {
      String auth = request.getHeader("Authorization");
      if (auth == null || !auth.equals("Basic " + mc.getHttpAuth())) {
        throw new Exception("Authentication Failed.");
      }

      String notification = getNotificationBody(request.getInputStream());
      String ret = dispatch(notification);

      PrintWriter out = response.getWriter();
      out.print(ret);

    } catch (Exception ex) {
      ex.printStackTrace();
      response.sendError(HttpServletResponse.SC_FORBIDDEN, ex.getMessage());
    }
  }

  private String dispatch(String notification) throws Exception {
    if (notification.indexOf("new-order-notification ") > -1) {
      return storeMessage("new-order-notification", notification);
    }
    if (notification.indexOf("risk-information-notification") > -1) {
      return storeMessage("risk-information-notification", notification);
    }
    if (notification.indexOf("order-state-change-notification") > -1) {
      return storeMessage("order-state-change-notification", notification);
    }
    if (notification.indexOf("charge-amount-notification") > -1) {
      return storeMessage("charge-amount-notification", notification);
    }
    if (notification.indexOf("refund-amount-notification") > -1) {
      return storeMessage("refund-amount-notification", notification);
    }
    if (notification.indexOf("chargeback-amount-notification") > -1) {
      return storeMessage("chargeback-amount-notification", notification);
    }
    if (notification.indexOf("authorization-amount-notification") > -1) {
      return storeMessage("authorization-amount-notification", notification);
    }
    throw new Exception("Notification not recoginsed.");
  }

  private String storeMessage(String messageType, String contents) {
    QueueConnection queueConnection = null;
    try {
      queueConnection = queueConnectionFactory.createQueueConnection();
      QueueSession queueSession = queueConnection.createQueueSession(false,
          Session.AUTO_ACKNOWLEDGE);
      QueueSender queueSender = queueSession.createSender(queue);
      message = queueSession.createTextMessage();
      message.setStringProperty("messageType", messageType);
      message.setText(contents);
      queueSender.send(message);
      
      return NotificationAcknowledgment.getAckString(); 
      
    } catch (JMSException e) {
      e.printStackTrace();
    } finally {
      if (queueConnection != null) {
        try {
          queueConnection.close();
        } catch (JMSException e) {
          e.printStackTrace();
        }
      }
    }
    return "Error!";
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
