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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.impl.util.Utils;

/**
 * The default implementation of the CheckoutResponse interface.
 *
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0 - ksim - March 7th, 2007 - 	Initial Version to separate interface and implementation		
 * @todo		Not unit tested yet, but tested fairly well over all.
 * 				Still missing extra function implementations
 */
public class CheckoutResponseImpl extends AbstractCheckoutResponse {
	
	private Document document;
	
	/**
   * The default constructor. 
	 */
  public CheckoutResponseImpl() {
		processResponse("");
	}
	/**
   * A constructor which takes the response String.
   * 
   * @param response
	 */
	public CheckoutResponseImpl(String response) {
		processResponse(response);
	}

  
	/* (non-Javadoc)
	 * @see com.google.checkout.impl.AbstractCheckoutResponse#processResponse(java.lang.String)
	 */
	protected void processResponse(String response)
	{
	    document = Utils.newDocumentFromString(response);
	}
	
	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#isValidRequest()
	 */
	public boolean isValidRequest()
	{
		return true;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getSerialNumber()
	 */
	public String getSerialNumber()
	{
		return "";
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getErrorMessage()
	 */
	public String getErrorMessage()
	{
		return "";
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutResponse#getRedirectUrl()
	 */
	public String getRedirectUrl()
	{
		Element redirect = Utils.findElementOrContainer(document, document.getDocumentElement(), "redirect-url");
		if (redirect != null) {return redirect.getTextContent();}
		return "<error!>";
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
