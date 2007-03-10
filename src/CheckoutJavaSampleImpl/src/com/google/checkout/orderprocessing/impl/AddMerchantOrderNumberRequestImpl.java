package com.google.checkout.orderprocessing.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.impl.util.Utils;
import com.google.checkout.orderprocessing.AbstractAddMerchantOrderNumberRequest;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0
 * @todo		Not unit tested yet.
 *
 */

public class AddMerchantOrderNumberRequestImpl extends AbstractAddMerchantOrderNumberRequest {

	Document document;
	Element root;
	Element merchantOrderNumber;
	
	public AddMerchantOrderNumberRequestImpl(MerchantConstants merchantConstants, String googleOrderNo, String merchantOrderNo) {
		super(merchantConstants, googleOrderNo, merchantOrderNo);

	      document = Utils.newEmptyDocument();
	      root =  (Element) document.createElementNS("http://checkout.google.com/schema/2", "add-merchant-order-number"); 
	      root.setAttributeNS("http://www.w3.org/2000/xmlns/","xmlns", "http://checkout.google.com/schema/2");
	      root.setAttribute("google-order-number", googleOrderNo);
	      document.appendChild(root);
	      
	      merchantOrderNumber =  (Element) document.createElement("merchant-order-number");
	      root.appendChild(merchantOrderNumber);
	      merchantOrderNumber.appendChild(document.createTextNode(merchantOrderNo));
	      //merchantOrderNumber.setNodeValue("1111");
	      
	      //root.appendChild(checkoutFlowSupport);	  
	   	  //What about order-processing-support?
	      
		  this.setGoogleOrderNo(googleOrderNo);
		  this.setMerchantOrderNo(merchantOrderNo);
		  /*
		  <?xml version="1.0" encoding="UTF-8"?>
		  <add-merchant-order-number xmlns="http://checkout.google.com/schema/2"
		      google-order-number="841171949013218">
		      <merchant-order-number>P6502-53-7861SBJD</merchant-order-number>
		  </add-merchant-order-number>
		  */
	}
	
	public String getXml() {
		return Utils.documentToString(document);
		//Utils.documentToStdOut(document);
		//return "";
	}
	
}
