/*******************************************************************************
 * Copyright (C) 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/

package com.google.checkout.checkout.impl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.checkout.checkout.ShippingRestrictions;
import com.google.checkout.checkout.USArea;
import com.google.checkout.impl.util.Utils;

/**
 * Default implementation of the ShippingRestrictions interface.
 * 
 * @see ShippingRestrictions
 * 
 * @author simonjsmith
 */
public class ShippingRestrictionsImpl implements ShippingRestrictions {

  private Document document;

  private Element root;

  /**
   * The default constructor.
   */
  public ShippingRestrictionsImpl() {

    document = Utils.newEmptyDocument();
    root = (Element) document.createElement("shipping-restrictions");
    document.appendChild(root);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedCountryArea(com.google.checkout.checkout.USArea)
   */
  public void addAllowedCountryArea(USArea countryArea) {

    Element allowedAreas = Utils.findContainerElseCreate(document, root,
        "allowed-areas");
    Element usCountry = Utils.createNewContainer(document, allowedAreas,
        "us-country-area");
    usCountry.setAttribute("country-area", countryArea.toString());
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedStateCode(java.lang.String)
   */
  public void addAllowedStateCode(String stateCode) {

    Element allowedAreas = Utils.findContainerElseCreate(document, root,
        "allowed-areas");
    Element usState = Utils.createNewContainer(document, allowedAreas,
        "us-state-area");
    Utils.createNewElementAndSet(document, usState, "state", stateCode);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addAllowedZipPattern(java.lang.String)
   */
  public void addAllowedZipPattern(String zipPattern) {

    Element allowedAreas = Utils.findContainerElseCreate(document, root,
        "allowed-areas");
    Element usZip = Utils.createNewContainer(document, allowedAreas,
        "us-zip-area");
    Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedCountryArea(com.google.checkout.checkout.USArea)
   */
  public void addExcludedCountryArea(USArea countryArea) {

    Element excludedAreas = Utils.findContainerElseCreate(document, root,
        "excluded-areas");
    Element usCountry = Utils.createNewContainer(document, excludedAreas,
        "us-country-area");
    usCountry.setAttribute("country-area", countryArea.toString());
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedStateCode(java.lang.String)
   */
  public void addExcludedStateCode(String stateCode) {

    Element excludedAreas = Utils.findContainerElseCreate(document, root,
        "excluded-areas");
    Element usState = Utils.createNewContainer(document, excludedAreas,
        "us-state-area");
    Utils.createNewElementAndSet(document, usState, "state", stateCode);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#addExcludedZipPattern(java.lang.String)
   */
  public void addExcludedZipPattern(String zipPattern) {

    Element excludedAreas = Utils.findContainerElseCreate(document, root,
        "excluded-areas");
    Element usZip = Utils.createNewContainer(document, excludedAreas,
        "us-zip-area");
    Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.ShippingRestrictions#getRootElement()
   */
  public Element getRootElement() {
    return root;
  }

  public void addAllowedPostalArea(String countryCode, String postalCodePattern) {
    Element allowedAreas = Utils.findContainerElseCreate(document, root,
        "allowed-areas");
    Element pa = Utils
        .createNewContainer(document, allowedAreas, "postal-area");
    Utils.createNewElementAndSet(document, pa, "country-code", countryCode);
    Utils.createNewElementAndSet(document, pa, "postal-code-pattern",
        postalCodePattern);
  }

  public void addAllowedWorldArea() {
    Element allowedAreas = Utils.findContainerElseCreate(document, root,
        "allowed-areas");
    Utils.createNewContainer(document, allowedAreas, "world-area");
  }

  public void addExcludedPostalArea(String countryCode, String postalCodePattern) {
    Element excludedAreas = Utils.findContainerElseCreate(document, root,
        "excluded-areas");
    Element pa = Utils
        .createNewContainer(document, excludedAreas, "postal-area");
    Utils.createNewElementAndSet(document, pa, "country-code", countryCode);
    Utils.createNewElementAndSet(document, pa, "postal-code-pattern",
        postalCodePattern);
  }

  public void addExcludedWorldArea() {
    Element excludedAreas = Utils.findContainerElseCreate(document, root,
        "excluded-areas");
    Utils.createNewContainer(document, excludedAreas, "world-area");
  }
}
