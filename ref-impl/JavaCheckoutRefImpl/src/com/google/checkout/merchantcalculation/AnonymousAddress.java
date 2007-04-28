package com.google.checkout.merchantcalculation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.google.checkout.util.Utils;

/**
 * This class encapsulates the &lt;anonymous-address&gt; element, used as part
 * of the Merchant Calculations API.
 * 
 * @author simonjsmith
 * 
 */
public class AnonymousAddress {

	private Document document;

	private Element element;

	/**
	 * A constructor which takes the document and element pointing to the
	 * &lt;anonymous-address&gt; tag.
	 * 
	 * @param document
	 *            The document.
	 * @param element
	 *            The element.
	 */
	public AnonymousAddress(Document document, Element element) {
		this.element = element;
	}

	/**
	 * Retrive the contents of the &lt;city&gt; tag.
	 * 
	 * @return The city.
	 */
	public String getCity() {
		return Utils.getElementStringValue(document, element, "city");
	}

	/**
	 * Retrive the contents of the &lt;country-code&gt; tag.
	 * 
	 * @return The Country Code.
	 */
	public String getCountryCode() {
		return Utils.getElementStringValue(document, element, "country-code");
	}

	/**
	 * Retrive the contents of the &lt;id&gt; tag.
	 * 
	 * @return The id.
	 */
	public String getId() {
		return element.getAttribute("id");
	}

	/**
	 * Retrive the contents of the &lt;postal-code&gt; tag.
	 * 
	 * @return The Postal Code.
	 */
	public String getPostalCode() {
		return Utils.getElementStringValue(document, element, "postal-code");
	}

	/**
	 * Retrive the contents of the &lt;region&gt; tag.
	 * 
	 * @return The Region.
	 */
	public String getRegion() {
		return Utils.getElementStringValue(document, element, "region");
	}
}
