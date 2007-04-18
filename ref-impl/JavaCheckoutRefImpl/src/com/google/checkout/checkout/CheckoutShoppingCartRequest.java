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

package com.google.checkout.checkout;

import java.util.Collection;
import java.util.Date;

import org.w3c.dom.Element;

/**
 * Class used to create the structure needed by Google Checkout The class also
 * has the ability to send that request to Google or return the Xml needed to
 * place in the hidden form fields.
 * 
 * @author simonjsmith@google.com
 */
public interface CheckoutShoppingCartRequest {

  /**
   * This method adds an item to an order. This method handles items that do not
   * have &lt;merchant-private-item-data&gt; XML blocks associated with them.
   * 
   * @param name
   *          The name of the item. This value corresponds to the value of the
   *          &lt;item-name&gt; tag in the Checkout API request.
   * 
   * @param description
   *          The description of the item. This value corresponds to the value
   *          of the &lt;item-description&gt; tag in the Checkout API request.
   * 
   * @param price
   *          The price of the item. This value corresponds to the value of the
   *          &lt;unit-price&gt; tag in the Checkout API request.</param>
   * 
   * @param quantity
   *          The number of this item that is included in the order. This value
   *          corresponds to the value of the &lt;quantity&gt; tag in the
   *          Checkout API request.
   */
  public void addItem(String name, String description, float price, int quantity);

  /**
   * This method adds an item to an order. This method handles items that do not
   * have &lt;merchant-private-item-data&gt; XML blocks associated with them.
   * 
   * @param name
   *          The name of the item. This value corresponds to the value of the
   *          &lt;item-name&gt; tag in the Checkout API request.
   * 
   * @param description
   *          The description of the item. This value corresponds to the value
   *          of the &lt;item-description&gt; tag in the Checkout API request.
   * 
   * @param price
   *          The price of the item. This value corresponds to the value of the
   *          &lt;unit-price&gt; tag in the Checkout API request.</param>
   * 
   * @param quantity
   *          The number of this item that is included in the order. This value
   *          corresponds to the value of the &lt;quantity&gt; tag in the
   *          Checkout API request.
   * 
   * @param merchantItemID
   *          The Merchant Item Id that uniquely identifies the product in your
   *          system. This value corresponds to the value of the
   *          &lt;merchant-item-id&gt; tag in the Checkout API request.
   */
  public void addItem(String name, String description, float price,
      int quantity, String merchantItemID);

  /**
   * This method adds an item to an order. This method handles items that have
   * &lt;merchant-private-item-data&gt; XML blocks associated with them.
   * 
   * @param name
   *          The name of the item. This value corresponds to the value of the
   *          &lt;item-name&gt; tag in the Checkout API request.
   * 
   * @param description
   *          The description of the item. This value corresponds to the value
   *          of the &lt;item-description&gt; tag in the Checkout API request.
   * 
   * @param price
   *          The price of the item. This value corresponds to the value of the
   *          &lt;unit-price&gt; tag in the Checkout API request.</param>
   * 
   * @param quantity
   *          The number of this item that is included in the order. This value
   *          corresponds to the value of the &lt;quantity&gt; tag in the
   *          Checkout API request.
   * 
   * @param merchantPrivateItemData
   *          An array of XML nodes that should be associated with the item in
   *          the Checkout API request. This value corresponds to the value of
   *          the value of the &lt;merchant-private-item-data&gt; tag in the
   *          Checkout API request.
   */
  public void addItem(String name, String description, float price,
      int quantity, Element[] merchantPrivateItemData);

