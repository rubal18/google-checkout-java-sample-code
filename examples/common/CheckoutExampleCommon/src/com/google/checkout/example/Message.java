package com.google.checkout.example;

import java.io.Serializable;
import java.util.Date;

import com.google.checkout.impl.util.Utils;

public class Message implements Serializable {

	boolean incoming;
	Date timestamp;
	String type;
	String request;
	String response;
	
	public Message(boolean incoming, Date timestamp, String type, String request, String response) {
		this.incoming = incoming;
		this.timestamp = timestamp;
		this.type = type;
		this.request = request;
		this.response = response;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getHeader() {
		String ret = Utils.getDateString(getTimestamp()).replace('T', ' ') + " : " + type;
		return ret;
	}

	public String getBody() {
		StringBuffer sb = new StringBuffer();
		if (incoming) {
			sb.append("You Received:\n");
			sb.append(request+"\n");
			sb.append("You Sent:\n");
			sb.append(response+"\n");
		}
		else {
			sb.append("You Sent:\n");
			sb.append(request+"\n");
			sb.append("You Received:\n");
			sb.append(response+"\n");			
		}
		return sb.toString();
	}
}
