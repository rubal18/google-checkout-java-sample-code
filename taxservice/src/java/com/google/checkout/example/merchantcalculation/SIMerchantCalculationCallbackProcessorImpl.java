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

package com.google.checkout.example.merchantcalculation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

import com.google.checkout.CheckoutException;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.Item;
import com.google.checkout.merchantcalculation.AnonymousAddress;
import com.google.checkout.merchantcalculation.CouponResult;
import com.google.checkout.merchantcalculation.MerchantCalculationCallback;
import com.google.checkout.merchantcalculation.MerchantCalculationCallbackProcessor;
import com.google.checkout.merchantcalculation.MerchantCalculationResults;
import com.google.checkout.merchantcalculation.MerchantCodeString;

import com.strikeiron.ws.taxdatabasic.*;
import com.google.api.checkout.strikeiron.*;

/**
 * A simple, example implementation of the MerchantCalculationCallbackProcessor
 * interface.
 * 
 * @author simonjsmith
 * 
 * @see MerchantCalculationCallbackProcessor
 */
public class SIMerchantCalculationCallbackProcessorImpl implements
		MerchantCalculationCallbackProcessor {

	MerchantConstants merchantConstants;
	private static TaxServiceUser siService = SIMerchantCalculationCallbackProcessorImpl.getSIService();
	
	//TODO: ideally you would make that part of MerchantConstants and implement the lookup in MerchantConstantsFactory 
	private static TaxServiceUser getSIService() {
		ResourceBundle bundle = ResourceBundle.getBundle("com_google_checkout_si_settings");
		String userid = bundle.getString("userid");
		String password = bundle.getString("password");
	    return new TaxServiceUser(userid, password);
	}
	
	/**
	 * Constructor which takes an instance of MerchantConstants.
	 * 
	 * @param merchantConstants
	 *            The MerchantConstants.
	 * 
	 * @see MerchantConstants
	 */
	public SIMerchantCalculationCallbackProcessorImpl(
			MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.checkout.merchantcalculation.MerchantCalculationCallbackProcessor#process(com.google.checkout.merchantcalculation.MerchantCalculationCallback)
	 */
	public MerchantCalculationResults process(
			MerchantCalculationCallback callback) throws CheckoutException {

		Iterator addresses = callback.getAnonymousAddresses().iterator();
		Iterator shippingMethods;
		Iterator merchantCodes;
		Iterator items;

		MerchantCalculationResults results = new MerchantCalculationResults();
		AnonymousAddress address;
		String shipping;
		MerchantCodeString code;
		Item item;

		while (addresses.hasNext()) {
			address = (AnonymousAddress) addresses.next();
			//compute the taxes if required, using strikeiron tax service
			double tax = 0.0d;
			if (callback.isCalculateTax()) {
				double rate = getTaxRate(address.getPostalCode());
				items = callback.getItems().iterator();
				while (items.hasNext()) {
					item = (Item)items.next();
					tax =+ rate * item.getUnitPriceAmount() * item.getQuantity();
				}
			}

			shippingMethods = callback.getShippingMethods().iterator();
			while (shippingMethods.hasNext()) {
				shipping = (String) shippingMethods.next();

				merchantCodes = callback.getMerchantCodes().iterator();
				Collection codeResults = new ArrayList();
				while (merchantCodes.hasNext()) {
					code = (MerchantCodeString) merchantCodes.next();
					CouponResult coupon = new CouponResult(false, 0.0f,
							merchantConstants.getCurrencyCode(),
							code.getCode(), "Not supported in this example.");
					codeResults.add(coupon);
				}

				results.addResult(shipping, address.getId(), true, tax, 0.0d,
						merchantConstants.getCurrencyCode(), codeResults);
			}
		}
		return results;
	}

	public static double getTaxRate(String zipcode) {
		//this is a dummy implementation to demonstrate the plumbing of calling strikeiron tax calculation service
		//a real life implementation would cache the results for 30 days,
		//provide a default tax table if the service is down
		//and use all the data available in TaxRateUSAData
		try {
		    TaxDataBasicSoap s = siService.getTaxService();
		    TaxRateUSAData rate = s.getTaxRateUS(zipcode);
		    return rate.getTotal_sales_tax();
		} catch (Exception e) {
			//log the Exception, and use default tax tables
			return 0.0d;
		}
	}
	
}
