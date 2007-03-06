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

/**
 * The &lt;parameterized-url&gt; tag. It contains information about an
 * individual web beacon that will be included on the Google Checkout order
 * confirmation page.
 */
public interface ParameterizedUrl {

	/**
	 * The url used for the Third Party Tracking.
	 */
	public String getUrl();

	public UrlParameter[] getParams();

	/**
	 * Add a url parameter and the type to the collection. The ParamName will
	 * automatically be URLEncoded since it should only be a string.
	 * 
	 * @param paramName
	 *            The url parameter to add.
	 * @param paramType
	 *            The {@see UrlParameterType} to add.
	 */
	public void addParameter(String paramName, UrlParameterType paramType);

}
