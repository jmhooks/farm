package com.farm.java.implement;

import com.farm.java.farmobjects.Farm;

public class Main {
	public static void main(String[] args) {
		Farm myFarm = new Farm();
		while (true) {
			myFarm.takeInput();
			myFarm.checkPetWeight();
		}
	}
}
