package com.google.checkout.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.checkout.util.Utils;

import junit.framework.TestCase;

public class RiskInformationNotificationTest extends TestCase {

	String notificationXml;
	
	public RiskInformationNotificationTest(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {

		notificationXml = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/notification/risk-information-notification.xml"));
	}
	
	public void testNotification() throws Exception {
		RiskInformationNotification n = new RiskInformationNotification(notificationXml);
		
		assertEquals(n.getGoogleOrderNo(), "841171949013218");
		assertEquals(n.getSerialNumber(), "0b95f758-0332-45d5-aced-5da64c8fc5b9");
		assertEquals(n.getTimestamp(), Utils.parseDate("2006-03-18T20:10:04.312Z"));
		assertEquals(n.getAvsResponse(), "N");
		//assertEquals(n.getBillingAddress());
		assertEquals(n.getBuyerAccountAge(), 130);
		assertEquals(n.getCvnResponse(), "M");
		assertEquals(n.getIpAddress(), "123.45.167.189");
		assertEquals(n.getPartialCcNumber(), "4530");

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
