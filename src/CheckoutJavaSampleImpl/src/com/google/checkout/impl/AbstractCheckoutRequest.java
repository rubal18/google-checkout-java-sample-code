package com.google.checkout.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.google.checkout.CheckoutRequest;
import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.util.Base64Coder;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.StringUtil;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1
 * @todo		Not unit tested yet.
 *
 */

public abstract class AbstractCheckoutRequest implements CheckoutRequest {
	
	protected MerchantConstants merchantConstants;
	
	public AbstractCheckoutRequest(MerchantConstants merchantConstants) {
		this.merchantConstants = merchantConstants;
	}
	
    protected String getAuthorization() {
      return Base64Coder.encode(new StringBuffer(merchantConstants.getMerchantId()).append(":").append(merchantConstants.getMerchantKey()).toString());
    }
    
    /** <summary>Send the Message to Google Checkout</summary> */
    public CheckoutResponse send() {
      try {
    	  URL url = new URL(getPostUrl());
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	      connection.setUseCaches(false);
	      connection.setInstanceFollowRedirects(true);
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Authorization", "Basic "
	          + getAuthorization());
	      connection.setRequestProperty("Host", connection.getURL().getHost());

	      // Changed to allow i18n character sets to be processed properly
	      connection.setRequestProperty("content-type", "application/xml; charset=UTF-8");
	      connection.setRequestProperty("accept", "application/xml");
	      
	      PrintWriter output = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()));
	      output.print(getXml());
	      output.flush();
	      output.close();
	      
	      int responseCode = ((HttpURLConnection) connection).getResponseCode();
	      InputStream inputStream;
	      
	      if (responseCode == HttpURLConnection.HTTP_OK) {
	        inputStream = ((HttpURLConnection) connection).getInputStream();
	      } else {
	        inputStream = ((HttpURLConnection) connection).getErrorStream();
	      }
	      
	      // Get the response
          BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

          StringBuffer responseXml = new StringBuffer();   
          String line;
          
          while ((line = reader.readLine()) != null) {
        	  responseXml.append(line+"\n");
          }

          reader.close();
	      
	      return new CheckoutResponseImpl(responseXml.toString());
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

}
