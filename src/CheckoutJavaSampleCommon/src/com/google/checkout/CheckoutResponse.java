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

package com.google.checkout;

/**
 * @author 		simonjsmith, ksim
 * @date   		March 6th, 2007
 * @version		1.1
 * @todo		Not unit tested yet.
 *
 */

public interface CheckoutResponse {

	/**
	 * Gets a value indicating whether Google returned an error code or not.
	 * <value> <c>true</c> if the response did not indicate an error;
	 * otherwise, <c>false</c>. </value>
	 */
	public boolean isValidRequest();

	/**
	 * Gets the serial number. Google attaches a unique serial number to every
	 * response. <value> The serial number, for example
	 * 58ea39d3-025b-4d52-a697-418f0be74bf9. </value>
	 */
	public String getSerialNumber();

	/**
	 * If Google responded with an error (IsGood = false) then this property
	 * will contain the human-readable error message. <value> The error message
	 * returned by Google, or an empty string if there was no error. </value>
	 */
	public String getErrorMessage();

	/**
	 * If Google indicated a redirect URL in the response, this property will
	 * contain the URL string. <value> The redirect URL, or the empty string if
	 * Google didn't send a redirect URL. </value>
	 */
	public String getRedirectUrl();

	/**
	 * Gets the response XML sent by Google. <value>The response XML sent by
	 * Google.</value>
	 */
	public String getResponseXml();

}
