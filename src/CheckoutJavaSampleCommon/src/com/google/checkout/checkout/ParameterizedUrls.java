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

/**
 * The &lt;parameterized-urls&gt; tag
 * 
 * 
 * It contains information about all of the web beacons that the merchant wants
 * to add to the Google Checkout order confirmation page. This tag encapsulates
 * a list of one or more &lt;parameterized-url&gt; (<see
 * cref="ParameterizedUrl"/>) tags. See
 * http://code.google.com/apis/checkout/developer/checkout_pixel_tracking.html
 * For additional information on Third-Party Conversion Tracking
 * 
 */
public interface ParameterizedUrls {

	/**
	 * Add an already <see cref="System.Web.HttpUtility.UrlEncode(string)"/> Url
	 * 
	 * <param name="url">The UrlEncoded &lt;parameterized-url&gt; to add to the
	 * collection</param>
	 */
	public ParameterizedUrl addUrl(String url);

	/**
	 * Add a Third Party Tracking URL.
	 * 
	 * <param name="url">The &lt;parameterized-url&gt; to add to the collection</param>
	 * <param name="urlEncode">true if you need the url to be <see
	 * cref="System.Web.HttpUtility.UrlEncode(string)"/></param> <returns>A new
	 * <see cref="ParameterizedUrl" /></returns>
	 */
	public ParameterizedUrl addUrl(String url, boolean urlEncode);

	/**
	 * Add a Third Party Tracking URL.
	 * 
	 * <param name="url">The &lt;parameterized-url&gt; object to add to the
	 * collection</param> <returns>A new <see cref="ParameterizedUrl" /></returns>
	 */
	public void addUrl(ParameterizedUrl url);
	
	public Element getElement();

}
