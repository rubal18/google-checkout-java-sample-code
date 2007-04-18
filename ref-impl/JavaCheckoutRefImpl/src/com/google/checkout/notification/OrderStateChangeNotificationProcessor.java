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

package com.google.checkout.notification;

import com.google.checkout.CheckoutException;

/**
 * This class is responsible for processing a
 * &lt;order-state-change-notification&gt; sent as part of the Notification API.
 * 
 * @author simonjsmith@google.com
 */
public interface OrderStateChangeNotificationProcessor {

  /**
   * Process the notification.
   * 
   * @param callbackXML
   *          The notification XML String.
   * @return The return String, typically a &lt;notification-acknowledgment&gt;.
   */
  public String process(String callbackXML) throws CheckoutException;

}
