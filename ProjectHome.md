**Existing users - we've just shipped a new version!**
  * ReleaseNotes\_09
  * [Downloads](http://code.google.com/p/google-checkout-java-sample-code/downloads/list)

**New users - here is an introduction**

This is a new version of the Java Checkout sample code.  When we started planning this version, we had a long wishlist of features:

  * Compatible with the widest possible range of JDK versions  (1.3.x, 1.4.x, 1.5.x)
  * Allow only core JDK types on the public API interfaces therefore independent of JDK version.
  * Shipped as a library which can be dropped into a project.
  * Provide clear customisation points should the user have non-standard requirements.
  * Clearly defined API for the developer - avoid use of static helper style classes.
  * No modifications should be required to the sample code.  i.e. externalise all config parameters.
  * Make the .NET and Java sample code APIs similar, to reduce support overhead.
  * For the 80% of merchants who don't want to customize or build, ship the library as a single JAR + Javadoc.

If you like the sound of all that, here's where to go next.

  * JavaCheckoutRefImpl - the API.  Provides an implementation of the entire Checkout API using only core Java classes.  Just drop it into your project and you are away!

  * JavaCheckoutWebExampleWar - an example web application using the API.  Just copy drag this WAR into your app server deploy directory and you are good to go.

  * JavaCheckoutJ2eeExampleEar - another sample application, this time shipped as an EAR.  We have used enterprise Java features to implement a scalable asynchronous notification handler mechanism using JMS.

  * SettingUpTheDevEnvironment - if you want to dig around the source code, here are the instructions for getting yourself setup.
