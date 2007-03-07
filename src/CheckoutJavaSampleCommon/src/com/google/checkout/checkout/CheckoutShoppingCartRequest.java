/*************************************************
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*************************************************/

package com.google.checkout.checkout;

import java.util.Collection;
import java.util.Date;

import org.w3c.dom.Element;

import com.google.checkout.CheckoutRequest;

/** Class used to create the structure needed by Google Checkout
 The class also has the ability to send that request to Google or return
 the Xml needed to place in the hidden form fields.
*/
public interface CheckoutShoppingCartRequest extends CheckoutRequest {
	    
 	     
/**	     This method adds an item to an order. This method handles items that 
	     do not have &lt;merchant-private-item-data&gt; XML blocks associated 
	     with them.
	     
	     <param name="Name">The name of the item. This value corresponds to the 
	     value of the &lt;item-name&gt; tag in the Checkout API request.</param>
	     <param name="Description">The description of the item. This value 
	     corresponds to the value of the &lt;item-description&gt; tag in the 
	     Checkout API request.</param>
	     <param name="Price">The price of the item. This value corresponds to 
	     the value of the &lt;unit-price&gt; tag in the Checkout API 
	     request.</param>
	     <param name="Quantity">The number of this item that is included in the 
	     order. This value corresponds to the value of the &lt;quantity&gt; tag 
	     in the Checkout API request.</param>
*/
	public void addItem(String name, String description, float price, int quantity);
	    
/**	     
	     This method adds an item to an order. This method handles items that 
	     do not have &lt;merchant-private-item-data&gt; XML blocks associated 
	     with them.
	     
	     <param name="Name">The name of the item. This value corresponds to the 
	     value of the &lt;item-name&gt; tag in the Checkout API request.</param>
	     <param name="Description">The description of the item. This value 
	     corresponds to the value of the &lt;item-description&gt; tag in the 
	     Checkout API request.</param>
	     <param name="MerchantItemID">The Merchant Item Id that uniquely identifies the product in your system.</param>
	     <param name="Price">The price of the item. This value corresponds to 
	     the value of the &lt;unit-price&gt; tag in the Checkout API 
	     request.</param>
	     <param name="Quantity">The number of this item that is included in the 
	     order. This value corresponds to the value of the &lt;quantity&gt; tag 
	     in the Checkout API request.</param>*/
	    public void addItem(String name, String description, float price, int quantity, String merchantItemID);
	     
/**	     This method adds an item to an order. This method handles items that 
	     have &lt;merchant-private-item-data&gt; XML blocks associated with them.
	     
	     <param name="Name">The name of the item. This value corresponds to the 
	     value of the &lt;item-name&gt; tag in the Checkout API request.</param>
	     <param name="Description">The description of the item. This value 
	     corresponds to the value of the &lt;item-description&gt; tag in the 
	     Checkout API request.</param>
	     <param name="Price">The price of the item. This value corresponds to 
	     the value of the &lt;unit-price&gt; tag in the Checkout API 
	     request.</param>
	     <param name="Quantity">The number of this item that is included in the 
	     order. This value corresponds to the value of the &lt;quantity&gt; tag 
	     in the Checkout API request.</param>
	     <param name="MerchantPrivateItemData">An XML node that should be 
	     associated with the item in the Checkout API request. This value 
	     corresponds to the value of the value of the 
	     &lt;merchant-private-item-data&gt; tag in the Checkout API 
	     request.</param>
*/	    public void addItem(String name, String description, float price,
	      int quantity, Element[] merchantPrivateItemData);

	     
/**	     This method adds an item to an order. This method handles items that 
	     have &lt;merchant-private-item-data&gt; XML blocks associated with them.
	     
	     <param name="Name">The name of the item. This value corresponds to the 
	     value of the &lt;item-name&gt; tag in the Checkout API request.</param>
	     <param name="Description">The description of the item. This value 
	     corresponds to the value of the &lt;item-description&gt; tag in the 
	     Checkout API request.</param>
	     <param name="MerchantItemID">The Merchant Item Id that uniquely identifies the product in your system.</param>
	     <param name="Price">The price of the item. This value corresponds to 
	     the value of the &lt;unit-price&gt; tag in the Checkout API 
	     request.</param>
	     <param name="Quantity">The number of this item that is included in the 
	     order. This value corresponds to the value of the &lt;quantity&gt; tag 
	     in the Checkout API request.</param>
	     <param name="MerchantPrivateItemData">An XML node that should be 
	     associated with the item in the Checkout API request. This value 
	     corresponds to the value of the value of the 
	     &lt;merchant-private-item-data&gt; tag in the Checkout API 
	     request.</param>
*/	    public void addItem(String name, String description,
	      float price, int quantity, String merchantItemID, Element[] merchantPrivateItemData, String taxTableSelector);	    
	     
/**	     This method adds a flat-rate shipping method to an order. This method 
	     handles flat-rate shipping methods that do not have shipping 
	     restrictions.
	     
	     <param name="Name">The name of the shipping method. This value will be 
	     displayed on the Google Checkout order review page.</param>
	     <param name="Cost">The cost associated with the shipping method.</param>
	    public void addFlatRateShippingMethod(String name, float cost);

	     
	     This method adds a flat-rate shipping method to an order. This method 
	     handles flat-rate shipping methods that have shipping restrictions.
	     
	     <param name="Name">The name of the shipping method. This value will be 
	     displayed on the Google Checkout order review page.</param>
	     <param name="Cost">The cost associated with the shipping method.</param>
	     <param name="Restrictions">A list of country, state or zip code areas 
	     where the shipping method is either available or unavailable.</param>
*/	    public void addFlatRateShippingMethod(String name, float cost,
	      ShippingRestrictions restrictions);

	     
/**	     This method adds a merchant-calculated shipping method to an order. 
	     This method handles merchant-calculated shipping methods that do not 
	     have shipping restrictions.
	     
	     <param name="Name">The name of the shipping method. This value will be 
	     displayed on the Google Checkout order review page.</param>
	     <param name="DefaultCost">The default cost associated with the shipping 
	     method. This value is the amount that Gogle Checkout will charge for 
	     shipping if the merchant calculation callback request fails.</param>
*/	    public void addMerchantCalculatedShippingMethod(String name,
	      float defaultCost);

	     
/**	     This method adds a merchant-calculated shipping method to an order. 
	     This method handles merchant-calculated shipping methods that have 
	     shipping restrictions.
	     
	     <param name="Name">The name of the shipping method. This value will be 
	     displayed on the Google Checkout order review page.</param>
	     <param name="DefaultCost">The default cost associated with the shipping 
	     method. This value is the amount that Gogle Checkout will charge for 
	     shipping if the merchant calculation callback request fails.</param>
	     <param name="Restrictions">A list of country, state or zip code areas 
	     where the shipping method is either available or unavailable.</param>
*/	    public void addMerchantCalculatedShippingMethod(String name,
	      float defaultCost, ShippingRestrictions restrictions);

	     
/**	     This method adds an instore-pickup shipping option to an order.
	     
	     <param name="Name">The name of the shipping method. This value will be 
	     displayed on the Google Checkout order review page.</param>
	     <param name="Cost">The cost associated with the shipping method.</param>
*/	    public void addPickupShippingMethod(String name, float cost);
	     
/**	     Add an already <see cref="System.Web.HttpUtility.UrlEncode(String)"/> Url	     
	     <param name="url">The UrlEncoded &lt;parameterized-url&gt; to add to the collection</param>
*/	    
		public void addParameterizedUrl(String url);

/**	     Add a Third Party Tracking URL.
	     
	     <param name="url">The &lt;parameterized-url&gt; to add to the collection</param>
	     <param name="urlEncode">true if you need the url to be <see cref="System.Web.HttpUtility.UrlEncode(String)"/></param>
	     <returns>A new <see cref="ParameterizedUrl" /></returns>
*/	    
		public void addParameterizedUrl(String url, boolean urlEncode);
	     
