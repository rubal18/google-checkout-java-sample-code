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

package com.google.checkout;

/**
 * This class represents a checkout response message from Google.
 * 
 * @author simonjsmith, ksim
 * @version 1.1  
 */

public interface CheckoutResponse {

  /**
   * Gets a value indicating whether Google returned an error code or not. true
   * if the response did not indicate an error; otherwise, false.
   * 
   * @return The boolean value.
   */
  public boolean isValidRequest();

  /**
   * Gets the serial number. Google attaches a unique serial number to every
   * response. The serial number, for example
   * 58ea39d3-025b-4d52-a697-418f0be74bf9.
   * 
   * @return The serial number.
   */
  public String getSerialNumber();

  /**
   * If Google responded with an error (isGood = false) then this property will
   * contain the human-readable error message. The error message returned by
   * Google, or an empty string if there was no error.
   * 
   * @return The error message.
   */
  public String getErrorMessage();

  /**
   * If Google indicated a redirect URL in the response, this property will
   * contain the URL string. The redirect URL, or the empty string if Google
   * didn't send a redirect URL.
   * 
   * @return The redirect URL.
   */
  public String getRedirectUrl();

  /**
   * Return the XML response String.
   * 
   * @return The XML response String.
   */
  public String getXml();

  /**
   * Return the nicely formatted XML response String.
   * 
   * @return The nicely formatted XML response String.
   */
  public String getXmlPretty();
}