  /**
   * This method adds an item to an order. This method handles items that have
   * &lt;merchant-private-item-data&gt; XML blocks associated with them.
   * 
   * @param name
   *          The name of the item. This value corresponds to the value of the
   *          &lt;item-name&gt; tag in the Checkout API request.
   * 
   * @param description
   *          The description of the item. This value corresponds to the value
   *          of the &lt;item-description&gt; tag in the Checkout API request.
   * 
   * @param price
   *          The price of the item. This value corresponds to the value of the
   *          &lt;unit-price&gt; tag in the Checkout API request.</param>
   * 
   * @param quantity
   *          The number of this item that is included in the order. This value
   *          corresponds to the value of the &lt;quantity&gt; tag in the
   *          Checkout API request.
   * 
   * @param merchantItemID
   *          The Merchant Item Id that uniquely identifies the product in your
   *          system. This value corresponds to the value of the
   *          &lt;merchant-item-id&gt; tag in the Checkout API request.
   * 
   * @param merchantPrivateItemData
   *          An array of XML nodes that should be associated with the item in
   *          the Checkout API request. This value corresponds to the value of
   *          the value of the &lt;merchant-private-item-data&gt; tag in the
   *          Checkout API request.
   * 
   * @param taxTableSelector
   *          The name of the alternate tax table that should be used to
   *          calculate tax for the item. This value corresponds to the value of
   *          the value of the &lt;tax-table-selector&gt; tag in the Checkout
   *          API request.
   * 
   */
  public void addItem(String name, String description, float price,
      int quantity, String merchantItemID, Element[] merchantPrivateItemData,
      String taxTableSelector);

  /**
   * This method adds a flat-rate shipping method to an order. This method
   * handles flat-rate shipping methods that do not have shipping restrictions.
   * 
   * @param name
   *          The name of the shipping method. This value will be displayed on
   *          the Google Checkout order review page.
   * 
   * @param cost
   *          The cost associated with the shipping method.
   */
  public void addFlatRateShippingMethod(String name, float cost);

  /**
   * This method adds a flat-rate shipping method to an order. This method
   * handles flat-rate shipping methods that have shipping restrictions.
   * 
   * @param name
   *          The name of the shipping method. This value will be displayed on
   *          the Google Checkout order review page.
   * 
   * @param cost
   *          The cost associated with the shipping method.
   * 
   * @param restrictions
   *          A list of country, state or zip code areas where the shipping
   *          method is either available or unavailable.
   * 
   * @see ShippingRestrictions
   */
  public void addFlatRateShippingMethod(String name, float cost,
      ShippingRestrictions restrictions);

  /**
   * This method adds a merchant-calculated shipping method to an order. This
   * method handles merchant-calculated shipping methods that do not have
   * shipping restrictions.
   * 
   * @param name
   *          The name of the shipping method. This value will be displayed on
   *          the Google Checkout order review page.
   * 
   * @param defaultCost
   *          The default cost associated with the shipping method. This value
   *          is the amount that Gogle Checkout will charge for shipping if the
   *          merchant calculation callback request fails.
   */
  public void addMerchantCalculatedShippingMethod(String name, float defaultCost);

  /**
   * This method adds a merchant-calculated shipping method to an order. This
   * method handles merchant-calculated shipping methods that have shipping
   * restrictions.
   * 
   * @param name
   *          The name of the shipping method. This value will be displayed on
   *          the Google Checkout order review page.
   * 
   * @param defaultCost
   *          The default cost associated with the shipping method. This value
   *          is the amount that Gogle Checkout will charge for shipping if the
   *          merchant calculation callback request fails.
   * @param restrictions
   *          A list of country, state or zip code areas where the shipping
   *          method is either available or unavailable.
   * 
   * @see ShippingRestrictions
   */
  public void addMerchantCalculatedShippingMethod(String name,
      float defaultCost, ShippingRestrictions restrictions);

  /**
   * This method adds an instore-pickup shipping option to an order.
   * 
   * @param name
   *          The name of the shipping method. This value will be displayed on
   *          the Google Checkout order review page.
   * 
   * @param cost
   *          The cost associated with the shipping method.
   */
  public void addPickupShippingMethod(String name, float cost);

  /**
   * Add a URL which has already been URL encoded to the
   * &lt;parameterized-urls&gt; collection. These tags are used to support third
   * party conversion tracking.
   * 
   * @param url
   *          The UrlEncoded &lt;parameterized-url&gt; to add to the collection.
   */
  public void addParameterizedUrl(String url);

  /**
   * Add a URL to the &lt;parameterized-urls&gt; collection. These tags are used
   * to support third party conversion tracking.
   * 
   * @param url
   *          The UrlEncoded &lt;parameterized-url&gt; to add to the collection.
   * 
   * @param urlEncode
   *          Set to true if you need the url to be URL encoded.
   */
  public void addParameterizedUrl(String url, boolean urlEncode);

