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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.TestCase;

import com.google.checkout.checkout.Item;
import com.google.checkout.util.Utils;

public class MerchantCalculationCallbackTest extends TestCase {

	String callbackXml;

	public MerchantCalculationCallbackTest(String name) {
		super(name);
	}

	public void setUp() throws Exception {

		callbackXml = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/merchantcalculation/merchant-calculation-callback.xml"));
	}

	public void testCallback() throws Exception {
		MerchantCalculationCallback c = new MerchantCalculationCallback(
				callbackXml);

		assertEquals(c.getBuyerId(), 419797746651146l);
		assertEquals(c.getAnonymousAddresses().size(), 1);
		Collection addresses = c.getAnonymousAddresses();
		AnonymousAddress a = (AnonymousAddress) addresses.iterator().next();
		assertEquals(a.getCity(), "Mountain View");
		assertEquals(a.getCountryCode(), "USA");
		assertEquals(a.getId(), "425353566534775");
		assertEquals(a.getPostalCode(), "94043");
		assertEquals(a.getRegion(), "CA");

		assertEquals(c.getBuyerLanguage(), "en_US");
		assertEquals(c.getCartExpiration(), Utils
				.parseDate("2006-12-31T23:59:59.000Z"));
		assertEquals(c.getItems().size(), 2);
		Collection items = c.getItems();
		Iterator it = items.iterator();
		Item i1 = (Item) it.next();
		assertEquals(
				i1.getItemDescription(),
				"A pack of highly nutritious dried food for emergency - store in your garage for up to one year!!");
		assertEquals(i1.getItemName(), "Dry Food Pack AA1453");
		assertEquals(i1.getMerchantItemId(), "");
		assertEquals(i1.getMerchantPrivateItemData().length, 0);
		assertEquals(i1.getQuantity(), 1);
		assertEquals(i1.getUnitPriceAmount(), 35.00f);
		assertEquals(i1.getUnitPriceCurrency(), "USD");
		assertEquals(i1.getTaxTableSelector(), "food");

		assertEquals(c.getMerchantCodes().size(), 2);
		assertEquals(c.getMerchantPrivateDataNodes(), null);
		assertEquals(c.getSerialNumber(),
				"6412b6a8-d366-32ab-a42b-1c4a673d3523");
		assertEquals(c.getShippingMethods().size(), 1);
	}

	private String inputStreamAsString(InputStream stream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		StringBuilder sb = new StringBuilder();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		br.close();
		return sb.toString();
	}
}
