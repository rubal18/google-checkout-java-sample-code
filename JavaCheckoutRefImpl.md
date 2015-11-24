# Introduction #

This page describes the reference implementation.


# Details #

The reference implementation uses the `org.w3c.*` classes to provide a fully functional implementation of the JavaCheckoutApi interfaces.  It is designed to be used as a library which can be dropped into your existing development environment.  It depends on the JavaCheckoutApi.

It provides an implementation of the outgoing APIs only - **Checkout API** and **Order Processing API**.  Typically, the logic required for the incoming APIs is heavily merchant-specific and therefore does not belong in a library.  The web app and J2EE app examples contain default implementations.  In future releases, we will extend the API and reference implementations to include reference implementations of the incoming classes, exposing a strongly typed API.

Typically, each request object will define a constructor which takes an instance of the MerchantConstants interface.  The reference implementation does not define how runtime discovery of implementation classes should happen.  But the design was done with constructor based dependency injection in mind.