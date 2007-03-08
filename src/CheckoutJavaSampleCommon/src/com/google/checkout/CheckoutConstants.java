package com.google.checkout;

public interface CheckoutConstants {

	  /**
	   * The getCheckoutUrl method returns the URL to use when submitting a
	   * Checkout API request from a form in your online store directly to
	   * Google Checkout.
	   */
	  public String getCheckoutUrl();

	  /**
	   * The getRequestUrl method returns the URL to use when submitting a
	   * Order Processing API request.
	   */
	  public String getRequestUrl();

	  /**
	   * The getCheckoutDiagnoseUrl method returns the URL to use when submitting 
	   * a request to verify that the XML in a Checkout API request is valid.
	   */
	  public String getCheckoutDiagnoseUrl();

	  /**
	   * The getRequestDiagnoseUrl method returns the URL to use when submitting 
	   * a request to verify that the XML in an Order Processing API request 
	   * is valid.
	   */
	  public String getRequestDiagnoseUrl();
}