		/**	     Add an already <see cref="System.Web.HttpUtility.UrlEncode(String)"/> Url	     
		<param name="url">The UrlEncoded &lt;parameterized-url&gt; to add to the collection</param>
		*/	    
		public void addParameterizedUrl(String url, Collection parameters);
		
		/**	     Add a Third Party Tracking URL.
		
		<param name="url">The &lt;parameterized-url&gt; to add to the collection</param>
		<param name="urlEncode">true if you need the url to be <see cref="System.Web.HttpUtility.UrlEncode(String)"/></param>
		<returns>A new <see cref="ParameterizedUrl" /></returns>
		*/	    
		public void addParameterizedUrl(String url, boolean urlEncode, Collection parameters);


/**	     This method verifies that a given zip code pattern is valid. Zip code 
	     patterns may be five-digit numbers or they may be one- to four-digit 
	     numbers followed by an asterisk.
	     
	     <param name="ZipPattern">This parameter contains the zip code pattern 
	     that is being evaluated.</param>
	     <returns>
	       This method returns <b>true</b> if the provided zip code pattern
	       is valid, meaning it is either a series of five digits or it is 
	       a series of zero to four digits followed by an asterisk. If the 
	       zip code pattern is not valid, this method returns <b>false</b>.
	     </returns>
*/	    public boolean isValidZipPattern(String zipPattern);

	     

