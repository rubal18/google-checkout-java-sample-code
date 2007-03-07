package com.google.checkout.checkout;

import org.w3c.dom.Element;

public interface TaxArea {

	public void addZipPattern(String zipPattern);

	public void addStateCode(String stateCode);

	public void addCountryArea(USArea countryArea);

	public Element getRootElement();
}
