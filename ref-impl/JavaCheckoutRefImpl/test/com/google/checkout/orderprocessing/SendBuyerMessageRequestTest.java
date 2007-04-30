package com.google.checkout.orderprocessing;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;

import com.google.checkout.MerchantConstants;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;

public class SendBuyerMessageRequestTest extends XMLTestCase {

	String xsd = "http://code.google.com/apis/checkout/apiv2.xsd";

	MerchantConstants dummyMerchantConstants;

	public SendBuyerMessageRequestTest(String name) {
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

		SendBuyerMessageRequest request = new SendBuyerMessageRequest(
				dummyMerchantConstants);
		request.setGoogleOrderNo("1234567890");
		request.setMessage("message");
		request.setSendEmail(true);

		Validator v = new Validator(request.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());
	}
}
