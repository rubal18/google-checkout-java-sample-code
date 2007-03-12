package com.google.checkout.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

import com.google.checkout.impl.AbstractCheckoutRequest;
import com.google.checkout.CheckoutResponse;
import com.google.checkout.EnvironmentType;
import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Base64Coder;
import com.google.checkout.impl.util.Constants;
import com.google.checkout.impl.util.StringUtil;

/**
 * @author 		ksim
 * @date   		March 7th, 2007
 * @version		1.0 - ksim - March 7th, 2007 - 	Initial Version to separate interface and implementation
 * 												Skeleton version of send method.
 * @version		1.1 - ksim - March 10th, 2007 - Completed implementation of send method and tested connection
 * 												to checkout on Google.com by sending several XML messages
 * 												in order processing							
 * @todo		Not unit tested yet, but tested fairly well over all.
 *
 */

public abstract class CheckoutRequestImpl extends AbstractCheckoutRequest 
{
	
	public CheckoutRequestImpl(MerchantConstants mConstants) {
		super(mConstants);
	}
	
	/** <summary>Method that is called to produce the Xml message that can be posted to Google Checkout.</summary> */
    public abstract String getXml();
    
	protected String getAuthorization(String user, String password) 
	{
	      return Base64Coder.encode(new StringBuffer(user).append(":").append(password).toString());
	}
	
	public CheckoutResponse send() {
	      String data = getXml();
	      
	      //System.out.println("Data:"+data);
	      //data = StringUtil.removeChar(data, '\r');
	      //data = StringUtil.replaceXMLReservedChars(data);
	      //System.out.println("Data:"+data);
	      
	      //data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><add-merchant-order-number xmlns=\"http://checkout.google.com/schema/2\" google-order-number=\"8888\"><merchant-order-number>2222</merchant-order-number></add-merchant-order-number>";
	      //data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><archive-order xmlns=\"http://checkout.google.com/schema/2\" google-order-number=\"722229750245246\"/>";
	      //data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><charge-order xmlns=\"http://checkout.google.com/schema/2\" google-order-number=\"6014423719\"><amount currency=\"USD\">335.55</amount></charge-order>";
	      
	      //System.out.println(getPostUrl());
	       
	      try {
		      URL url = new URL(getPostUrl());
	    	  
		      // URL url = new URL("http://sandbox.google.com/checkout/cws/v2/Merchant/123/merchantCheckout");      
	    	  // URL url = new URL("http://www.viens.net/juddi/inquiry");
		      int port = url.getPort();
		      String hostname = url.getHost();
		      String path = url.getPath();
		      
		      //System.out.println(getPostUrl());
		      URLConnection connection = url.openConnection();
		      ((HttpURLConnection)connection).setRequestMethod("POST");
		      connection.setDoOutput(true);
		      
		      // We expect to read an XML response
		      connection.setDoInput(true);
		      
		      connection.setRequestProperty("Authorization","Basic "
            		  	+getAuthorization(merchantConstants.getMerchantId(), merchantConstants.getMerchantKey()));
		      
		      //System.out.println(this.getMerchantId());
		      //System.out.println(this.getMerchantKey());
		      
		      connection.setRequestProperty("Content-Type","application/xml; charset=UTF-8");
		      connection.setRequestProperty("Accept","application/xml; charset=UTF-8");
		      
		      // Don't use a cache
		      connection.setUseCaches(false);
		      
		      //connection.setRequestProperty("Content-Type", "text/xml");
		      //PrintWriter writer = new PrintWriter(connection.getOutputStream());
		      
		      //if (port < 0)
		      //    port = 80;
	  
		      // Create a Socket
		      //InetAddress addr = InetAddress.getByName(hostname);
		      //Socket sock = new Socket(addr,port);
		      
		      //DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
              //dos.writeBytes(data);
              //dos.close(); 
		      
		  
              
              OutputStream outputStream = connection.getOutputStream();
              outputStream.write(data.toString().getBytes("UTF-8"));
              outputStream.close();
              
              //System.out.println("Data:"+data);
              
              //System.out.println(((HttpURLConnection) connection));
		      
		      
		      /*
		       * URL url = new URL(MerchantConstants.getRequestUrl());
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");
                //conn.setRequestProperty("Authorization","BASIC
"+MerchantConstants.getAuthorizationString());
                conn.setRequestProperty("Authorization","BASIC
"+MerchantConstants.getHttpAuth());
                conn.setRequestProperty("Content-Type","application/xml");
                conn.setRequestProperty("Accept","application/xml");

DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(content);
                dos.close(); 
		       */
		      	
		      // Send the HTTP Headers
		      /*
		      BufferedWriter  wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(),"UTF-8"));
		      wr.write("POST " + path + " HTTP/1.0\r\n");
		      wr.write("Content-Length: " + data.length() + "\r\n");
		      wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
		      wr.write("\r\n");
		      // Send the HTTP Request
		      writer.write(data);
		      writer.close();
		      */
		      
		      System.out.println("Output Finished!");
		      
		      int responseCode = ((HttpURLConnection) connection).getResponseCode();
		      InputStream inputStream;
		      
		      if (responseCode == HttpURLConnection.HTTP_OK) {
		        inputStream = ((HttpURLConnection) connection).getInputStream();
		      } else {
		        inputStream = ((HttpURLConnection) connection).getErrorStream();
		      }
		      
		      // Get the response
	          BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
	          System.out.println("Begin Reading Input!");
	          
	          StringBuffer responseXml = new StringBuffer();   
	          String line;
	          
	          while ((line = reader.readLine()) != null) {
	        	  responseXml.append(line+"\n");
	          }
	          
	          //System.out.println(responseXml.toString());
	          
	          reader.close();
	          
	          System.out.println("Input Finished!");
		      
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
	
		public String getPostUrl() {
			
			//System.out.println("SandBox URL: "+Constants.sandboxPostURL);
			
		
	      if (merchantConstants.getEnv().compareTo(EnvironmentType.Sandbox) == 0) {
	        return StringUtil.replaceMultipleStrings(
	          Constants.sandboxPostURL,
	          merchantConstants.getMerchantId());
	      }
	      else {
	    	  if (merchantConstants.getEnv().compareTo(EnvironmentType.Sandbox) == 0) {
	    	        return StringUtil.replaceMultipleStrings(
	    	          Constants.checkoutPostURL,
	    	          merchantConstants.getMerchantId());
	    	  }
	      }
	      return "";
	    }

}
