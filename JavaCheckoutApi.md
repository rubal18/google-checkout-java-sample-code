# Introduction #

This page describes the design decisions which were taken when designing the Java Checkout API classes.

# Design #

The Google Checkout API falls in to 4 categories.


  * **Checkout API**  This API allows the developer to post shopping carts to Google.

  * **Merchant Calculations API**  This API is a callback from Google to the merchant in order to calculate complex tax and shipping rules in real time.

  * **Notifications API** This API is a callback from Google to the merchant in order to provide status updates for an order.

  * **Order Processing API**  This API allows the developer to send processing instructions pertinent to an order to Google.

These APIs are described in more detail here:  [Google Checkout API](http://code.google.com/apis/checkout/developer/index.html)

## Outgoing APIs ##

The outgoing APIs are the **Checkout API** and the **Order Processing API**.  The diagram describes the structure of these interfaces.

http://google-checkout-java-sample-code.googlecode.com/files/API_Design_Outgoing_Messages.gnp

## Incoming APIs ##

The incoming APIs are the **Merchant Calculations API** and the **Notifications API**.  The diagram describes the structure of these interfaces.

http://google-checkout-java-sample-code.googlecode.com/files/API_Design_Incoming_Messages.gnp


## Design Notes ##

  * The MerchantConstants interface is designed to provide the implementation classes with the details they need to identify the merchant to Google.
  * The design was done with Dependency Injection in mind - indeed the reference implementation will use Constructor based DI to provide an instance of the MerchantConstants interface for each request.
  * The incoming APIs are not strongly typed as yet - they simply take Strings and return Strings.  This is beign worked on.

More information is available in the Java Docs, which are available on the downloads page.