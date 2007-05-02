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

package com.google.checkout.orderprocessing;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;

import com.google.checkout.MerchantConstants;

public final class ArchiveOrderRequestTest extends XMLTestCase {

	String xsd = "http://code.google.com/apis/checkout/apiv2.xsd";

	MerchantConstants dummyMerchantConstants;

	public ArchiveOrderRequestTest(String name) {
		super(name);
	}

	public void setUp() throws Exception {

		dummyMerchantConstants = new MerchantConstants("", "", "", "USD", "",
				"", "");

		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		XMLUnit.setIgnoreComments(true);
	}

	public void testRequest() throws Exception {

		ArchiveOrderRequest request = new ArchiveOrderRequest(
				dummyMerchantConstants);
		request.setGoogleOrderNo("1234567890");

		Validator v = new Validator(request.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());
	}
}
