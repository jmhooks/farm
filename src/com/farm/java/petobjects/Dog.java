package com.farm.java.petobjects;

import com.farm.java.farmobjects.Supplies;

public class Dog extends Animal {

	private int foodPrice = 5;

	public int getFoodPrice() {
		return foodPrice;
	}

	public int getFood() {
		return Supplies.getDogFood();
	}

	public void setFood(int food) {
		Supplies.setDogFood(food);
	}

	public Dog() {
		this.setWeight(6);
		this.setSound("Woof!");
		this.setName("Dog");
		this.setFood(this.getFood()+15);
	}

	public void feed() {
		this.setWeight(this.getWeight() + 1);
		System.out.println(this.getName() + " eats 1lb of Kibbles and Bits!");
	}

}
