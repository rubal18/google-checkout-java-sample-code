package com.google.checkout.checkout;

public class USArea {
	
	public static final USArea CONTINENTAL_48 = new USArea("CONTINENTAL_48");
	public static final USArea FULL_50_STATES = new USArea("FULL_50_STATES");
	public static final USArea ALL = new USArea("ALL");
		
	private String value;

	private USArea(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}

