//	 Copyright 2005 Google Inc.
//	 All Rights Reserved.
package com.google.api.checkout.strikeiron;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * Provides utility methods to cause the contents of Service messages
 * to be logged as Web Service operations are performed.
 */
public class ServiceLogger {

  /**
   * Causes the contents of all Service requests and responses to be
   * written to the specified OutputStream.
   * <p>
   * Developers familiar with java.util.logging are
   * encouraged to configure logging directly.
   * 
   * @param out the OutputStream to which to write Service messages.
   */
  public static void logToStream(OutputStream out) {
    Logger logger = Logger.getLogger(
      "org.apache.axis.transport.http.HTTPSender");
    logger.setLevel(java.util.logging.Level.FINE);
    StreamHandler sh = new StreamHandler(out, new SimpleFormatter());
    sh.setLevel(java.util.logging.Level.FINE);
    logger.addHandler(sh);
  }

  /**
   * Causes the contents of all AdWordsService requests and responses to be
   * written to the file named by <code>filename</code>.
   * <p>
   * Developers familiar with java.util.logging are
   * encouraged to configure logging directly.
   *
   * @param filename the name of the file to which to write AdWordsService
   *  messages.
   * @throws FileNotFoundException if the specified file cannot be opened for
   *  writing.
   */
  public static void logToFile(String filename) throws FileNotFoundException {
    OutputStream os = new FileOutputStream(filename);
    logToStream(os);
  }

  /**
   * Causes the contents of all AdWordsService requests and responses to be
   * written to <code>System.err</code>.
   * <p>
   * Developers familiar with java.util.logging are
   * encouraged to configure logging directly.
   */
  public static void log() {
    logToStream(System.err);
  }

  /**
   * disable instantiation
   */
  private ServiceLogger() {

  }
}
