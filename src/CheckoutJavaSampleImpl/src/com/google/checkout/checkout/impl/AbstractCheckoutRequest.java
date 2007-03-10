package com.google.checkout.checkout.impl;

import java.io.BufferedReader;
import java.io.IOException;
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
import com.google.checkout.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.impl.CheckoutResponseImpl;
import com.google.checkout.impl.base64.Base64Coder;
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
	      
	      InputStreamReader sReader = null;
	      try {
	        sReader = new InputStreamReader(connection.getInputStream());
	      } catch (IOException ex) {
	        sReader = new InputStreamReader(connection.getErrorStream());
	      }
	      BufferedReader reader = new BufferedReader(sReader);
	      StringBuffer buffer = new StringBuffer();
	      String line = null;
	      while (null != (line = reader.readLine())) {
	        buffer.append(line);
	      }
        
	      return new CheckoutResponseImpl(buffer.toString());
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
