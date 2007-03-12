package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;
import com.google.checkout.orderprocessing.impl.ArchiveOrderRequestImpl;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class ArchiveOrderRequestTest {
	
	public static final void testArchiveOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ArchiveOrderRequest aor = 
			new ArchiveOrderRequestImpl(myMConstants, "722229750245246");
		
		System.out.println("XML To Send: "+aor.getXml());
		
		cResponse = aor.send();
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		testArchiveOrderRequest();
	}
}