  /**
   * Add a collection of URLs which have already been URL encoded to the
   * &lt;parameterized-urls&gt; collection. These tags are used to support third
   * party conversion tracking.
   * 
   * @param url
   *          The UrlEncoded &lt;parameterized-url&gt; to add to the collection.
   * 
   * @param parameters
   *          A collection of UrlParameter objects which define the parameters
   *          to be added to the URL.
   * 
   * @see UrlParameter
   */
  public void addParameterizedUrl(String url, Collection parameters);

  /**
   * Add a collection of URLs to the &lt;parameterized-urls&gt; collection.
   * These tags are used to support third party conversion tracking.
   * 
   * @param url
   *          The UrlEncoded &lt;parameterized-url&gt; to add to the collection.
   * 
   * @param urlEncode
   *          Set to true if you need the url to be URL encoded.
   * 
   * @param parameters
   *          A collection of UrlParameter objects which define the parameters
   *          to be added to the URL.
   * 
   * @see UrlParameter
   */
  public void addParameterizedUrl(String url, boolean urlEncode,
      Collection parameters);

  /**
   * This method creates a new &lt;default-tax-rule&gt;.
   * 
   * @param taxRate
   *          The tax rate to be applied.
   * @param shippingTaxed
   *          Whether the shipping is taxed or not.
   * @param taxArea
   *          The TaxArea for which this rule applies.
   * 
   * @see TaxArea
   */
  public void addDefaultTaxRule(double taxRate, boolean shippingTaxed,
      TaxArea taxArea);

  /**
   * This method creates a new &lt;alternate-tax-rule&gt;.
   * 
   * @param tableName
   *          The name for the tax table.
   * @param standalone
   *          The standalone attribute indicates how taxes should be calculated
   *          if there is no matching alternate-tax-rule for the given state,
   *          zip code or country area. If this attribute's value is TRUE and
   *          there is no matching alternate-tax-rule, the tax amount will be
   *          zero. If the attribute's value is FALSE and there is no matching
   *          alternate-tax-rule, the tax amount will be calculated using the
   *          default tax table.
   * @param taxRate
   *          The tax rate to be applied.
   * @param taxArea
   *          The TaxArea for which this rule applies.
   * 
   * @see TaxArea
   */
  public void addAlternateTaxRule(String tableName, boolean standalone,
      double taxRate, TaxArea taxArea);

  /**
   * This method adds an Xml node to the &lt;merchant-private-data&gt; element.
   * 
   * @param node
   *          The &lt;merchant-private-data&gt; element.
   */
  public void addMerchantPrivateDataNode(Element node);

  /**
   * This method sets the value of the &lt;good-until-date&gt; using the value
   * of the <b>cartExpirationMinutes</b> parameter. This method converts that
   * value into Coordinated Universal Time (UTC).
   * 
   * @param expirationMinutesFromNow
   *          The length of time, in minutes, after which the shopping cart
   *          should expire.
   */
  public void setExpirationMinutesFromNow(int expirationMinutesFromNow);

  /**
   * Retrieves the value that indicates whether the merchant is responsible for
   * calculating taxes for the default tax table.
   * 
   * @return The value of this property should be <b>true</b> if the merchant
   *         will calculate taxes for the order. Otherwise, this value should be
   *         <b>false</b>. The value should only be <b>true</b> if the
   *         merchant has implemented the Merchant Calculations API. </value>
   */
  public boolean isMerchantCalculatedTax();

  /**
   * Sets the value that indicates whether the merchant is responsible for
   * calculating taxes for the default tax table.
   * 
   * @param b
   *          The value of this property should be <b>true</b> if the merchant
   *          will calculate taxes for the order. Otherwise, this value should
   *          be <b>false</b>. The value should only be <b>true</b> if the
   *          merchant has implemented the Merchant Calculations API. </value>
   */
  public void setMerchantCalculatedTax(boolean b);

  /**
   * Retrieves the value that indicates whether the merchant accepts coupons. If
   * this value is set to <b>true</b>, the Google Checkout order confirmation
   * page will display a text field where the customer can enter a coupon code.
   * 
   * This value of this property is a Boolean value that indicates whether the
   * merchant accepts coupons. This value should only be set to <b>true</b> if
   * the merchant has implemented the Merchant Calculations API.
   * 
   * @return The boolean value.
   */
  public boolean isAcceptMerchantCoupons();

