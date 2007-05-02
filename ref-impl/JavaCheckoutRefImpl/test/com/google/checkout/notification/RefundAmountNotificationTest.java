package com.google.checkout.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.checkout.util.Utils;

import junit.framework.TestCase;

public class RefundAmountNotificationTest extends TestCase {

	String notificationXml;
	
	public RefundAmountNotificationTest(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {

		notificationXml = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/notification/refund-amount-notification.xml"));
	}
	
	public void testNotification() throws Exception {
		RefundAmountNotification n = new RefundAmountNotification(notificationXml);
		
		assertEquals(n.getGoogleOrderNo(), "841171949013218");
		assertEquals(n.getSerialNumber(), "d669f8c7-6d75-4ad6-9278-d2fc997d15f2");
		assertEquals(n.getTimestamp(), Utils.parseDate("2006-03-18T20:25:31.823Z"));
		assertEquals(n.getLatestRefundAmount(), 226.06f);
		assertEquals(n.getTotalRefundAmount(), 226.06f);
		assertEquals(n.getCurrencyCode(), "USD");
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
