package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.ChargeOrderRequest;
import com.google.checkout.orderprocessing.impl.ChargeOrderRequestImpl;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class ChargeOrderRequestTest {
	
	public static final void testGeneralChargeOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getResponseXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialConstructorChargeOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049", new Float(9.00).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getResponseXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialAddChargeOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		((ChargeOrderRequestImpl)cor).addAmount(new Float(.50).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getResponseXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialAddMultChargeOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		((ChargeOrderRequestImpl)cor).addAmount(new Float(.50).floatValue());
		((ChargeOrderRequestImpl)cor).addAmount(new Float(.60).floatValue());
		((ChargeOrderRequestImpl)cor).addAmount(new Float(.70).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getResponseXml();
		
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
		testGeneralChargeOrderRequest();
		//testPartialConstructorChargeOrderRequest();
		//testPartialAddChargeOrderRequest();
		//testPartialAddMultChargeOrderRequest();
	}
}