	    public void addDefaultTaxRule(double taxRate, boolean shippingTaxed, TaxArea taxArea);

	    public void addAlternateTaxRule(String tableName, boolean standalone, double taxRate, TaxArea taxArea);
	    
	    
	     
/**	     Adds the country tax rule.
	     This method adds a tax rule associated with a particular state.
	     
	     <param name="Area">The area.</param>
	     <param name="TaxRate">The tax rate associated with a tax rule. Tax 
	     rates are expressed as float values. For example, a value of 0.0825 
	     specifies a tax rate of 8.25%.</param>
	     <param name="ShippingTaxed">
	     If this parameter has a value of <b>true</b>, then shipping costs will
	     be taxed for items that use the associated tax rule.
	     </param>
	     <example>
	     <code>
	       // We assume Req is a CheckoutShoppingCartRequest object.
	       // Charge the 50 states 8% tax and do not tax shipping.
	       Req.AddCountryTaxRule(AutoGen.USAreas.FULL_50_STATES, 0.08, false);
	       // Charge the 48 continental states 5% tax and do tax shipping.
	       Req.AddCountryTaxRule(AutoGen.USAreas.CONTINENTAL_48, 0.05, true);
	       // Charge all states (incl territories) 9% tax, don't tax shipping.
	       Req.AddCountryTaxRule(AutoGen.USAreas.ALL, 0.09, false);
	     </code>
	     </example>
*/	    //public void addCountryTaxRule(AutoGen.USAreas Area, double TaxRate,
	    //  boolean ShippingTaxed);

	     
/**	     This method adds a new tax rule to the &lt;default-tax-table&gt;.
	     This method is called by the methods that create the XML blocks
	     for flat-rate shipping, merchant-calculated shipping and instore-pickup
	     shipping methods.
	     
	     <param name="NewRule">This parameter contains an object representing
	     a default tax rule.</param>
*/	    //private void addNewTaxRule(AutoGen.DefaultTaxRule NewRule);

	     
/**	     This property adds a XmlNode to the 
	     &lt;merchant-private-data&gt; element.
	     
	     <value>The &lt;merchant-private-data&gt; element.</value>
*/	    //public void addMerchantPrivateDataNode(Element node);

	     
/**	     This method sets the value of the &lt;good-until-date&gt; using the
	     value of the <b>CartExpirationMinutes</b> parameter. This method 
	     converts that value into Coordinated Universal Time (UTC).
	     
	     <param name="ExpirationMinutesFromNow">
	     The length of time, in minutes, after which the shopping cart should
	     expire. This property contains the value of the 
	     <b>CartExpirationMinutes</b> property.
	     </param>
*/	    public void setExpirationMinutesFromNow(int expirationMinutesFromNow);

