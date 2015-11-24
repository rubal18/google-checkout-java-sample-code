# Introduction #

This page describes how to install the J2EE app.


# Details #

Here is how to install the J2EE app on JBoss.  Refer to your server documentation for equivalent instructions for other servers.

  * Configure the JMS queue
    * Create a new JMS queue called `GoogleCheckoutInbox` here: `$JBOSS_HOME/server/default/deploy/jms/jbossmq-destinations-service.xml`.

  * Install the application
    * Download the Ear from the downloads page.
    * Drop it into the `$JBOSS_HOME/server/default/deploy`.
    * Download the properties file from the downloads page.
    * Edit it to reflect your merchant account details.
    * Drop it somewhere on the server classpath - e.g. `$JBOSS_HOME/server/default/conf`.
  * Configure your merchant account
    * Login to your merchant centre.
    * Navigate to the integration settings page and enter the follwing into the API callback URL: http://server:port/checkout/notification-async.  (N.B. Must be https for a prod account).

Now, start the server and navigate to http://server:port/checkout.  Enjoy!