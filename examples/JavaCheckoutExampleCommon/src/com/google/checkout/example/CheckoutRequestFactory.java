/*******************************************************************************
 * Copyright (C) 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.google.checkout.example;

import java.util.ResourceBundle;

import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.CheckoutShoppingCartRequest;
import com.google.checkout.checkout.CheckoutShoppingCartRequestImpl;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.TaxArea;
import com.google.checkout.example.merchantcalculation.CallbackProcessorImpl;
import com.google.checkout.example.notification.AuthorizationNotificationProcessorImpl;
import com.google.checkout.example.notification.ChargeNotificationProcessorImpl;
import com.google.checkout.example.notification.ChargebackNotificationProcessorImpl;
import com.google.checkout.example.notification.NewOrderNotificationProcessorImpl;
import com.google.checkout.example.notification.OrderStateChangeNotificationProcessorImpl;
import com.google.checkout.example.notification.RefundNotificationProcessorImpl;
import com.google.checkout.example.notification.RiskInformationNotificationProcessorImpl;
import com.google.checkout.merchantcalculation.CallbackProcessor;
import com.google.checkout.notification.AuthorizationNotificationProcessor;
import com.google.checkout.notification.ChargeNotificationProcessor;
import com.google.checkout.notification.ChargebackNotificationProcessor;
import com.google.checkout.notification.NewOrderNotificationProcessor;
import com.google.checkout.notification.OrderStateChangeNotificationProcessor;
import com.google.checkout.notification.RefundNotificationProcessor;
import com.google.checkout.notification.RiskInformationNotificationProcessor;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;
import com.google.checkout.orderprocessing.AddMerchantOrderNumberRequest;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;
import com.google.checkout.orderprocessing.AddTrackingDataRequest;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;
import com.google.checkout.orderprocessing.ArchiveOrderRequest;
import com.google.checkout.orderprocessing.AuthorizeOrderRequest;
import com.google.checkout.orderprocessing.AuthorizeOrderRequest;
import com.google.checkout.orderprocessing.CancelOrderRequest;
import com.google.checkout.orderprocessing.CancelOrderRequest;
import com.google.checkout.orderprocessing.ChargeOrderRequest;
import com.google.checkout.orderprocessing.ChargeOrderRequest;
import com.google.checkout.orderprocessing.DeliverOrderRequest;
import com.google.checkout.orderprocessing.DeliverOrderRequest;
import com.google.checkout.orderprocessing.ProcessOrderRequest;
import com.google.checkout.orderprocessing.ProcessOrderRequest;
import com.google.checkout.orderprocessing.RefundOrderRequest;
import com.google.checkout.orderprocessing.RefundOrderRequest;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;
import com.google.checkout.orderprocessing.SendBuyerMessageRequest;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;
import com.google.checkout.orderprocessing.UnarchiveOrderRequest;

public class CheckoutRequestFactory {

	private static MerchantConstants mc;
	
	public static MerchantConstants getMerchantConstants() {
		if (mc == null) {
			ResourceBundle bundle = ResourceBundle.getBundle("com_google_checkout_example_settings");
			String merchantId = bundle.getString("merchantid");
			String merchantKey = bundle.getString("merchantkey");
			String env = bundle.getString("env");
			String currencyCode = bundle.getString("currencycode");

      String sandboxRoot = bundle.getString("sandbox.root");
      String prodRoot = bundle.getString("prod.root");
      String checkoutSuffix = bundle.getString("checkout.suffix");
      String merchantCheckoutSuffix = bundle.getString("merchantCheckout.suffix");
      String requestSuffix  = bundle.getString("request.suffix");

      String checkoutUrl = "";
      String merchantCheckoutUrl = ""; 
      String requestUrl = "";      
 
      if (EnvironmentType.Sandbox.equals(env)) {
         checkoutUrl = sandboxRoot + "/" + merchantId + "/" + checkoutSuffix;
         merchantCheckoutUrl = sandboxRoot + "/" + merchantId + "/" + merchantCheckoutSuffix;
         requestUrl = sandboxRoot + "/" + merchantId + "/" + requestSuffix;
      }
      else if (EnvironmentType.Production.equals(env)) {
        checkoutUrl = prodRoot + "/" + merchantId + "/" + checkoutSuffix;
        merchantCheckoutUrl = prodRoot + "/" + merchantId + "/" + merchantCheckoutSuffix;
        requestUrl = prodRoot + "/" + merchantId + "/" + requestSuffix;        
      }
      else {
        throw new RuntimeException("Env must be one of "+EnvironmentType.Sandbox+" or "+EnvironmentType.Production+".");
      }

      mc = new MerchantConstants(merchantId, merchantKey, env, currencyCode, checkoutUrl, merchantCheckoutUrl, requestUrl);    		
		}
		return mc;
	}
	
	
    public static CheckoutShoppingCartRequest newCheckoutShoppingCartRequest() {
    	return new CheckoutShoppingCartRequestImpl(getMerchantConstants());
    }

    public static ShippingRestrictions newShippingRestrictions() {
    	return new ShippingRestrictions();
    }

    public static TaxArea newTaxArea() {
    	return new TaxArea();
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
    	return new AddMerchantOrderNumberRequest(getMerchantConstants());
    }
    
    public static AddTrackingDataRequest newAddTrackingDataRequest() {
    	return new AddTrackingDataRequest(getMerchantConstants());
    }
    
    public static ArchiveOrderRequest newArchiveOrderRequest() {
    	return new ArchiveOrderRequest(getMerchantConstants());
    }
    
    public static AuthorizeOrderRequest newAuthorizeOrderRequest() {
    	return new AuthorizeOrderRequest(getMerchantConstants());
    }
    
    public static CancelOrderRequest newCancelOrderRequest() {
    	return new CancelOrderRequest(getMerchantConstants());
    }
    
    public static ChargeOrderRequest newChargeOrderRequest() {
    	return new ChargeOrderRequest(getMerchantConstants());
    }
    
    public static DeliverOrderRequest newDeliverOrderRequest() {
    	return new DeliverOrderRequest(getMerchantConstants());
    }
    
    public static ProcessOrderRequest newProcessOrderRequest() {
    	return new ProcessOrderRequest(getMerchantConstants());
    }
    
    public static RefundOrderRequest newRefundOrderRequest() {
    	return new RefundOrderRequest(getMerchantConstants());
    }
    
    public static SendBuyerMessageRequest newSendBuyerMessageRequest() {
    	return new SendBuyerMessageRequest(getMerchantConstants());
    }
    
    public static UnarchiveOrderRequest newUnarchiveOrderRequest() {
    	return new UnarchiveOrderRequest(getMerchantConstants());
    }

	public static AuthorizationNotificationProcessor newAuthorizationNotificationProcessor() {
		return new AuthorizationNotificationProcessorImpl(getMerchantConstants());
	}
}
