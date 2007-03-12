package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;
import com.google.checkout.orderprocessing.impl.UnarchiveOrderRequestImpl;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class UnarchiveOrderRequestTest {
	
	public static final void testUnarchiveOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		UnarchiveOrderRequest uor = 
			new UnarchiveOrderRequestImpl(myMConstants, "722229750245246");
		
		System.out.println("XML To Send: "+uor.getXml());
		
		cResponse = uor.send();
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
		testUnarchiveOrderRequest();
	}
}
