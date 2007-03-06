/**
 * 
 */
package com.google.checkout.checkout.impl;

import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.checkout.checkout.AbstractCheckoutShoppingCartRequest;
import com.google.checkout.checkout.ParameterizedUrl;
import com.google.checkout.checkout.ParameterizedUrls;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.impl.Utils;

/**
 * @author simonjsmith
 *
 */
public class CheckoutShoppingCartRequestImpl extends
		AbstractCheckoutShoppingCartRequest {

	Document document;
	Element root;
	Element shoppingCart;
	Element checkoutFlowSupport;
	
	public CheckoutShoppingCartRequestImpl(String merchantId, String merchantKey, String env, String currencyCode, int expirationMinutesFromNow) {
		super(merchantId, merchantKey, env, currencyCode, expirationMinutesFromNow);
      
      document = Utils.newEmptyDocument();
      root =  (Element) document.createElementNS("http://checkout.google.com/schema/2", "checkout-shopping-cart"); 
      document.appendChild(root);
      
      shoppingCart =  (Element) document.createElement("shopping-cart");
      checkoutFlowSupport =  (Element) document.createElement("checkout-flow-support");
   	  
      root.appendChild(shoppingCart);
      root.appendChild(checkoutFlowSupport);	  
   	  //What about order-processing-support?
      
      this.setMerchantId(merchantId);
      this.setMerchantKey(merchantKey);
      this.setEnv(env);
      this.setCurrencyCode(currencyCode);
      this.setExpirationMinutesFromNow(expirationMinutesFromNow);
   	
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addFlatRateShippingMethod(java.lang.String, float, com.google.checkout.checkout.ShippingRestrictions)
	 */
	public void addFlatRateShippingMethod(String name, float cost,
			ShippingRestrictions restrictions) {

        Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element shippingMethods = Utils.findContainerElseCreate(document, mcfs, "shipping-methods");	
        
        Element newShip = Utils.createNewContainer(document, shippingMethods, "flat-rate-shipping");
        newShip.setAttribute("name", name);
        
        Element price = Utils.createNewElementAndSet(document, newShip, "price", cost);
        price.setAttribute("currency", this.getCurrencyCode());
        
        if (restrictions != null)
        {
        	//TODO restrictions;

        }        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addItem(java.lang.String, java.lang.String, float, int)
	 */
	public void addItem(String name, String description, float price,
			int quantity) {
		
		addItem(name, description, price, quantity, null, null, null);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addItem(java.lang.String, java.lang.String, java.lang.String, float, int)
	 */
	public void addItem(String name, String description,
			float price, int quantity, String merchantItemID) {
		addItem(name, description, price, quantity, merchantItemID, null, null);
	}

	public void addItem(String name, String description, float price, int quantity, Element merchantPrivateItemData) {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addItem(java.lang.String, java.lang.String, float, int, java.lang.String)
	 */
	public void addItem(String name, String description, float price,
			int quantity, String merchantItemID, Element[] merchantPrivateItemData, String taxTableSelector) {
		
        Element items = Utils.findContainerElseCreate(document, shoppingCart, "items");	
        Element item = Utils.createNewContainer(document, items, "item");
        Utils.createNewElementAndSet(document, item, "item-name", name);
        Utils.createNewElementAndSet(document, item, "item-description", description);
        Utils.createNewElementAndSet(document, item, "unit-price", price);
        Utils.createNewElementAndSet(document, item, "quantity", quantity);
        if (merchantItemID != null) {
        	Utils.createNewElementAndSet(document, item, "merchant-item-id", merchantItemID);
        }
        if (merchantPrivateItemData != null) {
        	Element privateItemData = Utils.createNewContainer(document, item, "merchant-private-item-data");
        	Utils.addElements(document, privateItemData, merchantPrivateItemData);
        }
        if (taxTableSelector != null) {
        	Utils.createNewElementAndSet(document, item, "tax-table-selector", taxTableSelector);
        }
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addMerchantCalculatedShippingMethod(java.lang.String, float)
	 */
	public void addMerchantCalculatedShippingMethod(String name,
			float defaultCost) {
		addMerchantCalculatedShippingMethod(name, defaultCost, null);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addMerchantCalculatedShippingMethod(java.lang.String, float, com.google.checkout.checkout.ShippingRestrictions)
	 */
	public void addMerchantCalculatedShippingMethod(String name,
			float defaultCost, ShippingRestrictions restrictions) {

		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element shippingMethods = Utils.findContainerElseCreate(document, mcfs, "shipping-methods");	
  
        Element newShip = Utils.createNewContainer(document, shippingMethods, "merchant-calculated-shipping");
        newShip.setAttribute("name", name);

        Element price = Utils.createNewElementAndSet(document, newShip, "price", defaultCost);
        price.setAttribute("currency", this.getCurrencyCode());
        
        if (restrictions != null)
        {
        	//TODO restrictions;
        }        
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addParameterizedUrl(java.lang.String)
	 */
	public ParameterizedUrl addParameterizedUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addParameterizedUrl(java.lang.String, boolean)
	 */
	public ParameterizedUrl addParameterizedUrl(String url, boolean urlEncode) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addParameterizedUrl(com.google.checkout.checkout.ParameterizedUrl)
	 */
	public void addParameterizedUrl(ParameterizedUrl url) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addPickupShippingMethod(java.lang.String, float)
	 */
	public void addPickupShippingMethod(String name, float cost) {
		
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element shippingMethods = Utils.findContainerElseCreate(document, mcfs, "shipping-methods");	
  
        Element newShip = Utils.createNewContainer(document, shippingMethods, "pickup");
        newShip.setAttribute("name", name);

        Element price = Utils.createNewElementAndSet(document, newShip, "price", cost);
        price.setAttribute("currency", this.getCurrencyCode());
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addStateTaxRule(java.lang.String, double, boolean)
	 */
	public void addStateTaxRule(String StateCode, double TaxRate,
			boolean shippingTaxed) {

        Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element taxTables = Utils.findContainerElseCreate(document, mcfs, "tax-tables");			
		//TODO finish it   
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#addZipTaxRule(java.lang.String, double, boolean)
	 */
	public void addZipTaxRule(String aipPattern, double taxRate,
			boolean shippingTaxed) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getAnalyticsData()
	 */
	public String getAnalyticsData() {
		
        Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return "";}
        return Utils.getElementStringValue(document, mcfs, "analytics-data");	
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getCartExpiration()
	 */
	public Date getCartExpiration() {

		Element expiration = Utils.findElementOrContainer(document, shoppingCart, "cart-expiration");
        if (expiration == null) {return null;}		
		return Utils.getElementDateValue(document, expiration, "good-until-date");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getContinueShoppingUrl()
	 */
	public String getContinueShoppingUrl() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return "";}				
		return Utils.getElementStringValue(document, mcfs, "continue-shopping-url");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getEditCartUrl()
	 */
	public String getEditCartUrl() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return "";}				
		return Utils.getElementStringValue(document, mcfs, "edit-cart-url");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getMerchantCalculationsUrl()
	 */
	public String getMerchantCalculationsUrl() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return "";}				        
		Element merchantCalcs = Utils.findElementOrContainer(document, mcfs, "merchant-calculations");			
        if (merchantCalcs == null) {return "";}				
		return Utils.getElementStringValue(document, merchantCalcs, "merchant-calculations-url");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getMerchantPrivateData()
	 */
	public String getMerchantPrivateData() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getParameterizedUrls()
	 */
	public ParameterizedUrls getParameterizedUrls() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#getPlatformID()
	 */
	public long getPlatformID() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return 0l;}				        		
		return Utils.getElementLongValue(document, mcfs, "platform-id");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isAcceptMerchantCoupons()
	 */
	public boolean isAcceptMerchantCoupons() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return false;}				        		        
		Element merchantCalcs = Utils.findElementOrContainer(document, mcfs, "merchant-calculations");			
        if (merchantCalcs == null) {return false;}				        		
        return Utils.getElementBooleanValue(document, merchantCalcs, "accept-merchant-coupons");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isAcceptMerchantGiftCertificates()
	 */
	public boolean isAcceptMerchantGiftCertificates() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        if (mcfs == null) {return false;}				        		        
		Element merchantCalcs = Utils.findElementOrContainer(document, mcfs, "merchant-calculations");			
        if (merchantCalcs == null) {return false;}				        		
        return Utils.getElementBooleanValue(document, merchantCalcs, "accept-gift-certificates");
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isMerchantCalculatedTax()
	 */
	public boolean isMerchantCalculatedTax() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isRequestBuyerPhoneNumber()
	 */
	public boolean isRequestBuyerPhoneNumber() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isValidZipPattern(java.lang.String)
	 */
	public boolean isValidZipPattern(String zipPattern) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setAcceptMerchantCoupons(boolean)
	 */
	public void setAcceptMerchantCoupons(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element merchantCalcs = Utils.findContainerElseCreate(document, mcfs, "merchant-calculations");			
        Element gift = Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "accept-merchant-coupons", b);
    }

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setAcceptMerchantGiftCertificates(boolean)
	 */
	public void setAcceptMerchantGiftCertificates(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element merchantCalcs = Utils.findContainerElseCreate(document, mcfs, "merchant-calculations");			
        Element gift = Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "accept-gift-certificates", b);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setAnalyticsData(java.lang.String)
	 */
	public void setAnalyticsData(String data) {
		
        Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element analyticsData = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "analytics-data", data);	
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setCartExpiration(java.util.Date)
	 */
	public void setCartExpiration(Date date) {
		
		Element expiration = Utils.findContainerElseCreate(document, shoppingCart, "cart-expiration");
		Element goodUntil = Utils.findElementAndSetElseCreateAndSet(document, expiration, "good-until-date", date);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setContinueShoppingUrl(java.lang.String)
	 */
	public void setContinueShoppingUrl(String url) {

		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Element continueUrl = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "continue-shopping-url", url);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setEditCartUrl(java.lang.String)
	 */
	public void setEditCartUrl(String url) {
		
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Element cartUrl = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "edit-cart-url", url);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setExpirationMinutesFromNow(int)
	 */
	public void setExpirationMinutesFromNow(int expirationMinutesFromNow) {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, expirationMinutesFromNow);
		setCartExpiration(cal.getTime());
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setMerchantCalculatedTax(boolean)
	 */
	public void setMerchantCalculatedTax(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element taxTables = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "tax-tables", b);			
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setMerchantCalculationsUrl(java.lang.String)
	 */
	public void setMerchantCalculationsUrl(String url) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element merchantCalcs = Utils.findContainerElseCreate(document, mcfs, "merchant-calculations");			
        Element merchantCalcsUrl = Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "merchant-calculations-url", url);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setMerchantPrivateData(java.lang.String)
	 */
	public void setMerchantPrivateData(String mpd) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setParameterizedUrls(com.google.checkout.checkout.ParameterizedUrls)
	 */
	public void setParameterizedUrls(ParameterizedUrls urls) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setPlatformID(long)
	 */
	public void setPlatformID(long platformId) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Element pid = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "platform-id", platformId);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setRequestBuyerPhoneNumber(boolean)
	 */
	public void setRequestBuyerPhoneNumber(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Element phone = Utils.findElementAndSetElseCreateAndSet(document, mcfs, "request-buyer-phone-number", b);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutRequest#getPostUrl()
	 */
	public String getPostUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.CheckoutRequest#getXml()
	 */
	public String getXml() {
		Utils.documentToStdOut(document);
		return "";
	}



}
