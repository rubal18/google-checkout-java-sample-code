# Introduction #

This page describes how to install the web app.


# Details #

Here is how to install the web app on JBoss.  Refer to your server documentation for equivalent instructions for other servers.

  * Install the application
    * Download the War from the downloads page.
    * Drop it into the `$JBOSS_HOME/server/default/deploy`.
    * Download the properties file from the downloads page.
    * Edit it to reflect your merchant account details.
    * Drop it somewhere on the server classpath - e.g. `$JBOSS_HOME/server/default/conf`.
  * Configure your merchant account
    * Login to your merchant centre.
    * Navigate to the integration settings page and enter the following into the API callback URL: http://server:port/checkout/notification.  (N.B. Must be https for a prod account).

Now, start the server and navigate to http://server:port/checkout.  Enjoy!