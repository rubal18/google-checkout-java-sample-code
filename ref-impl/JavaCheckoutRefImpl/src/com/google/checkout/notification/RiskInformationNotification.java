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

import java.io.InputStream;

import org.w3c.dom.Element;

import com.google.checkout.util.Utils;

/**
 * TODO
 * 
 * @author simonjsmith
 * 
 */
public class RiskInformationNotification extends CheckoutNotification {

	Element riskInfo;

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public RiskInformationNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
		riskInfo = Utils.findElementOrContainer(document, root,
				"risk-information");
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public RiskInformationNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
		riskInfo = Utils.findElementOrContainer(document, root,
				"risk-information");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean isEligibleForProtection() {
		return Utils.getElementBooleanValue(document, riskInfo,
				"eligible-for-protection");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public Address getBillingAddress() {
		Element address = Utils.findElementOrContainer(document, riskInfo,
				"billing-address");
		return new Address(document, address);
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getAvsResponse() {
		return Utils.getElementStringValue(document, riskInfo, "avs-response");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getCvnResponse() {
		return Utils.getElementStringValue(document, riskInfo, "cvn-response");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getPartialCcNumber() {
		return Utils.getElementStringValue(document, riskInfo,
				"partial-cc-number");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public int getBuyerAccountAge() {
		return Utils
				.getElementIntValue(document, riskInfo, "buyer-account-age");
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public String getIpAddress() {
		return Utils.getElementStringValue(document, riskInfo, "ip-address");
	}
}
