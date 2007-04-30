package com.google.checkout.merchantcalculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.checkout.util.Utils;

import junit.framework.TestCase;

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
		MerchantCalculationCallback c = new MerchantCalculationCallback(callbackXml);
		
		assertEquals(c.getBuyerId(), 419797746651146l);
		assertEquals(c.getAnonymousAddresses().size(), 1);
		assertEquals(c.getBuyerLanguage(), "en_US");
		assertEquals(c.getCartExpiration(), Utils.parseDate("2006-12-31T23:59:59.000Z"));
		assertEquals(c.getItems().size(), 2);
		assertEquals(c.getMerchantCodes().size(), 2);
		assertEquals(c.getMerchantPrivateDataNodes(), null);
		assertEquals(c.getSerialNumber(), "6412b6a8-d366-32ab-a42b-1c4a673d3523");
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
