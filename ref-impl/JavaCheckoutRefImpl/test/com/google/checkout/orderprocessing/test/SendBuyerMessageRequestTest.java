package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;
import com.google.checkout.orderprocessing.impl.SendBuyerMessageRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */
//TODO:  fix this and port to JUnit.
public class SendBuyerMessageRequestTest {
	public static final void testGeneralSendBuyerMessageRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		SendBuyerMessageRequest sbmr = 
			new SendBuyerMessageRequestImpl(myMConstants, "375053533130049", "Hi, How are you today?", true);
		
		System.out.println("XML To Send: "+sbmr.getXml());
		
		cResponse = sbmr.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddSendBuyerMessageRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		SendBuyerMessageRequest sbmr = 
			new SendBuyerMessageRequestImpl(myMConstants, "375053533130049", "Hi, How are you today?");
		
		((SendBuyerMessageRequestImpl)sbmr).setSendEmail(true);
		
		System.out.println("XML To Send: "+sbmr.getXml());
		
		cResponse = sbmr.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddExceedStrLimitSendBuyerMessageRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		SendBuyerMessageRequest sbmr = 
			new SendBuyerMessageRequestImpl(myMConstants, "375053533130049", "Hi, How are you today?  Here are extra characters: hfaoehfoahefiahfoiaheoifhaewoihaoiwehfoiawhfeoiahfeoihefoihfoihaefoihaefoihaefoihaoifehfoieahfoahefoiahofhaefhoaehffhaiehfaohfaohfoiehaofiehoiahfoieahfoiheoifhoaehfoiahfeoiahefoihaefoihaeoifhoiafheoiahfeohahfieahofaihefohaeiahfo");
		
		((SendBuyerMessageRequestImpl)sbmr).setSendEmail(true);
		
		System.out.println("XML To Send: "+sbmr.getXml());
		
		cResponse = sbmr.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	
	public static final void testAddMultSendBuyerMessageRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		SendBuyerMessageRequest sbmr = 
			new SendBuyerMessageRequestImpl(myMConstants, "375053533130049", "Hi, How are you today?");
		
		((SendBuyerMessageRequestImpl)sbmr).setSendEmail(true);
		((SendBuyerMessageRequestImpl)sbmr).setSendEmail(true);
		((SendBuyerMessageRequestImpl)sbmr).setSendEmail(true);
		
		System.out.println("XML To Send: "+sbmr.getXml());
		
		cResponse = sbmr.send();
		
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
		//testGeneralSendBuyerMessageRequest();
		//testAddSendBuyerMessageRequest();
		//testAddExceedStrLimitSendBuyerMessageRequest();
		//testAddMultSendBuyerMessageRequest();
	}
}
