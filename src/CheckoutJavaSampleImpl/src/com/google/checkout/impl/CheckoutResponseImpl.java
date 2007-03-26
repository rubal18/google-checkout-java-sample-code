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

package com.google.checkout.impl;

import java.io.InputStream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.impl.util.Utils;

/**
 * The default implementation of the CheckoutResponse interface.
 *
 * @author 		ksim
 * @version		1.0 - ksim - March 7th, 2007 - 	Initial Version to separate interface and implementation		
 */
//TODO
public class CheckoutResponseImpl implements CheckoutResponse {
	
	private Document document;
  private Element root;
	
	/**
   * The default constructor. 
	 */
  public CheckoutResponseImpl() {
		this("");
	}

  /**
   * A constructor which takes the response String.
   * 
   * @param response The response String.
	 */
	public CheckoutResponseImpl(String response) {
    document = Utils.newDocumentFromString(response);
    root = document.getDocumentElement();
  }

  /**
   * A constructor which takes the response as an InputStream.
   * 
   * @param response The response as an InputStream
   */
  public CheckoutResponseImpl(InputStream response) {
    document = Utils.newDocumentFromInputStream(response);
    root = document.getDocumentElement();
  }
	
	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#isValidRequest()
	 */
	public boolean isValidRequest()
	{
    String nodeName = root.getNodeName();
    if ("checkout-redirect".equals(nodeName) || "request-received".equals(nodeName)) {
      return true;
    }
    return false;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getSerialNumber()
	 */
	public String getSerialNumber()
	{
		return root.getAttribute("serial-number");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getErrorMessage()
	 */
	public String getErrorMessage()
	{
		return Utils.getElementStringValue(document, root, "error-message");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getRedirectUrl()
	 */
	public String getRedirectUrl()
	{
		return Utils.getElementStringValue(document, root, "redirect-url");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getXml()
	 */
	public String getXml() {
		return Utils.documentToString(document);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getXmlPretty()
	 */
	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}
}
