package com.google.checkout.notification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.checkout.util.Utils;

import junit.framework.TestCase;

public class ChargebackAmountNotificationTest extends TestCase {

	String notificationXml;
	
	public ChargebackAmountNotificationTest(String name) {
		super(name);
	}
	
	public void setUp() throws Exception {

		notificationXml = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/notification/chargeback-amount-notification.xml"));
	}
	
	public void testNotification() throws Exception {
		ChargebackAmountNotification n = new ChargebackAmountNotification(notificationXml);
		
		assertEquals(n.getGoogleOrderNo(), "841171949013218");
		assertEquals(n.getSerialNumber(), "bea6bc1b-e1e2-44fe-80ff-0180e33a2614");
		assertEquals(n.getTimestamp(), Utils.parseDate("2006-03-18T19:10:04.423Z"));
		assertEquals(n.getLatestChargebackAmount(), 226.06f);
		assertEquals(n.getTotalChargebackAmount(), 226.06f);
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
