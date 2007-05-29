package com.google.api.checkout.strikeiron;

import com.strikeiron.ws.taxdatabasic.*;
import org.apache.axis.message.SOAPHeaderElement;
import javax.xml.soap.SOAPElement;
import java.net.MalformedURLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class TaxServiceUser {

    private final static String HEADER_NS = "http://ws.strikeiron.com";
    private final static String LICENSE_INFO = "LicenseInfo";
    private final static String REGISTERED_USER = "RegisteredUser";
    private final static String USER_ID = "UserID";
    private final static String PASSWORD = "Password";

    private String userid;
	private String password;

	 /**
	  * Create an an TaxServiceUser with the default properties file name
	  * "~/strikeiron.properties"
	  * 
	  */
	 public TaxServiceUser() throws IOException {
		 this(System.getProperty("user.home") + "/strikeiron.properties");
	 }

	  /**
	   * Create an an TaxServiceUser with the given properties file name
	   * properties that can be specified are email, password, 
	   * token, useragent, clientEmail and alternateUrl.
	   * 
	   * @param filename   the path to the properties file 
	   * it needs to follow the java.util.Properties file format
	   */
	  public TaxServiceUser(String filename)  throws IOException {
		this(getMap(filename));
	  }

	  public static Map getMap(String filename) throws IOException {
		Properties credentials = new Properties();
		credentials.load(new FileInputStream(filename));
		return credentials;
	  }
	  
	  /**
	   * Create an an TaxServiceUser with the given Map
	   * keys that can be specified are userid, password, 
	   * 
	   * @param properties   the Map object containing the constructor parameters
	   */
	  public TaxServiceUser(Map creds)  throws MalformedURLException {
		this((String)creds.get("userid"),
			(String)creds.get("password"));
	  }

	  public TaxServiceUser(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public TaxDataBasicSoap getTaxService() throws Exception {
		TaxDataBasicLocator locator = new TaxDataBasicLocator();
		TaxDataBasicSoapStub service = (TaxDataBasicSoapStub)locator.getTaxDataBasicSoap();
        SOAPHeaderElement header = new SOAPHeaderElement(HEADER_NS, LICENSE_INFO);
        SOAPElement element = header.addChildElement(REGISTERED_USER);
        element.addChildElement(USER_ID).addTextNode(userid);
        element.addChildElement(PASSWORD).addTextNode(password);
        service.setHeader(header);
        return service;
	}

}
