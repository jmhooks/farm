package com.farm.java.petobjects;

import com.farm.java.farmobjects.Supplies;

public class Cat extends Animal {
	
	private int foodPrice = 8;

	public int getFoodPrice() {
		return foodPrice;
	}
	public int getFood() {
		return Supplies.getCatFood();
	}

	public void setFood(int food) {
		Supplies.setCatFood(food);
	}

	public Cat() {
		this.setWeight(6);
		this.setSound("Meow!");
		this.setName("Cat");
		this.setFood(15);
	}

	public void feed() {
		this.setWeight(this.getWeight() + 1);
		System.out.println(this.getName() + " eats 1lb of Meow Mix!");
	}
}
