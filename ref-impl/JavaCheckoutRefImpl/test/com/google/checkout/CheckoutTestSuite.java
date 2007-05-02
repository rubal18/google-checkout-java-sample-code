package com.google.checkout;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.google.checkout.checkout.CheckoutShoppingCartRequestTest;
import com.google.checkout.merchantcalculation.MerchantCalculationCallbackTest;
import com.google.checkout.notification.AuthorizationAmountNotificationTest;
import com.google.checkout.notification.ChargeAmountNotificationTest;
import com.google.checkout.notification.ChargebackAmountNotificationTest;
import com.google.checkout.notification.NewOrderNotificationTest;
import com.google.checkout.notification.OrderStateChangeNotificationTest;
import com.google.checkout.notification.RefundAmountNotificationTest;
import com.google.checkout.notification.RiskInformationNotificationTest;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequestTest;
import com.google.checkout.orderprocessing.ArchiveOrderRequestTest;
import com.google.checkout.orderprocessing.CancelOrderRequestTest;
import com.google.checkout.orderprocessing.ChargeOrderRequestTest;
import com.google.checkout.orderprocessing.DeliverOrderRequestTest;
import com.google.checkout.orderprocessing.ProcessOrderRequestTest;
import com.google.checkout.orderprocessing.RefundOrderRequestTest;
import com.google.checkout.orderprocessing.SendBuyerMessageRequestTest;
import com.google.checkout.orderprocessing.UnarchiveOrderRequestTest;

public class CheckoutTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.google.checkout");

		suite.addTestSuite(CheckoutShoppingCartRequestTest.class);
		suite.addTestSuite(AddMerchantOrderNumberRequestTest.class);
		suite.addTestSuite(ArchiveOrderRequestTest.class);
		suite.addTestSuite(CancelOrderRequestTest.class);
		suite.addTestSuite(ChargeOrderRequestTest.class);
		suite.addTestSuite(DeliverOrderRequestTest.class);
		suite.addTestSuite(ProcessOrderRequestTest.class);
		suite.addTestSuite(RefundOrderRequestTest.class);
		suite.addTestSuite(SendBuyerMessageRequestTest	.class);					
		suite.addTestSuite(UnarchiveOrderRequestTest.class);
		
		suite.addTestSuite(MerchantCalculationCallbackTest.class);
		
		suite.addTestSuite(AuthorizationAmountNotificationTest.class);
		suite.addTestSuite(ChargeAmountNotificationTest.class);
		suite.addTestSuite(ChargebackAmountNotificationTest.class);
		suite.addTestSuite(NewOrderNotificationTest.class);
		suite.addTestSuite(OrderStateChangeNotificationTest.class);
		suite.addTestSuite(RefundAmountNotificationTest.class);
		suite.addTestSuite(RiskInformationNotificationTest.class);
		
		
		
		return suite;
	}

}
