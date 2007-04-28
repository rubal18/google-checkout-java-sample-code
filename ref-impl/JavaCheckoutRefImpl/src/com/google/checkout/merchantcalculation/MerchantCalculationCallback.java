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

package com.google.checkout.merchantcalculation;

import java.util.Collection;
import java.util.Date;

import org.w3c.dom.Element;

public class MerchantCalculationCallback {

	/**
	 * Retrieves the contents of the &lt;items&gt; element as a Colection of
	 * Item objects.
	 * 
	 * @return The Collection of Item objects.
	 * 
	 * @see Item
	 */
	public Collection getItems() {
		// TODO
		throw new RuntimeException("not impl");
	}

	/**
	 * Retrieves the contents of the &lt;merchant-private-data&gt; element as an
	 * array of Elements.
	 * 
	 * @return The contents &lt;merchant-private-data&gt; element value.
	 * 
	 * @see Element
	 */
	public Element[] getMerchantPrivateDataNodes() {
		// TODO
		throw new RuntimeException("not impl");
	}

	/**
	 * Retrieves the value of the &lt;good-until-date&gt; element.
	 * 
	 * @return The cart expiration.
	 * 
	 * @see Date
	 */
	public Date getCartExpiration() {
		// TODO
		throw new RuntimeException("not impl");
	}

	public long getBuyerId() {
		// TODO
		throw new RuntimeException("not impl");
	}

	public String getBuyerLanguage() {
		// TODO
		throw new RuntimeException("not impl");
	}

	public String getSerialNumber() {
		// TODO
		throw new RuntimeException("not impl");
	}

	/**
	 * Indicates whether tax should be calculated or not.
	 * 
	 * @return The boolean tax indicator.
	 */
	public boolean isCalculateTax() {
		// TODO
		throw new RuntimeException("not impl");
	}

	/**
	 * Returns a Collection of Strings representing the &lt;method&gt; tags.
	 * 
	 * @return A Collection of Strings.
	 */
	public Collection getShippingMethods() {
		// TODO
		throw new RuntimeException("not impl");
	};

	/**
	 * Returns a Collection of Strings representing the
	 * &lt;merchant-code-strings&gt;.
	 * 
	 * @return A Collection of Strings.
	 */
	public Collection getMerchantCodes() {
		// TODO
		throw new RuntimeException("not impl");
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public Collection getAnonymousAddresses() {
		// TODO
		throw new RuntimeException("not impl");
	}

}