  /**
   * Sets the value that indicates whether the merchant accepts coupons. If this
   * value is set to <b>true</b>, the Google Checkout order confirmation page
   * will display a text field where the customer can enter a coupon code.
   * 
   * This value of this property is a Boolean value that indicates whether the
   * merchant accepts coupons. This value should only be set to <b>true</b> if
   * the merchant has implemented the Merchant Calculations API.
   * 
   * @param b
   *          The boolean value.
   */
  public void setAcceptMerchantCoupons(boolean b);

  /**
   * Retrieves the value that indicates whether the merchant accepts gift
   * certificates. If this value is set to <b>true</b>, the Google Checkout
   * order confirmation page will display a text field where the customer can
   * enter a gift certificate code.
   * 
   * This value of this property is a Boolean value that indicates whether the
   * merchant accepts gift certificates. This value should only be set to
   * <b>true</b> if the merchant has implemented the Merchant Calculations API.
   * 
   * @return The boolean value.
   */
  public boolean isAcceptMerchantGiftCertificates();

  /**
   * Sets the value that indicates whether the merchant accepts gift
   * certificates. If this value is set to <b>true</b>, the Google Checkout
   * order confirmation page will display a text field where the customer can
   * enter a gift certificate code.
   * 
   * This value of this property is a Boolean value that indicates whether the
   * merchant accepts gift certificates. This value should only be set to
   * <b>true</b> if the merchant has implemented the Merchant Calculations API.
   * 
   * @param b
   *          The boolean value.
   */
  public void setAcceptMerchantGiftCertificates(boolean b);

  /**
   * Retrieves the value of the &lt;merchant-calculations-url&gt; element. This
   * value is the URL to which Google Checkout will send
   * &lt;merchant-calculation-callback&gt; requests. This property is only
   * relevant for merchants who are implementing the Merchant Calculations API.
   * 
   * @return The &lt;merchant-calculations-url&gt; element value.
   */
  public String getMerchantCalculationsUrl();

  /**
   * Sets the value of the &lt;merchant-calculations-url&gt; element. This value
   * is the URL to which Google Checkout will send
   * &lt;merchant-calculation-callback&gt; requests. This property is only
   * relevant for merchants who are implementing the Merchant Calculations API.
   * 
   * @param url
   *          The &lt;merchant-calculations-url&gt; element value.
   */
  public void setMerchantCalculationsUrl(String url);

  /**
   * Retrieves the contents of the &lt;merchant-private-data&gt; element as an
   * array of Elements.
   * 
   * @return The contents &lt;merchant-private-data&gt; element value.
   * 
   * @see Element
   */
  public Element[] getMerchantPrivateDataNodes();

  /**
   * Sets the contents of the &lt;merchant-private-data&gt; element.
   * 
   * @param nodes
   *          The &lt;merchant-private-data&gt; element value.
   * 
   * @see Element
   */
  public void setMerchantPrivateDataNodes(Element[] nodes);

  /**
   * Retrieves the value of the &lt;continue-shopping-url&gt; element. Google
   * Checkout will display a link to this URL on the page that the customer sees
   * after completing her purchase.
   * 
   * @return The &lt;continue-shopping-url&gt; element value.
   */
  public String getContinueShoppingUrl();

  /**
   * Sets the value of the &lt;continue-shopping-url&gt; element. Google
   * Checkout will display a link to this URL on the page that the customer sees
   * after completing her purchase.
   * 
   * @param url
   *          The &lt;continue-shopping-url&gt; element value.
   */
  public void setContinueShoppingUrl(String url);

  /**
   * Retrieves the value of the &lt;edit-cart-url&gt; element. Google Checkout
   * will display a link to this URL on the Google Checkout order confirmation
   * page. The customer can click this link to edit the shopping cart contents
   * before completing a purchase.
   * 
   * @return The &lt;edit-cart-url&gt; element value.
   */
  public String getEditCartUrl();

