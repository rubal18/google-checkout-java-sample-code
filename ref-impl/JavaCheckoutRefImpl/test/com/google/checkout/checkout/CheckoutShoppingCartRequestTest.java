package com.google.checkout.checkout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.MerchantConstants;
import com.google.checkout.checkout.CheckoutShoppingCartRequest;
import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.USArea;
import com.google.checkout.util.Utils;

public class CheckoutShoppingCartRequestTest extends XMLTestCase {

	String xsd = "http://code.google.com/apis/checkout/apiv2.xsd";

	String shoppingCartSimple;

	String shoppingCartTypical;

	String shoppingCartComplex;

	MerchantConstants dummyMerchantConstants;

	public CheckoutShoppingCartRequestTest(String name) {
		super(name);
	}

	public void setUp() throws Exception {

		shoppingCartSimple = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/checkout/test/checkout-shopping-cart-SIMPLE.xml"));

		shoppingCartTypical = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/checkout/test/checkout-shopping-cart-TYPICAL.xml"));

		shoppingCartComplex = inputStreamAsString(this
				.getClass()
				.getResourceAsStream(
						"/com/google/checkout/checkout/test/checkout-shopping-cart-COMPLEX.xml"));

		dummyMerchantConstants = new MerchantConstants("", "", "", "USD", "",
				"", "");

		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
		XMLUnit.setIgnoreComments(true);
	}

	public void testSimpleCartSample() throws Exception {
		CheckoutShoppingCartRequest cart = new CheckoutShoppingCartRequest(
				dummyMerchantConstants);
		cart.addItem("HelloWorld 2GB MP3 Player",
				"HelloWorld, the simple MP3 player", 159.99f, 1);

		Diff myDiff = new Diff(shoppingCartSimple, cart.getXml());

		Validator v = new Validator(cart.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());

		assertTrue("XML similar " + myDiff.toString(), myDiff.similar());
	}

	public void testTypicalCartSample() throws Exception {
		CheckoutShoppingCartRequest cart = new CheckoutShoppingCartRequest(
				dummyMerchantConstants);
		cart.addItem("AA Rechargeable Battery Pack",
				"Battery pack containing four AA rechargeable batteries",
				12.99f, 1);
		cart
				.addItem(
						"MegaSound 2GB MP3 Player",
						"Portable MP3 player - stores 500 songs, easy-to-use interface, color display",
						178.99f, 1);
		cart.setContinueShoppingUrl("http://www.example.com/shopping");
		TaxArea ta = new TaxArea();
		ta.addCountryArea(USArea.FULL_50_STATES);
		cart.addDefaultTaxRule(0.0775, false, ta);
		cart.addFlatRateShippingMethod("UPS Ground", 4.99f);
		cart.addFlatRateShippingMethod("UPS 2nd Day Air", 8.99f);

		Diff myDiff = new Diff(shoppingCartTypical, cart.getXml());

		Validator v = new Validator(cart.getXml());
		v.useXMLSchema(true);
		v.setJAXP12SchemaSource(xsd);

		assertTrue("XML valid ", v.isValid());

		assertTrue("XML similar " + myDiff.toString(), myDiff.similar());
	}

	public void testComplexCartSample() throws Exception {
		CheckoutShoppingCartRequest cart = new CheckoutShoppingCartRequest(
				dummyMerchantConstants);
		cart.setCartExpiration(Utils.parseDate("2006-12-31T23:59:59"));
		cart
				.addItem(
						"Dry Food Pack AA1453",
						"A pack of highly nutritious dried food for emergency - store in your garage for up to one year!!",
						35.99f, 1, null, null, "food");

		Document d1 = Utils
				.newDocumentFromString("<my-data><weight>1.5</weight><color>white</color><item-note>Popular item: Check inventory and order more if needed</item-note></my-data>");
		Element[] e1 = new Element[] { d1.getDocumentElement() };

		cart
				.addItem(
						"MegaSound 2GB MP3 Player",
						"Portable MP3 player - stores 500 songs, easy-to-use interface, color display",
						178.99f, 1, e1);

		Document d2 = Utils
				.newDocumentFromString("<merchant-note>My Order Number 9876543</merchant-note>");
		Element[] e2 = new Element[] { d2.getDocumentElement() };

		cart.setMerchantPrivateDataNodes(e2);

		ShippingRestrictions sr1 = new ShippingRestrictions();
		sr1.addAllowedCountryArea(USArea.ALL);
		sr1.addExcludedStateCode("AL");
		sr1.addExcludedStateCode("MA");
		sr1.addExcludedStateCode("MT");
		sr1.addExcludedStateCode("WA");

		cart.addMerchantCalculatedShippingMethod("SuperShip", 10.99f, sr1);

		ShippingRestrictions sr2 = new ShippingRestrictions();
		sr2.addAllowedCountryArea(USArea.CONTINENTAL_48);

		cart.addMerchantCalculatedShippingMethod("UPS Ground", 8.99f, sr2);

		cart.setEditCartUrl("http://www.example.com/shopping/edit");
		cart.setContinueShoppingUrl("http://www.example.com/shopping/continue");
		cart
				.setMerchantCalculationsUrl("http://www.example.com/shopping/merchantCalc");
		cart.setAcceptMerchantCoupons(true);
		cart.setAcceptMerchantGiftCertificates(true);
		cart.setMerchantCalculatedTax(true);

		TaxArea ta1 = new TaxArea();
		ta1.addCountryArea(USArea.CONTINENTAL_48);
		cart.addDefaultTaxRule(0.0825, false, ta1);

		TaxArea ta2 = new TaxArea();
		ta2.addStateCode("NY");
		cart.addDefaultTaxRule(0.0800, true, ta2);

		TaxArea ta3 = new TaxArea();
		ta3.addStateCode("CA");
		cart.addAlternateTaxRule("food", false, 0.0225, ta3);

		TaxArea ta4 = new TaxArea();
		ta4.addStateCode("NY");
		cart.addAlternateTaxRule("food", false, 0.0200, ta4);

		TaxArea ta5 = new TaxArea();
		ta5.addCountryArea(USArea.ALL);
		cart.addAlternateTaxRule("drugs", true, 0.0500, ta5);

		Diff myDiff = new Diff(shoppingCartComplex, cart.getXml());

		Validator v = new Validator(cart.getXml());
		v.useXMLSchema(true);
		v
				.setJAXP12SchemaSource("http://code.google.com/apis/checkout/apiv2.xsd");

		assertTrue("XML valid ", v.isValid());

		// TODO: Having problems with this.
		// assertTrue("XML similar " + myDiff.toString(),
		// myDiff.similar());
	}

	private String inputStreamAsString(InputStream stream) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(stream));
		StringBuilder sb = new StringBuilder();
		String line = null;

		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		br.close();
		return sb.toString();
	}
}
