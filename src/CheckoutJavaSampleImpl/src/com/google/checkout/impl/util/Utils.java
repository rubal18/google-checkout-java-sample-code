package com.google.checkout.impl.util;

import java.io.StringWriter;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Utils {

	public static Document newEmptyDocument() {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document ret;
		
		try {
			factory = DocumentBuilderFactory.newInstance();
		    builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		ret = builder.newDocument();
		
		return ret;
	}
	
	public static Element findElementOrContainer(Document document, Element parent, String element) {
		NodeList nl = parent.getElementsByTagName(element);
		if (nl.getLength() == 0) {
			return null;
		}
		return (Element) nl.item(0);					
	}
	
	public static Element findContainerElseCreate(Document document, Element parent, String child) {
		NodeList nl = parent.getElementsByTagName(child);
		if (nl.getLength() == 0) {
			parent.appendChild(document.createElement(child));
		}
		return (Element) parent.getElementsByTagName(child).item(0);
	}
	
	public static Element createNewContainer(Document document, Element parent, String childElement) {
		Element child = (Element) document.createElement(childElement);
		parent.appendChild(child);
		return child;
	}

	public static Element findElementAndSetElseCreateAndSet(Document document, Element parent, String child, String value) {
		NodeList nl = parent.getElementsByTagName(child);
		if (nl.getLength() == 0) {
			parent.appendChild(document.createElement(child));
		}
		Element ret = (Element) parent.getElementsByTagName(child).item(0);
		ret.appendChild(document.createTextNode(value));
		return ret;		
	}
	
	public static Element findElementAndSetElseCreateAndSet(Document document, Element parent, String child, boolean value) {
		return findElementAndSetElseCreateAndSet(document, parent, child, ""+value);
	}
	
	public static Element findElementAndSetElseCreateAndSet(Document document, Element parent, String child, float value) {
		return findElementAndSetElseCreateAndSet(document, parent, child, ""+value);	
	}
	
	public static Element createNewElementAndSet(Document document, Element parent, String childElement, String childValue) {
		Element child = (Element) document.createElement(childElement);
		parent.appendChild(child);
		child.setNodeValue(childValue);
		child.appendChild(document.createTextNode(childValue));
		return child;
	}
	
	public static Element createNewElementAndSet(Document document, Element parent, String childElement, float childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}
		
	public static Element createNewElementAndSet(Document document, Element parent, String childElement, int childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}

	public static Element createNewElementAndSet(Document document, Element parent, String childElement, boolean childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}

	public static Element createNewElementAndSet(Document document, Element parent, String childElement, double childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}
	
	public static String getElementStringValue(Document document, Element parent, String element) {
		NodeList nl = parent.getElementsByTagName(element);
		if (nl.getLength() == 0) {
			return "";
		}
		return nl.item(0).getNodeValue();			
	}
	
	public static boolean getElementBooleanValue(Document document, Element parent, String element) {
		return Boolean.valueOf(getElementStringValue(document, parent, element)).booleanValue();		
	}
	
	public static float getElementFloatValue(Document document, Element parent, String element) {
		return Float.parseFloat(getElementStringValue(document, parent, element));		
	}
	
	public static void importElements(Document document, Element parent, Element[] children) {
		for (int i = 0; i < children.length; i++)
		{
			parent.appendChild(document.importNode(children[i], true));	
		}		
	}

	public static Date getElementDateValue(Document document, Element parent, String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static long getElementLongValue(Document document, Element parent, String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Element findElementAndSetElseCreateAndSet(Document document, Element parent, String string, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Element[] getElements(Document document, Element parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Element findContainerWithAttributeValueElseCreate(Document document, Element parent, String element, String attributeName, String attributeValue) {

		NodeList nl = parent.getElementsByTagName(element);
		Element e;
		for (int i = 0; i < nl.getLength(); i++)
		{
			e = (Element) nl.item(i);
			if (e.getAttribute(attributeName).equals(attributeValue))
			{
				return e;
			}			
		}
		
		e = document.createElement(element);
		parent.appendChild(e);
		e.setAttribute(attributeName, attributeValue);
	
		return e;
	}

	public static String documentToString(Document document) {
	    try {
	      TransformerFactory tf = TransformerFactory.newInstance();
	      Transformer trans = tf.newTransformer();
	      StringWriter sw = new StringWriter();
	      trans.transform(new DOMSource(document), new StreamResult(sw));
          return sw.toString();
	    } catch (TransformerException tEx) {
	      tEx.printStackTrace();
	    }
		return null;
	}		
	
	public static String documentToStringPretty(Document document) {
	    try {
	        TransformerFactory tf = TransformerFactory.newInstance();
	        Transformer trans = tf.newTransformer();
	        trans.setOutputProperty(OutputKeys.INDENT, "yes");
	        trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        StringWriter sw = new StringWriter();
	        trans.transform(new DOMSource(document), new StreamResult(sw));
	        return sw.toString();
	      } catch (TransformerException tEx) {
	    	  tEx.printStackTrace();
	      }
		return null;	
	}
}