	    //Properties...
	    
	     
/**	     Retrieves the value that indicates whether the 
	     merchant is responsible for calculating taxes for the default
	     tax table.
	     
	     <value>
	       The value of this property should be <b>true</b> if the merchant
	       will calculate taxes for the order. Otherwise, this value should be
	       <b>false</b>. The value should only be <b>true</b> if the merchant
	       has implemented the Merchant Calculations API.
	     </value>
*/	    public boolean isMerchantCalculatedTax();	    
	    
	     
/**	     Sets the value that indicates whether the 
	     merchant is responsible for calculating taxes for the default
	     tax table.
	     
	     <value>
	       The value of this property should be <b>true</b> if the merchant
	       will calculate taxes for the order. Otherwise, this value should be
	       <b>false</b>. The value should only be <b>true</b> if the merchant
	       has implemented the Merchant Calculations API.
	     </value>
*/	    public void setMerchantCalculatedTax(boolean b);

	     
/**	     Retrieves the value that indicates whether the 
	     merchant accepts coupons. If this value is set to <b>true</b>, the
	     Google Checkout order confirmation page will display a text field 
	     where the customer can enter a coupon code.
	     
	     <value>
	       This value of this property is a Boolean value that indicates
	       whether the merchant accepts coupons. This value should only be 
	       set to <b>true</b> if the merchant has implemented the Merchant 
	       Calculations API.
	     </value>
*/	    public boolean isAcceptMerchantCoupons();

	     
/**	     Sets the value that indicates whether the 
	     merchant accepts coupons. If this value is set to <b>true</b>, the
	     Google Checkout order confirmation page will display a text field 
	     where the customer can enter a coupon code.
	     
	     <value>
	       This value of this property is a Boolean value that indicates
	       whether the merchant accepts coupons. This value should only be 
	       set to <b>true</b> if the merchant has implemented the Merchant 
	       Calculations API.
	     </value>
*/	    public void setAcceptMerchantCoupons(boolean b);

	     
/**	     Retrieves the value that indicates whether the 
	     merchant accepts gift certificates. If this value is set to 
	     <b>true</b>, the Google Checkout order confirmation page will 
	     display a text field where the customer can enter a gift certificate 
	     code.
	     
	     <value>
	       This value of this property is a Boolean value that indicates
	       whether the merchant accepts gift certificates. This value should 
	       only be set to <b>true</b> if the merchant has implemented the 
	       Merchant Calculations API.
	     </value>
*/	    public boolean isAcceptMerchantGiftCertificates();

	     
/**	     Sets the value that indicates whether the 
	     merchant accepts gift certificates. If this value is set to 
	     <b>true</b>, the Google Checkout order confirmation page will 
	     display a text field where the customer can enter a gift certificate 
	     code.
	     
	     <value>
	       This value of this property is a Boolean value that indicates
	       whether the merchant accepts gift certificates. This value should 
	       only be set to <b>true</b> if the merchant has implemented the 
	       Merchant Calculations API.
	     </value>
*/	    public void setAcceptMerchantGiftCertificates(boolean b);

	        
/**	     Retrieves the value of the 
	     &lt;merchant-calculations-url&gt; element. This value is the URL to 
	     which Google Checkout will send &lt;merchant-calculation-callback&gt;
	     requests. This property is only relevant for merchants who are
	     implementing the Merchant Calculations API.
	     
	     <value>The &lt;merchant-calculations-url&gt; element value.</value>
*/	    public String getMerchantCalculationsUrl();

	     
/**	     Sets the value of the 
	     &lt;merchant-calculations-url&gt; element. This value is the URL to 
	     which Google Checkout will send &lt;merchant-calculation-callback&gt;
	     requests. This property is only relevant for merchants who are
	     implementing the Merchant Calculations API.
	     
	     <value>The &lt;merchant-calculations-url&gt; element value.</value>
*/	    public void setMerchantCalculationsUrl(String url);

	    
	     	    
	     
/**	     Retrieves the value of the 
	     &lt;merchant-private-data&gt; element.
	     
	     <value>The &lt;merchant-private-data&gt; element value.</value>
*/	    public Element[] getMerchantPrivateDataNodes();

	     
/**	     Sets the value of the 
	     &lt;merchant-private-data&gt; element.
	     
	     <value>The &lt;merchant-private-data&gt; element value.</value>
*/	    public void setMerchantPrivateDataNodes(Element[] nodes);

	    
	     
/**	     Retrieves the value of the 
	     &lt;continue-shopping-url&gt; element. Google Checkout will display 
	     a link to this URL on the page that the customer sees after completing 
	     her purchase.
	     
	     <value>The &lt;continue-shopping-url&gt; element value.</value>
*/	    public String getContinueShoppingUrl();

	     
/**	     Sets the value of the 
	     &lt;continue-shopping-url&gt; element. Google Checkout will display 
	     a link to this URL on the page that the customer sees after completing 
	     her purchase.
	     
	     <value>The &lt;continue-shopping-url&gt; element value.</value>
*/	    public void setContinueShoppingUrl(String url);


	     
/**	     Retrieves the value of the 
	     &lt;edit-cart-url&gt; element. Google Checkout will display 
	     a link to this URL on the Google Checkout order confirmation page.
	     The customer can click this link to edit the shopping cart contents
	     before completing a purchase.
	     
	     <value>The &lt;edit-cart-url&gt; element value.</value>
*/	    public String getEditCartUrl();
	    
	     
/**	     Sets the value of the 
	     &lt;edit-cart-url&gt; element. Google Checkout will display 
	     a link to this URL on the Google Checkout order confirmation page.
	     The customer can click this link to edit the shopping cart contents
	     before completing a purchase.
	     
	     <value>The &lt;edit-cart-url&gt; element value.</value>
*/	    public void setEditCartUrl(String url);

	     
/**	     Retrieves the value of the 
	     &lt;request-buyer-phone-number&gt; element. If this value is true,
	     the buyer must enter a phone number to complete a purchase.
	     
	     <value>
	       <c>true</c> if the Google should send the buyer's phone number
	       to the merchant, otherwise <c>false</c>.
	     </value>
*/	    public boolean isRequestBuyerPhoneNumber();

	     
/**	     Sets the value of the 
	     &lt;request-buyer-phone-number&gt; element. If this value is true,
	     the buyer must enter a phone number to complete a purchase.
	     
	     <value>
	       <c>true</c> if the Google should send the buyer's phone number
	       to the merchant, otherwise <c>false</c>.
	     </value>
*/	    public void setRequestBuyerPhoneNumber(boolean b);

	    
	     
/**	     Retrieves the value of the 
	     &lt;good-until-date&gt; element.
	     
	     <value>The cart expiration.</value>
*/	    public Date getCartExpiration();

	    
	     
/**	     Sets the value of the 
	     &lt;good-until-date&gt; element.
	     
	     <value>The cart expiration.</value>
*/	    public void setCartExpiration(Date date);

	     
/**	     Retrieves the value of the 
	     &lt;analytics-data&gt; element. Google Analytics uses this
	     to Track Google Checkout Orders.
	     
	     <remarks>
	     Please read http://code.google.com/apis/checkout/developer/checkout_analytics_integration.html"
	     for more information.
	     </remarks>
	     <value>The &lt;analytics-data&gt; element value.</value>
*/	    public String getAnalyticsData();

	     
/**	     Sets the value of the 
	     &lt;analytics-data&gt; element. Google Analytics uses this
	     to Track Google Checkout Orders.
	     
	     <remarks>
	     Please read http://code.google.com/apis/checkout/developer/checkout_analytics_integration.html"
	     for more information.
	     </remarks>
	     <value>The &lt;analytics-data&gt; element value.</value>
*/	    public void setAnalyticsData(String data);

	    
	     
/**	     Retrieves the value of the 
	     &lt;platform-id&gt; element.
	     
	     <remarks>
	     The &lt;platform-id&gt; tag should only be used by eCommerce providers
	     who make API requests on behalf of a merchant. The tag's value contains
	     a Google Checkout merchant ID that identifies the eCommerce provider.
	     </remarks>
	     <value>The &lt;analytics-data&gt; element value.</value>
*/	    public long  getPlatformID();

	     
/**	     Sets the value of the 
	     &lt;platform-id&gt; element.
	     
	     <remarks>
	     The &lt;platform-id&gt; tag should only be used by eCommerce providers
	     who make API requests on behalf of a merchant. The tag's value contains
	     a Google Checkout merchant ID that identifies the eCommerce provider.
	     </remarks>
	     <value>The &lt;analytics-data&gt; element value.</value>
*/	    public void setPlatformID(long platformId);

}
