package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.DeliverOrderRequest;
import com.google.checkout.orderprocessing.impl.DeliverOrderRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */
//TODO:  fix this and port to JUnit.
public final class DeliverOrderRequestTest {
	public static final void testGeneralDeliverOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		DeliverOrderRequest dor = 
			new DeliverOrderRequestImpl(myMConstants, "375053533130049", "UPS", "1234", true);
		
		System.out.println("XML To Send: "+dor.getXml());
		
		cResponse = dor.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddDeliverOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		DeliverOrderRequest dor = 
			new DeliverOrderRequestImpl(myMConstants, "375053533130049");
		
    ((DeliverOrderRequestImpl)dor).setCarrier("DHL");
    	((DeliverOrderRequestImpl)dor).setTrackingNo("1234");
		((DeliverOrderRequestImpl)dor).setSendEmail(true);
		
		System.out.println("XML To Send: "+dor.getXml());
		
		cResponse = dor.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddMultDeliverOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		DeliverOrderRequest dor = 
			new DeliverOrderRequestImpl(myMConstants, "375053533130049");
		
		((DeliverOrderRequestImpl)dor).setTrackingNo("1234");
    ((DeliverOrderRequestImpl)dor).setCarrier("UPS");
    ((DeliverOrderRequestImpl)dor).setSendEmail(true);
		
		// Second time
    ((DeliverOrderRequestImpl)dor).setTrackingNo("5678");
    ((DeliverOrderRequestImpl)dor).setCarrier("DHL");
    ((DeliverOrderRequestImpl)dor).setSendEmail(false);
		
		System.out.println("XML To Send: "+dor.getXml());
		
		cResponse = dor.send();
		
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
		//testGeneralDeliverOrderRequest();
		//testAddDeliverOrderRequest();
		//testAddMultDeliverOrderRequest();
	}
}
