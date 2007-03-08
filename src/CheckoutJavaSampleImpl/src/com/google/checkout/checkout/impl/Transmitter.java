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
package com.google.checkout.checkout.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Base64Coder;

/**
 * @version 1.0 beta
 */
public class Transmitter {

  private Transmitter() {
  }

  /**
   * Transmit http url with the given content to Google checkout
   */
  public static String transmit(MerchantConstants mc, URL httpUrl, String content) throws IOException {
    HttpURLConnection httpConn = (HttpURLConnection) httpUrl.openConnection();
    setupHeaders(mc, httpConn);
    httpConn.connect();
    setContent(httpConn, content);
    return getResponse(httpConn);
  }

  private static void setupHeaders(MerchantConstants mc, HttpURLConnection conn)
      throws ProtocolException {
    conn.setDoInput(true);
    conn.setDoOutput(true);
    conn.setUseCaches(false);
    conn.setInstanceFollowRedirects(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Authorization", "Basic " + getHttpAuth(mc));
    conn.setRequestProperty("Host", conn.getURL().getHost());

    // Changed to allow i18n character sets to be processed properly
    conn.setRequestProperty("content-type", "application/xml; charset=UTF-8");
    conn.setRequestProperty("accept", "application/xml");
  }

  private static void setContent(HttpURLConnection conn, String content)
      throws IOException {
    OutputStreamWriter sWriter = new OutputStreamWriter(conn.getOutputStream());
    BufferedWriter writer = new BufferedWriter(sWriter);
    writer.write(content);
    writer.close();
  }

  private static String getResponse(HttpURLConnection conn) throws IOException {
    InputStreamReader sReader = null;
    try {
      sReader = new InputStreamReader(conn.getInputStream());
    } catch (IOException ex) {
      sReader = new InputStreamReader(conn.getErrorStream());
    }
    BufferedReader reader = new BufferedReader(sReader);
    StringBuffer buffer = new StringBuffer();
    String line = null;
    while (null != (line = reader.readLine())) {
      buffer.append(line);
    }
    return buffer.toString();
  }
  
  private static String getHttpAuth(MerchantConstants mc) {
	    String combinedKey = mc.getMerchantId() + ":" + mc.getMerchantKey();
	    return Base64Coder.encode(combinedKey);
  }
}