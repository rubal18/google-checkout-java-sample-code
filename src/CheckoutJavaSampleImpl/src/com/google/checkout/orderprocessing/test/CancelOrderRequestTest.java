package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.CancelOrderRequest;
import com.google.checkout.orderprocessing.impl.CancelOrderRequestImpl;

/**
 * @author 		ksim
 * @date   		March 10th, 2007
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */

public final class CancelOrderRequestTest {
	public static final void testGeneralCancelOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		CancelOrderRequest cor = 
			new CancelOrderRequestImpl(myMConstants, "375053533130049", "User Decided to Cancel the Order", "Not too much to comment on");
		
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
	
	public static final void testAddCancelOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		CancelOrderRequest cor = 
			new CancelOrderRequestImpl(myMConstants, "375053533130049", "User Decided to Cancel the Order");
		
		((CancelOrderRequestImpl)cor).addComment("Not too much to comment on");
		
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
	
	public static final void testAddExceedStrLimitCancelOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		CancelOrderRequest cor = 
			new CancelOrderRequestImpl(myMConstants, "375053533130049", "User Decided to Cancel the Order, but here are extra characters: hfaoehfoahefiahfoiaheoifhaewoihaoiwehfoiawhfeoiahfeoihefoihfoihaefoihaefoihaefoihaoifehfoieahfoahefoiahofhaefhoaehffhaiehfao");

		((CancelOrderRequestImpl)cor).addComment("Not too much to comment on, but here are extra characters: hfaoehfoahefiahfoiaheoifhaewoihaoiwehfoiawhfeoiahfeoihefoihfoihaefoihaefoihaefoihaoife");
		
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
	
	
	public static final void testAddMultCancelOrderRequest()
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		CancelOrderRequest cor = 
			new CancelOrderRequestImpl(myMConstants, "375053533130049", "User Decided to Cancel the Order");
		
		((CancelOrderRequestImpl)cor).addComment("Not too much to comment on");
		((CancelOrderRequestImpl)cor).addComment("Not too much to comment on");
		
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
		testGeneralCancelOrderRequest();
		//testAddCancelOrderRequest();
		//testAddExceedStrLimitCancelOrderRequest();
		//testAddMultCancelOrderRequest();
	}
}
