package com.farm.java.petobjects;

public abstract class Animal {

	private int weight;
	private String sound;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public void walk() {
		this.setWeight(this.getWeight() - 1);
		System.out.println(this.getName() + " walked enough to lose 1lb!");
	}

	public void speak() {
		System.out.println(this.getSound());
	}

	public abstract void feed();
	public abstract int getFood();
	public abstract void setFood(int food);
	public abstract int getFoodPrice();
}
