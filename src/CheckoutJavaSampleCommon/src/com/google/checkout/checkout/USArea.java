package com.google.checkout.checkout;

public class USArea {
	
	public static USArea CONTINENTAL_48 = new USArea("CONTINENTAL_48");
	public static USArea FULL_50_STATES = new USArea("FULL_50_STATES");
	public static USArea ALL = new USArea("ALL");
		
	private String value;

	private USArea(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}

