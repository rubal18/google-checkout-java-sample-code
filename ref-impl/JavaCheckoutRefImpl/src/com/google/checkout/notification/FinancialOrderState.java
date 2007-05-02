package com.google.checkout.notification;

public class FinancialOrderState {

	/**
	 * An instance of the FinancialOrderState class representing REVIEWING.
	 */
	public static final FinancialOrderState REVIEWING = new FinancialOrderState(
			"REVIEWING");

	/**
	 * An instance of the FinancialOrderState class representing CHARGEABLE.
	 */
	public static final FinancialOrderState CHARGEABLE = new FinancialOrderState(
			"CHARGEABLE");

	/**
	 * An instance of the FinancialOrderState class representing CHARGING.
	 */
	public static final FinancialOrderState CHARGING = new FinancialOrderState(
			"CHARGING");

	/**
	 * An instance of the FinancialOrderState class representing CHARGED.
	 */
	public static final FinancialOrderState CHARGED = new FinancialOrderState(
			"CHARGED");

	/**
	 * An instance of the FinancialOrderState class representing
	 * PAYMENT_DECLINED.
	 */
	public static final FinancialOrderState PAYMENT_DECLINED = new FinancialOrderState(
			"PAYMENT_DECLINED");

	/**
	 * An instance of the FinancialOrderState class representing
	 * CANCELLED_BY_GOOGLE.
	 */
	public static final FinancialOrderState CANCELLED_BY_GOOGLE = new FinancialOrderState(
			"CANCELLED_BY_GOOGLE");

	/**
	 * An instance of the FinancialOrderState class representing CANCELLED.
	 */
	public static final FinancialOrderState CANCELLED = new FinancialOrderState(
			"CANCELLED");

	private String value;

	private FinancialOrderState(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}

	public static FinancialOrderState getState(String state) {
		if ("REVIEWING".equals(state)) {
			return REVIEWING;
		} else if ("CHARGEABLE".equals(state)) {
			return CHARGEABLE;
		} else if ("CHARGING".equals(state)) {
			return CHARGING;
		} else if ("CHARGED".equals(state)) {
			return CHARGED;
		} else if ("PAYMENT_DECLINED".equals(state)) {
			return PAYMENT_DECLINED;
		} else if ("CANCELLED_BY_GOOGLE".equals(state)) {
			return CANCELLED_BY_GOOGLE;
		} else if ("CANCELLED".equals(state)) {
			return CANCELLED;
		} else {
			throw new RuntimeException("Invalid Financial State: " + state);
		}
	}
}