  /**
   * Sets the value of the &lt;edit-cart-url&gt; element. Google Checkout will
   * display a link to this URL on the Google Checkout order confirmation page.
   * The customer can click this link to edit the shopping cart contents before
   * completing a purchase.
   * 
   * @param url
   *          The &lt;edit-cart-url&gt; element value.
   */
  public void setEditCartUrl(String url);

  /**
   * Retrieves the value of the &lt;request-buyer-phone-number&gt; element. If
   * this value is true, the buyer must enter a phone number to complete a
   * purchase.
   * 
   * @return <c>true</c> if the Google should send the buyer's phone number to
   *         the merchant, otherwise <c>false</c>.
   */
  public boolean isRequestBuyerPhoneNumber();

  /**
   * Sets the value of the &lt;request-buyer-phone-number&gt; element. If this
   * value is true, the buyer must enter a phone number to complete a purchase.
   * 
   * @param b
   *          <c>true</c> if the Google should send the buyer's phone number to
   *          the merchant, otherwise <c>false</c>.
   */
  public void setRequestBuyerPhoneNumber(boolean b);

  /**
   * Retrieves the value of the &lt;good-until-date&gt; element.
   * 
   * @return The cart expiration.
   * 
   * @see Date
   */
  public Date getCartExpiration();

  /**
   * Sets the value of the &lt;good-until-date&gt; element.
   * 
   * @param date
   *          The cart expiration.
   * 
   * @see Date
   */
  public void setCartExpiration(Date date);

  /**
   * Retrieves the value of the &lt;analytics-data&gt; element. Google Analytics
   * uses this to Track Google Checkout Orders.
   * 
   * Please read
   * http://code.google.com/apis/checkout/developer/checkout_analytics_integration.html"
   * for more information.
   * 
   * @return The &lt;analytics-data&gt; element value.
   */
  public String getAnalyticsData();

  /**
   * Sets the value of the &lt;analytics-data&gt; element. Google Analytics uses
   * this to Track Google Checkout Orders.
   * 
   * Please read
   * http://code.google.com/apis/checkout/developer/checkout_analytics_integration.html"
   * for more information.
   * 
   * @param data
   *          The &lt;analytics-data&gt; element value.
   */
  public void setAnalyticsData(String data);

  /**
   * Retrieves the value of the &lt;platform-id&gt; element.
   * 
   * The &lt;platform-id&gt; tag should only be used by eCommerce providers who
   * make API requests on behalf of a merchant. The tag's value contains a
   * Google Checkout merchant ID that identifies the eCommerce provider.
   * 
   * @return The &lt;analytics-data&gt; element value.
   */
  public long getPlatformID();

  /**
   * Sets the value of the &lt;platform-id&gt; element.
   * 
   * The &lt;platform-id&gt; tag should only be used by eCommerce providers who
   * make API requests on behalf of a merchant. The tag's value contains a
   * Google Checkout merchant ID that identifies the eCommerce provider.
   * 
   * @param platformId
   *          The &lt;analytics-data&gt; element value.</value>
   */
  public void setPlatformID(long platformId);

  /**
   * Retrieves the value of the &lt;request-initial-auth-details&gt; element.
   * 
   * The &lt;request-initial-auth-details&gt; tag indicates whether Google
   * should send an &lt;authorization-amount-notification&gt; when a credit card
   * is authorized for a new order.
   * 
   * @return The &lt;request-initial-auth-details&gt; element value.
   */
  public boolean isRequestInitialAuthDetails();

  /**
   * Sets the value of the &lt;request-initial-auth-details&gt; element.
   * 
   * The &lt;request-initial-auth-details&gt; tag indicates whether Google
   * should send an &lt;authorization-amount-notification&gt; when a credit card
   * is authorized for a new order.
   * 
   * @param b
   *          The boolean value.
   */
  public void setRequestInitialAuthDetails(boolean b);

  /**
   * Sets the value of the &lt;rounding-policy&gt; element and sub elements.
   * 
   * @param rule
   *          The RoundingRule.
   * @param mode
   *          The RoundingPoliy.
   * 
   * @see RoundingRule
   * @see RoundingPoliy
   */
  public void setRoundingPolicy(RoundingRule rule, RoundingMode mode);

}
