package com.google.checkout.impl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
	
	public static void documentToStdOut(Document document) {
	  try { 
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);

		transformer.transform(source, result);
	
	  } catch (TransformerException e) {
		e.printStackTrace();
	  }
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
		ret.setTextContent(value);
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
		child.setTextContent(childValue);
		return child;
	}
	
	public static Element createNewElementAndSet(Document document, Element parent, String childElement, float childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}
		
	public static Element createNewElementAndSet(Document document, Element parent, String childElement, int childValue) {
		return createNewElementAndSet(document, parent, childElement, ""+childValue);
	}
	
	
	public static String getElementStringValue(Document document, Element parent, String element) {
		NodeList nl = parent.getElementsByTagName(element);
		if (nl.getLength() == 0) {
			return "";
		}
		return nl.item(0).getTextContent();			
	}
	
	public static boolean getElementBooleanValue(Document document, Element parent, String element) {
		return Boolean.parseBoolean(getElementStringValue(document, parent, element));		
	}
	
	public static float getElementFloatValue(Document document, Element parent, String element) {
		return Float.parseFloat(getElementStringValue(document, parent, element));		
	}
	
	public static void addElements(Document document, Element parent, Element[] children) {
		for (int i = 0; i < children.length; i++)
		{
			parent.appendChild(children[i]);	
		}		
	}
}
