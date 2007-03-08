/**
 * 
 */
package com.google.checkout.checkout.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.CheckoutConstants;
import com.google.checkout.CheckoutResponse;
import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.CheckoutShoppingCartRequest;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.UrlParameter;
import com.google.checkout.impl.CheckoutResponseImpl;
import com.google.checkout.impl.Utils;
import com.google.checkout.impl.util.Base64Coder;

/**
 * @author simonjsmith
 *
 */
public class CheckoutShoppingCartRequestImpl implements CheckoutShoppingCartRequest {

	MerchantConstants merchantConstants;
	CheckoutConstants checkoutConstants;
	
	Document document;
	Element root;
	Element shoppingCart;
	Element checkoutFlowSupport;
	
	public CheckoutShoppingCartRequestImpl(MerchantConstants merchantConstants) {
		
      document = Utils.newEmptyDocument();
      root =  (Element) document.createElementNS("http://checkout.google.com/schema/2", "checkout-shopping-cart"); 
      document.appendChild(root);
      
      shoppingCart =  (Element) document.createElement("shopping-cart");
      checkoutFlowSupport =  (Element) document.createElement("checkout-flow-support");
   	  
      root.appendChild(shoppingCart);
      root.appendChild(checkoutFlowSupport);	  
      
      this.merchantConstants = merchantConstants;
      this.checkoutConstants = checkoutConstants;
      
      //this.setExpirationMinutesFromNow(expirationMinutesFromNow);
   	
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
        price.setAttribute("currency", merchantConstants.getCurrencyCode());
        
        if (restrictions != null) {
        	Utils.importElements(document, newShip, new Element[] {restrictions.getRootElement()});
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

	public void addItem(String name, String description, float price, int quantity, Element[] merchantPrivateItemData) {
		addItem(name, description, price, quantity, null, merchantPrivateItemData, null);
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
        Element ePrice = Utils.createNewElementAndSet(document, item, "unit-price", price);
        ePrice.setAttribute("currency", merchantConstants.getCurrencyCode());
        Utils.createNewElementAndSet(document, item, "quantity", quantity);
        if (merchantItemID != null) {
        	Utils.createNewElementAndSet(document, item, "merchant-item-id", merchantItemID);
        }
        if (merchantPrivateItemData != null) {
        	Element privateItemData = Utils.createNewContainer(document, item, "merchant-private-item-data");
        	Utils.importElements(document, privateItemData, merchantPrivateItemData);
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
        price.setAttribute("currency", merchantConstants.getCurrencyCode());
        
        if (restrictions != null) {
        	Utils.importElements(document, newShip, new Element[] {restrictions.getRootElement()});
        }        
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
        price.setAttribute("currency", merchantConstants.getCurrencyCode());
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

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");
	    if (mcfs == null) {return false;}	
        Element taxTables = Utils.findContainerElseCreate(document, mcfs, "tax-tables");			
	    if (taxTables == null) {return false;}	
        return Boolean.valueOf(taxTables.getAttribute("merchant-calculated")).booleanValue();
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#isRequestBuyerPhoneNumber()
	 */
	public boolean isRequestBuyerPhoneNumber() {

		Element mcfs = Utils.findElementOrContainer(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
	    if (mcfs == null) {return false;}				        		        		
		return Utils.getElementBooleanValue(document, mcfs, "request-buyer-phone-number");
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
        Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "accept-merchant-coupons", b);
    }

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setAcceptMerchantGiftCertificates(boolean)
	 */
	public void setAcceptMerchantGiftCertificates(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element merchantCalcs = Utils.findContainerElseCreate(document, mcfs, "merchant-calculations");			
        Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "accept-gift-certificates", b);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setAnalyticsData(java.lang.String)
	 */
	public void setAnalyticsData(String data) {
		
        Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Utils.findElementAndSetElseCreateAndSet(document, mcfs, "analytics-data", data);	
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setCartExpiration(java.util.Date)
	 */
	public void setCartExpiration(Date date) {
		
		Element expiration = Utils.findContainerElseCreate(document, shoppingCart, "cart-expiration");
		Utils.findElementAndSetElseCreateAndSet(document, expiration, "good-until-date", date);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setContinueShoppingUrl(java.lang.String)
	 */
	public void setContinueShoppingUrl(String url) {

		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Utils.findElementAndSetElseCreateAndSet(document, mcfs, "continue-shopping-url", url);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setEditCartUrl(java.lang.String)
	 */
	public void setEditCartUrl(String url) {
		
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Utils.findElementAndSetElseCreateAndSet(document, mcfs, "edit-cart-url", url);
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
        Element taxTables = Utils.findContainerElseCreate(document, mcfs, "tax-tables");			
        taxTables.setAttribute("merchant-calculated", ""+b);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setMerchantCalculationsUrl(java.lang.String)
	 */
	public void setMerchantCalculationsUrl(String url) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element merchantCalcs = Utils.findContainerElseCreate(document, mcfs, "merchant-calculations");			
        Utils.findElementAndSetElseCreateAndSet(document, merchantCalcs, "merchant-calculations-url", url);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setPlatformID(long)
	 */
	public void setPlatformID(long platformId) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Utils.findElementAndSetElseCreateAndSet(document, mcfs, "platform-id", platformId);
	}

	/* (non-Javadoc)
	 * @see com.google.checkout.checkout.CheckoutShoppingCartRequest#setRequestBuyerPhoneNumber(boolean)
	 */
	public void setRequestBuyerPhoneNumber(boolean b) {
        
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Utils.findElementAndSetElseCreateAndSet(document, mcfs, "request-buyer-phone-number", b);
	}

	public Element[] getMerchantPrivateDataNodes() {
		Element mpd = Utils.findElementOrContainer(document, shoppingCart, "merchant-private-data");
		if (mpd == null) {return null;}
		return Utils.getElements(document, mpd);
	}

	public void setMerchantPrivateDataNodes(Element[] nodes) {
		Element mpd = Utils.findContainerElseCreate(document, shoppingCart, "merchant-private-data");
		Utils.importElements(document, mpd, nodes);
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
		return Utils.documentToString(document);
	}

	public void addAlternateTaxRule(String tableName, boolean standalone, double taxRate, TaxArea taxArea) {
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element taxTables = Utils.findContainerElseCreate(document, mcfs, "tax-tables");			
        Element alternateTaxTables = Utils.findContainerElseCreate(document, taxTables, "alternate-tax-tables");			
        Element newTaxTable = Utils.findContainerWithAttributeValueElseCreate(document, alternateTaxTables, "alternate-tax-table", "name", tableName);
        Element alternateTaxRules = Utils.findContainerElseCreate(document, newTaxTable, "alternate-tax-rules");	
        
        Element newRule = Utils.createNewContainer(document, alternateTaxRules, "alternate-tax-rule");
        Utils.createNewElementAndSet(document, newRule, "rate", taxRate);
        Utils.importElements(document, newRule, new Element[] {taxArea.getRootElement()});   
	}

	public void addDefaultTaxRule(double taxRate, boolean shippingTaxed, TaxArea taxArea) {

		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
        Element taxTables = Utils.findContainerElseCreate(document, mcfs, "tax-tables");			
        Element defaultTaxTable = Utils.findContainerElseCreate(document, taxTables, "default-tax-table");
        Element taxRules = Utils.findContainerElseCreate(document, defaultTaxTable, "tax-rules");
        
        Element newRule = Utils.createNewContainer(document, taxRules, "tax-rule");
        Utils.createNewElementAndSet(document, newRule, "shipping-taxed", shippingTaxed);
        Utils.createNewElementAndSet(document, newRule, "rate", taxRate);
        Utils.importElements(document, newRule, new Element[] {taxArea.getRootElement()});   
	}

	public void addParameterizedUrl(String url) {
		
		addParameterizedUrl(url, false);		
	}

	public void addParameterizedUrl(String url, boolean urlEncode) {
		addParameterizedUrl(url, urlEncode, null);
		
	}

	public void addParameterizedUrl(String url, Collection parameters) {
		addParameterizedUrl(url, false, parameters);
		
	}

	public void addParameterizedUrl(String url, boolean urlEncode, Collection parameters) {
		if(urlEncode) {
			try {
				url = URLEncoder.encode(url, "UFT-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}			
		}
	
		Element mcfs = Utils.findContainerElseCreate(document, checkoutFlowSupport, "merchant-checkout-flow-support");	
		Element pUrl = Utils.createNewContainer(document, mcfs, "parameterized-url");
		pUrl.setAttribute("url", url);

		Iterator it = parameters.iterator();
		UrlParameter param;
		while(it.hasNext()) {
			param = (UrlParameter) it.next();
			Element eParams = Utils.createNewContainer(document, pUrl, "parameters");
			Element eParam = Utils.createNewContainer(document, eParams, "url-parameter");
			eParam.setAttribute("name", param.getName());
			eParam.setAttribute("type", param.getParamType().toString());
		}
	}

	public CheckoutResponse send() {
		try {
			String xml = this.getXml();
			String encoded = Base64Coder.encode(xml);
			String url = "https://sandbox.google.com/checkout/cws/v2/Merchant/"+merchantConstants.getMerchantId()+"/request";
			String response;
			response = Transmitter.transmit(merchantConstants, new URL(url), encoded);

			System.out.println(response);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getXmlPretty() {
		return Utils.documentToStringPretty(document);
	}
}
