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

import com.google.checkout.checkout.TaxArea;
import com.google.checkout.checkout.USArea;
import com.google.checkout.impl.util.Utils;

/**
 * The default implementation of the TaxArea interface.
 * 
 * @author simonjsmith
 */
public class TaxAreaImpl implements TaxArea {

  Document document;

  Element root;

  /**
   * Default constructor.
   */
  public TaxAreaImpl() {

    document = Utils.newEmptyDocument();
    root = (Element) document.createElement("tax-area");
    document.appendChild(root);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.TaxArea#addCountryArea(com.google.checkout.checkout.USArea)
   */
  public void addCountryArea(USArea countryArea) {

    Element usCountry = Utils.createNewContainer(document, root,
        "us-country-area");
    usCountry.setAttribute("country-area", countryArea.toString());
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.TaxArea#addStateCode(java.lang.String)
   */
  public void addStateCode(String stateCode) {

    Element usState = Utils.createNewContainer(document, root, "us-state-area");
    Utils.createNewElementAndSet(document, usState, "state", stateCode);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.TaxArea#addZipPattern(java.lang.String)
   */
  public void addZipPattern(String zipPattern) {

    Element usZip = Utils.createNewContainer(document, root, "us-zip-area");
    Utils.createNewElementAndSet(document, usZip, "zip-pattern", zipPattern);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.google.checkout.checkout.TaxArea#getRootElement()
   */
  public Element getRootElement() {
    return root;
  }

  public void addPostalArea(String countryCode, String postalCodePattern) {
    Element pa = Utils.createNewContainer(document, root, "postal-area");
    Utils.createNewElementAndSet(document, pa, "country-code", countryCode);
    Utils.createNewElementAndSet(document, pa, "postal-code-pattern",
        postalCodePattern);
  }

  public void addWorldArea() {
    Utils.createNewContainer(document, root, "world-area");
  }

}
