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

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.checkout.MerchantConstants;
import com.google.checkout.example.CheckoutRequestFactory;
import com.google.checkout.example.merchantcalculation.MerchantCalculationCallbackProcessorImpl;
import com.google.checkout.merchantcalculation.MerchantCalculationCallback;
import com.google.checkout.merchantcalculation.MerchantCalculationCallbackProcessor;
import com.google.checkout.merchantcalculation.MerchantCalculationResults;

/**
 * 
 */
public class MerchantCalculationServlet extends javax.servlet.http.HttpServlet {

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

    MerchantConstants mc = CheckoutRequestFactory.getMerchantConstants();

    try {
      String auth = request.getHeader("Authorization");
      if (auth == null || !auth.equals("Basic " + mc.getHttpAuth())) {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed.");
        return;
      }
      
      MerchantCalculationCallbackProcessor cp = new MerchantCalculationCallbackProcessorImpl(mc);

      InputStream in = request.getInputStream();
      MerchantCalculationCallback callback = new MerchantCalculationCallback(in);
      MerchantCalculationResults results = cp.process(callback);

      PrintWriter out = response.getWriter();
      out.print(results.getXml());

    } catch (Exception ex) {
      ex.printStackTrace();
      response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
    }
  }
}
