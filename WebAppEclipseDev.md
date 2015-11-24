These instructions assume that you are running some reasonably recent version of Eclipse and have the following plugins installed:

  * Eclipse Web Standard Toolkit. See: http://www.eclipse.org/webtools
  * Eclipse J2EE Standard Tools. See: http://www.eclipse.org/webtools
  * Subclipse, a Subversion plugin for Eclipse.  See:  http://subversion.tigris.org

Window -> Show View -> Servers

  * Create a new Tomcat (or other app server) Server.

Window -> Open perspective -> SVN.

  * Add SVN Server: http://google-checkout-java-sample-code.googlecode.com/svn/trunk

Right click and Checkout the following projects, in order:

  * JavaCheckoutRefImpl

> Use the wizard to create a new Utility project.
> Make sure the name of the project is JavaCheckoutRefImpl.
> Select the target runtime as the server you created.
> Accept all other defaults.

  * JavaCheckoutExampleCommon

> Use the wizard to create a new Utility project.
> Make sure the name of the project is JavaCheckoutExampleCommon.
> Select the target runtime as the server you created.
> Accept all other defaults.

  * JavaCheckoutWebExampleWar

> Use the wizard to create a new Dynamic Web project.
> Make sure the name of the project is JavaCheckoutJ2eeExampleEjb.
> Select the target runtime as the server you created.
> Accept all other defaults.

Window -> Open perspective -> Java.

Right click on JavaCheckoutExampleCommon and select properties.

  * Java Build Path -> Projects.  Add the JavaCheckoutRefImpl to the list.
  * Java Build Path -> Source.  Add the props directory to the list.

Right click on JavaCheckoutWebExampleWar and select properties.

  * J2EE Module Dependencies -> Web Libaries.  Add the JavaCheckoutExampleCommon and JavaCheckoutRefImpl projects.
  * Java Build Path -> Libraries.  Add the j2ee.jar.  Available here: http://java.sun.com/javaee/downloads/index.jsp

N.B. Currently there is a compile time dependency on some JMS and JNDI classes in the
JmsNotificationServlet class.  You can simply delete this class and skip the last step.  We are planning on removing this dependency in future releases.

Project -> Clean.

  * Clean all projects.

Run.

  * Select JavaCheckoutJ2eeExampleEar right click
  * Run As -> Run on server
  * Select the server setup earlier.

Open a browser, go to

  * http://localhost:8080/checkout

If you wish to run the unit tests then please complete the following steps.

Right click on JavaCheckoutRefImpl and select properties.

  * Java Build Path -> Source.  Add the test directory to the list.
  * Java Build Path -> Libraries.  Add the JUnit and XmlUnit jars.

See: http://www.junit.org and http://xmlunit.sourceforge.net/

Right click on com.google.checkout.CheckoutTestSuite

  * Run As -> Unit Test.