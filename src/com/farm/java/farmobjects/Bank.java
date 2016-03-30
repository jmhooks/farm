package com.farm.java.farmobjects;

public class Bank extends Farm {

	protected static long cash;

	public static long getCash() {
		return cash;
	}

	public static void setCash(long cash) {
		Bank.cash = cash;
	}

	

}
