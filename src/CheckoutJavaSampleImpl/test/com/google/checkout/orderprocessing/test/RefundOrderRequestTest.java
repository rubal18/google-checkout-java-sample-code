package com.google.checkout.orderprocessing.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.RefundOrderRequest;
import com.google.checkout.orderprocessing.impl.RefundOrderRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version
 *
 */
//TODO:  fix this and port to JUnit.
public final class RefundOrderRequestTest {
	public static final void testGeneralRefundOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		RefundOrderRequest ror = 
			new RefundOrderRequestImpl(myMConstants, "375053533130049", "Failed Risk Assessment", new Float(.50).floatValue(), "Not too much to comment on");
		
		System.out.println("XML To Send: "+ror.getXml());
		
		cResponse = ror.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddRefundOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		RefundOrderRequest ror = 
			new RefundOrderRequestImpl(myMConstants, "375053533130049", "Failed Risk Assessment");
		
		((RefundOrderRequestImpl)ror).setAmount(new Float(.50).floatValue());
		((RefundOrderRequestImpl)ror).setComment("Not too much to comment on");
		
		System.out.println("XML To Send: "+ror.getXml());
		
		cResponse = ror.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	public static final void testAddExceedStrLimitRefundOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		RefundOrderRequest ror = 
			new RefundOrderRequestImpl(myMConstants, "375053533130049", "Failed Risk Assessment, but here are extra characters: hfaoehfoahefiahfoiaheoifhaewoihaoiwehfoiawhfeoiahfeoihefoihfoihaefoihaefoihaefoihaoifehfoieahfoahefoiahofhaefhoaehffhaiehfao");
		
		((RefundOrderRequestImpl)ror).setAmount(new Float(.50).floatValue());
		((RefundOrderRequestImpl)ror).setComment("Not too much to comment on, but here are extra characters: hfaoehfoahefiahfoiaheoifhaewoihaoiwehfoiawhfeoiahfeoihefoihfoihaefoihaefoihaefoihaoife");
		
		System.out.println("XML To Send: "+ror.getXml());
		
		cResponse = ror.send();
		
		cResponseStr = cResponse.getXml();
		
		if (cResponseStr != null)
			System.out.println(new StringBuffer("XML Received: ").append(cResponseStr));
		else
			System.out.println("No Response XML was sent.");
		
		System.out.println("Success!");
		return;
	}
	
	
	public static final void testAddMultRefundOrderRequest() throws Exception
	{
		MerchantConstants myMConstants = new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", EnvironmentType.Sandbox, "USD", "", "", "");
		CheckoutResponse cResponse;
		String cResponseStr;
		
		RefundOrderRequest ror = 
			new RefundOrderRequestImpl(myMConstants, "375053533130049", "Failed Risk Assessment");
		
		((RefundOrderRequestImpl)ror).setAmount(new Float(.50).floatValue());
		((RefundOrderRequestImpl)ror).setComment("Not too much to comment on");
		
		((RefundOrderRequestImpl)ror).setAmount(new Float(.50).floatValue());
		((RefundOrderRequestImpl)ror).setComment("Not too much to comment on");
		
		System.out.println("XML To Send: "+ror.getXml());
		
		cResponse = ror.send();
		
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
		//testGeneralRefundOrderRequest();
		//testAddRefundOrderRequest();
		//testAddExceedStrLimitRefundOrderRequest();
		//testAddMultRefundOrderRequest();
	}
}
