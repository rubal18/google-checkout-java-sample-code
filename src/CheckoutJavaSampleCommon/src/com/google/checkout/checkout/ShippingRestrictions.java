/*************************************************
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************************************/

package com.google.checkout.checkout;

import org.w3c.dom.Element;

public interface ShippingRestrictions {

	/**
	 * This method adds an allowed zip code pattern to a &lt;us-zip-area&gt;
	 * element. The &lt;us-zip-area&gt; element, in turn, appears as a
	 * subelement of &lt;allowed-areas&gt;.
	 * 
	 * <param name="ZipPattern">The zip pattern.</param>
	 */
	public void addAllowedZipPattern(String zipPattern);

	/**
	 * This method adds an allowed U.S. state code to a &lt;us-state-area&gt;
	 * element. The &lt;us-state-area&gt; element, in turn, appears as a
	 * subelement of &lt;allowed-areas&gt;.
	 * 
	 * <param name="StateCode">The state code.</param>
	 */
	public void addAllowedStateCode(String stateCode);

	/**
	 * This method adds an allowed U.S. country area to a
	 * &lt;us-country-area&gt; element. The &lt;us-country-area&gt; element, in
	 * turn, appears as a subelement of &lt;allowed-areas&gt;.
	 * 
	 * <param name="CountryArea">The country area.</param>
	 */
	public void addAllowedCountryArea(USArea countryArea);

	/**
	 * This method adds an excluded zip code pattern to a &lt;us-zip-area&gt;
	 * element. The &lt;us-zip-area&gt; element, in turn, appears as a
	 * subelement of &lt;excluded-areas&gt;.
	 * 
	 * <param name="ZipPattern">The zip pattern.</param>
	 */
	public void addExcludedZipPattern(String zipPattern);

	/**
	 * This method adds an excluded U.S. state code to a &lt;us-state-area&gt;
	 * element. The &lt;us-state-area&gt; element, in turn, appears as a
	 * subelement of &lt;excluded-areas&gt;.
	 * 
	 * <param name="StateCode">The state code.</param>
	 */
	public void addExcludedStateCode(String stateCode);

	/**
	 * This method adds an excluded U.S. country area to a
	 * &lt;us-country-area&gt; element. The &lt;us-country-area&gt; element, in
	 * turn, appears as a subelement of &lt;excluded-areas&gt;.
	 * 
	 * <param name="CountryArea">The country area.</param>
	 */
	public void addExcludedCountryArea(USArea countryArea);
	
	public Element getRootElement();
}
