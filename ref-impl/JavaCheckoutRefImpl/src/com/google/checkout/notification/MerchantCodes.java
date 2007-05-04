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

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.util.Utils;

/**
 * This class is the parent class of the merchant code classes. 
 * 
 * @author simonjsmith
 * 
 */
public abstract class MerchantCodes {

	protected Document document;

	protected Element element;

	/**
	 * Retrieves the value of the &lt;applied-amount&gt; element.
	 * 
	 * @return The applied amount.
	 */
	public float getAppliedAmount() {
		return Utils.getElementFloatValue(document, element, "applied-amount");
	}

	/**
	 * Retrieves the value of the &lt;calculated-amount&gt; element.
	 * 
	 * @return The calculated amount.
	 */
	public float getCalculatedAmount() {
		return Utils.getElementFloatValue(document, element,
				"calculated-amount");
	}

	/**
	 * Retrieves the value of the &lt;code&gt; element.
	 * 
	 * @return The code.
	 */
	public String getCode() {
		return Utils.getElementStringValue(document, element, "code");
	}

	/**
	 * Retrieves the value of the &lt;message&gt; element.
	 * 
	 * @return The message.
	 */
	public String getMessage() {
		return Utils.getElementStringValue(document, element, "message");
	}
}
