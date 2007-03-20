package com.google.checkout.example;


import java.util.ResourceBundle;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.CheckoutShoppingCartRequest;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.impl.CheckoutShoppingCartRequestImpl;
import com.google.checkout.checkout.impl.MerchantConstantsImpl;
import com.google.checkout.checkout.impl.ShippingRestrictionsImpl;
import com.google.checkout.checkout.impl.TaxAreaImpl;
import com.google.checkout.example.merchantcalculation.CallbackProcessorImpl;
import com.google.checkout.merchantcalculation.CallbackProcessor;
import com.google.checkout.notification.AuthorizationNotificationProcessor;
import com.google.checkout.notification.ChargeNotificationProcessor;
import com.google.checkout.notification.ChargebackNotificationProcessor;
import com.google.checkout.notification.NewOrderNotificationProcessor;
import com.google.checkout.notification.OrderStateChangeNotificationProcessor;
import com.google.checkout.notification.RefundNotificationProcessor;
import com.google.checkout.notification.RiskInformationNotificationProcessor;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;
import com.google.checkout.orderprocessing.AuthorizeOrderRequest;
import com.google.checkout.orderprocessing.CancelOrderRequest;
import com.google.checkout.orderprocessing.ChargeOrderRequest;
import com.google.checkout.orderprocessing.DeliverOrderRequest;
import com.google.checkout.orderprocessing.ProcessOrderRequest;
import com.google.checkout.orderprocessing.RefundOrderRequest;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;
import com.google.checkout.orderprocessing.impl.AddMerchantOrderNumberRequestImpl;
import com.google.checkout.orderprocessing.impl.AddTrackingDataRequestImpl;
import com.google.checkout.orderprocessing.impl.ArchiveOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.AuthorizeOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.CancelOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.ChargeOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.DeliverOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.ProcessOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.RefundOrderRequestImpl;
import com.google.checkout.orderprocessing.impl.SendBuyerMessageRequestImpl;
import com.google.checkout.orderprocessing.impl.UnarchiveOrderRequestImpl;
import com.google.checkout.webappexample.notification.AuthorizationNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.ChargeNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.ChargebackNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.NewOrderNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.OrderStateChangeNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.RefundNotificationProcessorImpl;
import com.google.checkout.webappexample.notification.RiskInformationNotificationProcessorImpl;

public class CheckoutRequestFactory {

	private static MerchantConstants mc;
	
	public static MerchantConstants getMerchantConstants() {
		if (mc == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("com_google_checkout_settings");
			String merchantId = bundle.getString("MerchantId");
			String merchantKey = bundle.getString("MerchantKey");
			String env = bundle.getString("Env");
			String currencyCode = bundle.getString("CurrencyCode");
			
			mc = new MerchantConstantsImpl(merchantId, merchantKey, env, currencyCode, "baseCheckoutUrl", "baseRequestUrl");    		
		}
		return mc;
	}
	
	
    public static CheckoutShoppingCartRequest newCheckoutShoppingCartRequest() {
    	return new CheckoutShoppingCartRequestImpl(getMerchantConstants());
    }

    public static ShippingRestrictions newShippingRestrictions() {
    	return new ShippingRestrictionsImpl();
    }

    public static TaxArea newTaxArea() {
    	return new TaxAreaImpl();
    }

    public static CallbackProcessor newCallbackProcessor() {
    	return new CallbackProcessorImpl(getMerchantConstants());
    }
    
    public static ChargebackNotificationProcessor newChargeBackNotificationProcessor() {
    	return new ChargebackNotificationProcessorImpl(getMerchantConstants());
    }
    
    public static ChargeNotificationProcessor newChargeNotificationProcessor() {
    	return new ChargeNotificationProcessorImpl(getMerchantConstants());
    }
    
    public static NewOrderNotificationProcessor newNewOrderNotificationProcessor() {
    	return new NewOrderNotificationProcessorImpl(getMerchantConstants());
    }
    
    public static OrderStateChangeNotificationProcessor newOrderStateChangeNotificationProcessor() {
    	return new OrderStateChangeNotificationProcessorImpl(getMerchantConstants());
    }
  
    public static RefundNotificationProcessor newRefundNotificationProcessor() {
    	return new RefundNotificationProcessorImpl(getMerchantConstants());
    }
    
    public static RiskInformationNotificationProcessor newRiskInformationNotificationProcessor() {
    	return new RiskInformationNotificationProcessorImpl(getMerchantConstants());
    }

    public static AddMerchantOrderNumberRequest newAddMerchantOrderNumberRequest() {
    	return new AddMerchantOrderNumberRequestImpl(getMerchantConstants());
    }
    
    public static AddTrackingDataRequest newAddTrackingDataRequest() {
    	return new AddTrackingDataRequestImpl(getMerchantConstants());
    }
    
    public static ArchiveOrderRequest newArchiveOrderRequest() {
    	return new ArchiveOrderRequestImpl(getMerchantConstants());
    }
    
    public static AuthorizeOrderRequest newAuthorizeOrderRequest() {
    	return new AuthorizeOrderRequestImpl(getMerchantConstants());
    }
    
    public static CancelOrderRequest newCancelOrderRequest() {
    	return new CancelOrderRequestImpl(getMerchantConstants());
    }
    
    public static ChargeOrderRequest newChargeOrderRequest() {
    	return new ChargeOrderRequestImpl(getMerchantConstants());
    }
    
    public static DeliverOrderRequest newDeliverOrderRequest() {
    	return new DeliverOrderRequestImpl(getMerchantConstants());
    }
    
    public static ProcessOrderRequest newProcessOrderRequest() {
    	return new ProcessOrderRequestImpl(getMerchantConstants());
    }
    
    public static RefundOrderRequest newRefundOrderRequest() {
    	return new RefundOrderRequestImpl(getMerchantConstants());
    }
    
    public static SendBuyerMessageRequest newSendBuyerMessageRequest() {
    	return new SendBuyerMessageRequestImpl(getMerchantConstants());
    }
    
    public static UnarchiveOrderRequest newUnarchiveOrderRequest() {
    	return new UnarchiveOrderRequestImpl(getMerchantConstants());
    }

	public static AuthorizationNotificationProcessor newAuthorizationNotificationProcessor() {
		return new AuthorizationNotificationProcessorImpl(getMerchantConstants());
	}
}
