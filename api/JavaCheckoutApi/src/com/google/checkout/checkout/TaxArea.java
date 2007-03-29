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

package com.google.checkout.checkout;

import org.w3c.dom.Element;

/**
 * This class represents the &lt;tax-area&gt; tag in the Checkout API.
 * 
 * @author simonjsmith
 */
public interface TaxArea {

  /**
   * Add a &lt;zip-pattern&gt; and encolsing &lt;us-zip-area&gt; to the
   * &lt;tax-area&gt; tag.
   * 
   * @param zipPattern
   *          The Zip Pattern.
   */
  public void addZipPattern(String zipPattern);

  /**
   * Add a &lt;state&gt; and encolsing &lt;us-state-area&gt; to the
   * &lt;tax-area&gt; tag.
   * 
   * @param stateCode
   *          The state code.
   */
  public void addStateCode(String stateCode);

  /**
   * Add a &lt;us-country-area&gt; tag to the &lt;tax-area&gt; tag.
   * 
   * @param countryArea
   *          The US country area.
   * 
   * @see USArea
   */
  public void addCountryArea(USArea countryArea);

  /**
   * This method adds a &lt;postal-area&gt; element. The
   * &lt;country-code&gt; element and optionally the &lt;postal-code-pattern&gt
   * are subelements .
   * 
   * @param countryCode
   *          The country code.
   * @param postalCodePattern
   *          The Postal Code Pattern.
   * 
   */
  public void addPostalArea(String countryCode, String postalCodePattern);

  /**
   * This method adds a &lt;world-area&gt; element.
   * 
   */
  public void addWorldArea();   
  
  /**
   * Get the root element, &lt;tax-area&gt;
   * 
   * @return The root element, &lt;tax-atea&gt;.
   */
  public Element getRootElement();
}
