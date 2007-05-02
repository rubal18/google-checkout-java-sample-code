package com.google.checkout.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.checkout.util.Utils;

import junit.framework.TestCase;

public class AuthorizationAmountNotificationTest extends TestCase {

	String notificationXml;
	
	public AuthorizationAmountNotificationTest(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {

		notificationXml = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/notification/authorization-amount-notification.xml"));
	}
	
	public void testNotification() throws Exception {
		AuthorizationAmountNotification n = new AuthorizationAmountNotification(notificationXml);
		
		assertEquals(n.getGoogleOrderNo(), "841171949013218");
		assertEquals(n.getSerialNumber(), "bea6bc1b-e1e2-44fe-80ff-2391b25c2510");
		assertEquals(n.getTimestamp(), Utils.parseDate("2006-03-18T20:25:31"));
		assertEquals(n.getAuthorizationAmount(), 226.06f);
		assertEquals(n.getAuthorizationExpirationDate(), Utils.parseDate("2006-03-18T20:25:31"));
		assertEquals(n.getAvsResponse(), "Y");
		assertEquals(n.getCurrentyCode(), "USD");
		assertEquals(n.getCvnResponse(), "Y");
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
