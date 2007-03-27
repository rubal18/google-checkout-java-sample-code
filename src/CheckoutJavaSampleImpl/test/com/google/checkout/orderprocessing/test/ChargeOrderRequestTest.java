package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.ChargeOrderRequest;
import com.google.checkout.orderprocessing.impl.ChargeOrderRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */
//TODO:  fix this and port to JUnit.
public final class ChargeOrderRequestTest {
	
	public static final void testGeneralChargeOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialConstructorChargeOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049", new Float(9.00).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialAddChargeOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		((ChargeOrderRequestImpl)cor).setAmount(new Float(.50).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testPartialAddMultChargeOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		ChargeOrderRequest cor = 
			new ChargeOrderRequestImpl(myMConstants, "375053533130049");
		
		((ChargeOrderRequestImpl)cor).setAmount(new Float(.50).floatValue());
		((ChargeOrderRequestImpl)cor).setAmount(new Float(.60).floatValue());
		((ChargeOrderRequestImpl)cor).setAmount(new Float(.70).floatValue());
		
		System.out.println("XML To Send: "+cor.getXml());
		
		cResponse = cor.send();
		
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
		//testGeneralChargeOrderRequest();
		//testPartialConstructorChargeOrderRequest();
		//testPartialAddChargeOrderRequest();
		//testPartialAddMultChargeOrderRequest();
	}
}
