package com.google.checkout.impl.util;

/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0
 * @todo		Not unit tested yet.
 *
 */

public abstract class Tuple 
{
	private Object firstElement;
	private Object secondElement;
	
	Tuple(Object fElement, Object sElement)
	{
		firstElement = fElement;
		secondElement = sElement;
	}
	
	public Object getFirstElement()
	{
		return firstElement;
	}
	
	public Object getSecondElement()
	{
		return secondElement;
	}
	
	public void setFirstElement(Object fElement)
	{
		firstElement = fElement;
		return;
	}
	
	public void setSecondElement(Object sElement)
	{
		secondElement = sElement;
		return;
	}

}
