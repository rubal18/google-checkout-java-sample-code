package com.google.checkout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.checkout.AbstractCheckoutRequest;
import com.google.checkout.impl.Base64Coder;
import com.google.checkout.impl.CheckoutResponseImpl;
import com.google.checkout.impl.Constants;
import com.google.checkout.impl.EnvironmentType;
import com.google.checkout.impl.StringUtil;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1
 * @todo		Not unit tested yet.
 *
 */

public abstract class AbstractCheckoutRequest implements CheckoutRequest {

	private String merchantId;
	private String merchantKey;
	private String env = EnvironmentType.Sandbox;
	private String currencyCode;
	
	/** <summary>Method that is called to produce the Xml message that can be posted to Google Checkout.</summary> */
    public abstract String getXml();

    private static String getAuthorization(String user, String password) {
      return Base64Coder.encode(new StringBuffer(user).append(":").append(password).toString());
    }
    
    /** <summary>Send the Message to Google Checkout</summary> */
    public CheckoutResponse send() {
      String data = getXml();
      
      try {
	      URL url = new URL(getPostUrl());
	      URLConnection connection = url.openConnection();
	      ((HttpURLConnection)connection).setRequestMethod("POST");
	      connection.setDoOutput(true);
	      
	      // We expect to read an XML response
	      connection.setDoInput(true);
	      
	      // Don't use a cache
	      connection.setUseCaches(false);
	      
	      connection.setRequestProperty("Content-Type", "text/xml");
	      PrintWriter output = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
	      output.print("<?xml version=\"1.0\" ?>.......");
	      output.flush();
	      output.close();
	      
	      // Get the response
	      String responseXml = "";
          BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
          while ((responseXml = rd.readLine()) != null) {
              // Process line...
          }
	      
	      return new CheckoutResponseImpl(responseXml);
      }
      
      catch (MalformedURLException murle) {
    	  System.err.println("MalformedURLException encountered.");
      }
      catch (IOException ioe)
      {
    	  System.err.println("IOException encountered.");
      }
      return null;
    }

    /** <summary> Get the post URL to output </summary> */
    public String getPostUrl() {
      if (env.compareTo(EnvironmentType.Sandbox) == 0) {
        return StringUtil.replaceMultipleStrings(
          Constants.sandboxPostURL,
          merchantId);
      }
      else {
    	  if (env.compareTo(EnvironmentType.Sandbox) == 0) {
    	        return StringUtil.replaceMultipleStrings(
    	          Constants.checkoutPostURL,
    	          merchantId);
    	  }
      }
      return "";
    }
    
	public String getCurrencyCode() {
      return currencyCode;
	}

	public String getEnv() {
		return env;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getMerchantKey() {
      return merchantKey;
	}

	public void setCurrencyCode(String currencyCode) {
      this.currencyCode = currencyCode;
	}

	public void setEnv(String env) {
      this.env = env;
	}

	public void setMerchantId(String merchantId) {
      this.merchantId = merchantId;
	}

	public void setMerchantKey(String merchantKey) {
      this.merchantKey = merchantKey;
	}
}
