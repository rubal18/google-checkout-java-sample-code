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

package com.google.checkout.notification;

import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.util.Utils;

/**
 * TODO
 * 
 * @author simonjsmith
 * 
 */
public abstract class CheckoutNotification {

	protected Document document;

	protected Element root;

	/**
	 * Return the Google Order Number for this notification.
	 * 
	 * @return The Google Order Number.
	 */
	public String getGoogleOrderNo() {
		return Utils.getElementStringValue(document, root,
				"google-order-number");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public Date getTimestamp() {
		return Utils.getElementDateValue(document, root, "timestamp");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getSerialNumber() {
		return root.getAttribute("serial-number");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getXml() {
		return Utils.documentToString(document);
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getRootNodeName() {
		return document.getDocumentElement().getNodeName();
	}
}
