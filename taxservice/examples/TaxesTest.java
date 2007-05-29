//	 Copyright 2005 Google Inc.
//	 All Rights Reserved.

/**
 * Demo of using the StrikeIron Tax Service
 */
import com.strikeiron.ws.taxdatabasic.*;
import com.google.api.checkout.strikeiron.*;

public class TaxesTest {
	/**
	 * This simple demonstration program
	 *  gets the tax table for a zipcode in the US
	 */

	  public static void main(String args[]) throws Exception {

	    // This shows how to turn on logging of all the XML that gets sent to
	    //  and from the server.  This is useful for debugging and support.
	    // You can comment out this line if you don't want to see its (quite
	    //  verbose) output.
	    ServiceLogger.log();

	    // Get Credentials and Service
	    TaxServiceUser me = new TaxServiceUser();

	    TaxDataBasicSoap s = me.getTaxService();
	    TaxRateUSAData rates = s.getTaxRateUS(args[0]);
	    
	    //diplays the tax rates	    
	    System.out.println ("Tax for city " + rates.getCity_name() + " is " + rates.getTotal_use_tax());
	  }
	}
