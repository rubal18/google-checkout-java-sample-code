package com.google.checkout.impl;

import java.util.regex.*;

import com.google.checkout.impl.util.Constants;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0 - ksim - March 6th, 2007 - 	Initial Version
 * @todo		Not unit tested yet.
 * 				
 */

public final class EncodeHelper {
	
	/** <summary>
     Escapes XML characters &lt; &gt; and &amp;.
     </summary>
     <param name="In">
     String that could contain &lt; &gt; and &amp; characters.
     </param>
     <returns>
     A new string where 
     <b>&amp;</b> has been replaced by <b>&amp;#x26;</b>,
     <b>&lt;</b> has been replaced by <b>&amp;#x3c;</b> and
     <b>&gt;</b> has been replaced by <b>&amp;#x3e;</b>.
     These replacements are mandated here in the Dev Guide:
     <a href="http://code.google.com/apis/checkout/developer/index.html#api_request_guidelines">
     http://code.google.com/apis/checkout/developer/index.html#api_request_guidelines
     </a>
     </returns> */
    public static String escapeXmlChars(String str) {
    
      String output = str;
      
      StringTuple[] arrStrTuple = {
    		  new StringTuple(Constants.ampStr, Constants.ampReplaceStr),
    		  new StringTuple(Constants.lessThanStr, Constants.lessThanReplaceStr),
    		  new StringTuple(Constants.greaterThanStr, Constants.greaterThanReplaceStr)
      };
    		  
      for(int i = 0; i < arrStrTuple.length; i++)
      {
    	StringTuple strTuple = arrStrTuple[i];
    	
    	// Compile regular expression
      	Pattern pattern = Pattern.compile(strTuple.getFirstElementString());

      	// Replace all instances of the pattern 
      	Matcher matcher = pattern.matcher(output);
      	output = matcher.replaceAll(strTuple.getSecondElementString());
      }
    
      return output;

    }
    
}
