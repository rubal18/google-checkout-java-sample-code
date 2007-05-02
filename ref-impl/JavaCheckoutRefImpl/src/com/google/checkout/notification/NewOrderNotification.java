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

package com.google.checkout.notification;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.checkout.Item;
import com.google.checkout.util.Utils;

public class NewOrderNotification extends CheckoutNotification {

	private Document document;

	private Element root;

	/**
	 * A constructor which takes the request as a String.
	 * 
	 * @param requestString
	 */
	public NewOrderNotification(String requestString) {
		document = Utils.newDocumentFromString(requestString);
		root = document.getDocumentElement();
	}

	/**
	 * A constructor which takes the request as an InputStream.
	 * 
	 * @param inputStream
	 */
	public NewOrderNotification(InputStream inputStream) {
		document = Utils.newDocumentFromInputStream(inputStream);
		root = document.getDocumentElement();
	}

	/**
	 * Retrieves the contents of the &lt;items&gt; element as a Colection of
	 * Item objects.
	 * 
	 * @return The Collection of Item objects.
	 * 
	 * @see Item
	 */
	public Collection getItems() {
		Element shoppingCart = Utils.findElementOrContainer(document, root,
				"shopping-cart");
		Element items = Utils.findElementOrContainer(document, shoppingCart,
				"items");
		Element[] elements = Utils.getElements(document, items);
		Collection ret = new ArrayList();

		for (int i = 0; i < elements.length; i++) {
			ret.add(new Item(document, elements[i]));
		}

		return ret;
	}

	/**
	 * Retrieves the contents of the &lt;merchant-private-data&gt; element as an
	 * array of Elements.
	 * 
	 * @return The contents &lt;merchant-private-data&gt; element value.
	 * 
	 * @see Element
	 */
	public Element[] getMerchantPrivateDataNodes() {
		Element shoppingCart = Utils.findContainerElseCreate(document, root,
				"shopping-cart");
		Element mpd = Utils.findElementOrContainer(document, shoppingCart,
				"merchant-private-data");
		if (mpd == null) {
			return null;
		}
		return Utils.getElements(document, mpd);
	}

	/**
	 * Retrieves the value of the &lt;good-until-date&gt; element.
	 * 
	 * @return The cart expiration.
	 * 
	 * @see Date
	 */
	public Date getCartExpiration() {
		Element shoppingCart = Utils.findContainerElseCreate(document, root,
				"shopping-cart");
		Element cartExpiration = Utils.findContainerElseCreate(document,
				shoppingCart, "cart-expiration");

		return Utils.getElementDateValue(document, cartExpiration,
				"good-until-date");
	}

	/**
	 * Return the Google Order Number for this notification.
	 * 
	 * @return The Google Order Number.
	 */
	public String getGoogleOrderNo() {
		return Utils.getElementStringValue(document, root,
				"google-order-number");
	}

	public Address getBuyerShippingAddress() {
		Element address = Utils.findElementOrContainer(document, root, "buyer-shipping-address");
		return new Address(document, address);
	}

	public Address getBuyerBillingAddress() {
		Element address = Utils.findElementOrContainer(document, root, "buyer-billing-address");
		return new Address(document, address);
	}

	public boolean isMarketingEmailAllowed() {
		Element buyerMarketingPreferences = Utils.findElementOrContainer(
				document, root, "buyer-marketing-preferences");
		return Utils.getElementBooleanValue(document,
				buyerMarketingPreferences, "email-allowed");
	}

	public boolean isMerchantCalculationSuccessful() {
		Element orderAdjustment = Utils.findElementOrContainer(document, root,
				"order-adjustment");
		return Utils.getElementBooleanValue(document, orderAdjustment,
				"merchant-calculation-successful");
	}

	public Collection getMerchantCodes() {
		// TODO
		throw new RuntimeException("not impl");
	}

	public double getTotalTax() {
		Element orderAdjustment = Utils.findElementOrContainer(document, root,
				"order-adjustment");
		return Utils.getElementFloatValue(document, orderAdjustment,
				"total-tax");
	}

	public double getAdjustmentTotal() {
		Element orderAdjustment = Utils.findElementOrContainer(document, root,
				"order-adjustment");
		return Utils.getElementFloatValue(document, orderAdjustment,
				"adjustment-total");
	}

	public Shipping getShipping() {
		// TODO
		throw new RuntimeException("not impl");
	}

	public double getOrderTotal() {
		return Utils.getElementFloatValue(document, root, "order-total");
	}

	public String getOrderCurrencyCode() {
		return Utils.findElementOrContainer(document, root, "order-total")
				.getAttribute("currency");
	}

	public FulfillmentOrderState getFulfillmentOrderState() {
		String state = Utils.getElementStringValue(document, root,
				"fulfillment-order-state");
		return FulfillmentOrderState.getState(state);
	}

	public FinancialOrderState getFinancialOrderState() {
		String state = Utils.getElementStringValue(document, root,
				"financial-order-state");
		return FinancialOrderState.getState(state);
	}

	public long getBuyerId() {
		return Utils.getElementLongValue(document, root, "buyer-id");
	}

}
