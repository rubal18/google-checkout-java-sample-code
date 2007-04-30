package com.google.checkout.orderprocessing;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;

import com.google.checkout.MerchantConstants;
import com.google.checkout.orderprocessing.ChargeOrderRequest;

public final class ChargeOrderRequestTest extends XMLTestCase {

	String xsd = "http://code.google.com/apis/checkout/apiv2.xsd";

	MerchantConstants dummyMerchantConstants;

	public ChargeOrderRequestTest(String name) {
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

		ChargeOrderRequest request = new ChargeOrderRequest(
				dummyMerchantConstants);
		request.setGoogleOrderNo("1234567890");
		request.setAmount(10.0f);

		Validator v = new Validator(request.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());
	}
}
