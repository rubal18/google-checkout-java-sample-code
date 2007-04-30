package com.google.checkout.orderprocessing;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;

import com.google.checkout.MerchantConstants;
import com.google.checkout.orderprocessing.RefundOrderRequest;

public final class RefundOrderRequestTest extends XMLTestCase {

	String xsd = "http://code.google.com/apis/checkout/apiv2.xsd";

	MerchantConstants dummyMerchantConstants;

	public RefundOrderRequestTest(String name) {
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

		RefundOrderRequest request = new RefundOrderRequest(
				dummyMerchantConstants);
		request.setGoogleOrderNo("1234567890");
		request.setAmount(10.0f);
		request.setComment("comment");
		request.setReason("reason");

		Validator v = new Validator(request.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());
	}
}
