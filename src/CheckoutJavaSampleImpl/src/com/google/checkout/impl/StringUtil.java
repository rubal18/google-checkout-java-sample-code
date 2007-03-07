package com.google.checkout.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtil {
	
	public final static String replaceMultipleStrings(String input, String replaceStr1)
	{
		String[] arrReplaceStr = new String[] {replaceStr1};
		return replaceMultipleStrings(input, arrReplaceStr);
	}
	
	public final static String replaceMultipleStrings(String input, String replaceStr1, String replaceStr2)
	{
		String[] arrReplaceStr = new String[] {replaceStr1, replaceStr2};
		return replaceMultipleStrings(input, arrReplaceStr);
	}
	
	// Imitations of Java 1.5 String format function using Regex
	// For maximum compatibility with Java 1.4 
	public final static String replaceMultipleStrings(String input, String[] arrReplaceStr)
	{
		String output = input;
		for(int i = 0; i < arrReplaceStr.length; i++)
		{
			String patternStr = new StringBuffer("{").append(i).append("}").toString();
	    	String replaceStr = arrReplaceStr[i];
	    	
	    	// Compile regular expression
	      	Pattern pattern = Pattern.compile(patternStr);

	      	// Replace all instances of the pattern 
	      	Matcher matcher = pattern.matcher(output);
	      	output = matcher.replaceAll(replaceStr);
	    }
		return output;
	}

}
