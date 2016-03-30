package com.farm.java.petobjects;

import com.farm.java.farmobjects.Supplies;

public class Cow extends Animal {
	
	private int foodPrice = 14;

	public int getFoodPrice() {
		return foodPrice;
	}
	public int getFood() {
		return Supplies.getCowFood();
	}

	public void setFood(int food) {
		Supplies.setCowFood(food);
	}

	public Cow() {
		this.setWeight(12);
		this.setSound("Moo!");
		this.setName("Cow");
		this.setFood(15);
	}

	public void feed() {
		this.setWeight(this.getWeight() + 1);
		System.out.println(this.getName() + " eats 1lb of grass!");
	}
}
