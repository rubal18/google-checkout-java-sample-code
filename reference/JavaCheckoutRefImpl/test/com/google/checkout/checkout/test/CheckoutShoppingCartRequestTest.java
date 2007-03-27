package com.google.checkout.checkout.test;

import com.google.checkout.CheckoutResponse;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.impl.CheckoutShoppingCartRequestImpl;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.orderprocessing.impl.AddMerchantOrderNumberRequestImpl;

/**
 * @author 		ksim
 * @version		1.0 - ksim - March 10th, 2007 - Initial Version - Not completely working yet though.
 *
 */
//TODO:  fix this and port to JUnit.
public class CheckoutShoppingCartRequestTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
    //TODO:  fix this and port to JUnit.
		CheckoutResponse cResponse;
		
		CheckoutShoppingCartRequestImpl cscri = 
			new CheckoutShoppingCartRequestImpl(new MerchantConstantsImpl("248088419036992", "Q2x_yWSVUHokvFxw1MqVjg", "0", "US", "", "", ""));
		
		cscri.addItem("Biscuit", "Yummy hot biscuit", new Float(9.99).floatValue(), 2);
		
		//System.out.println(cscri.getXml());
		
		cResponse = cscri.send();
		
		//System.out.println(cResponse.getResponseXml());
		
		System.out.println("Success!");
		return;
	}

}
