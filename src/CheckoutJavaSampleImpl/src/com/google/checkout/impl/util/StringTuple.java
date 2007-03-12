package com.google.checkout.impl.util;


/**
 * @author 		ksim
 * @date   		March 6th, 2007
 * @version		1.0
 * @todo		Not unit tested yet.
 *
 */

public final class StringTuple extends Tuple
{
		public StringTuple(String fElement, String sElement)
		{
			super(fElement, sElement);
		}
		
		public String getFirstElementString()
		{
			Object fElement = this.getFirstElement();
			
			if(fElement == null)
				return "";
			
			else if (fElement instanceof String)
				return (String)fElement;
			
			return "";
		}
		
		public String getSecondElementString()
		{
			Object sElement = this.getSecondElement();
			
			if(sElement == null)
				return "";
			
			else if (sElement instanceof String)
				return (String) sElement;
			
			return "";
		}
		
		public void setFirstElementString(String fElement)
		{
			this.setFirstElement(fElement);
			return;
		}
		
		public void setSecondElementString(String sElement)
		{
			this.setSecondElement(sElement);
			return;
		}

}
