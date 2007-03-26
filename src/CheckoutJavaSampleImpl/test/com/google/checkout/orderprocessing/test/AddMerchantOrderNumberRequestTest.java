package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;
import com.google.checkout.orderprocessing.impl.AddMerchantOrderNumberRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class AddMerchantOrderNumberRequestTest {

	public static final void testGeneralAddMerchantOrderNumberRequest() throws Exception
	
  {
//  TODO:  fix this and port to JUnit.
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		AddMerchantOrderNumberRequest amonr = 
			new AddMerchantOrderNumberRequestImpl(myMConstants, "722229750245246", "123");
		
		System.out.println("XML To Send: "+amonr.getXml());
		
		cResponse = amonr.send();
		
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
	public static void main(String[] args) throws Exception
	{
		testGeneralAddMerchantOrderNumberRequest();
	}

}
