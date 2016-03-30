package com.farm.java.farmobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import com.farm.java.petobjects.Cat;
import com.farm.java.petobjects.Cow;
import com.farm.java.petobjects.Dog;
import com.farm.java.petobjects.Animal;

public class Farm {

	private List<Animal> pets = new CopyOnWriteArrayList<Animal>();

	public Farm() {
		System.out.println("Farm built!");
		Bank.setCash(15000);
	}

	public List<Animal> getPets() {
		return pets;
	}

	public void setPets(List<Animal> pets) {
		this.pets = pets;
	}

	public void takeInput() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an action: ");
		String action = input.nextLine();
		switch (action) {
		case "feed":
			this.feedSpecific();
			break;
		case "feed all":
			this.feedAll();
			break;
		case "walk":
			this.walkSpecific();
			break;
		case "walk all":
			this.walkAll();
			break;
		case "speak":
			this.speakSpecific();
			break;
		case "speak all":
			this.speakAll();
			break;
		case "report":
			this.readValues();
			break;
		case "add":
			System.out.print("Enter an animal: ");
			String animal = input.nextLine();
			addPetSpecific(animal);
			break;
		case "buy food":
			this.buyFood();
			break;
		case "quit":
			exitApp();
			break;
		default:
			System.out.println(action + " is not an action!");
			break;
		}
	}

	public void readValues() {
		for (Animal a : this.pets) {
			System.out.print(a.getName());
			System.out.print(" weighs " + a.getWeight() + "lbs and has " + a.getFood() + " food left! ");
			a.speak();
		}
	}

	public void addPet(Animal a) {
		pets.add(a);
		System.out.print("Added " + a.getName() + "! ");
		a.speak();
	}

	public void addPetSpecific(String name) {
		switch (name) {
		case "dog":
			Animal dog = new Dog();
			addPet(dog);
			break;
		case "cat":
			Animal cat = new Cat();
			addPet(cat);
			break;
		case "cow":
			Animal cow = new Cow();
			addPet(cow);
			break;
		default:
			System.out.println("Animal '" + name + "' not found!");
			break;
		}
	}

	public void feedAll() {
		for (Animal a : pets) {
			if (a.getFood() > 0) {
				a.feed();
				a.setFood(a.getFood() - 1);
			} else {
				System.out.println(a.getName() + " has no food left!");
			}
		}
	}

	public void feedSpecific() {
		int choice = specify();
		if (choice != -1) {
			Animal a = pets.get(choice);
			if (a.getFood() > 0) {
				a.feed();
				a.setFood(a.getFood() - 1);
			} else {
				System.out.println(a.getName() + " has no food left!");
			}
		}
	}

	public void speakAll() {
		for (Animal a : pets) {
			a.speak();
		}
	}

	public void speakSpecific() {
		int choice = specify();
		if (choice != -1) {
			pets.get(choice).speak();
		}
	}

	public void walkAll() {
		for (Animal a : pets) {
			a.walk();
		}
	}

	public void walkSpecific() {
		int choice = specify();
		if (choice != -1) {
			pets.get(choice).walk();
		}
	}

	public int specify() {
		@SuppressWarnings("resource")
		Scanner inputPet = new Scanner(System.in);
		ArrayList<Integer> choices = new ArrayList<Integer>();
		for (Animal a : pets) {
			choices.add(pets.indexOf(a) + 1);
			System.out.print(pets.indexOf(a) + 1);
			System.out.println(". " + a.getName() + ". " + a.getWeight() + "lbs.");
		}
		System.out.print("Choose number: ");
		try {
			Integer choice = new Integer(inputPet.nextInt());
			if (choices.contains(choice) == true) {
				return choice - 1;
			} else {
				System.out.println("Incorrect value!");
				return -1;
			}
		} catch (Exception e) {
			System.out.println("Incorrect value!");
			return -1;
		}
	}

	public void exitApp() {
		System.out.println("Destroying farm...");
		System.out.println("Killing " + pets.size() + " animals...");
		System.out.println("Exiting application...");
		System.exit(0);
	}

	public void checkPetWeight() {
		for (Animal p : pets) {
			if (p.getWeight() == 0) {
				System.out.println(p.getName() + " died from starvation!");
				pets.remove(p);
			}
		}
	}
	
	public void buyFood(){
		int choice = specify();
		Animal chosen = pets.get(choice);
		Bank.setCash(Bank.getCash() - chosen.getFoodPrice());
		chosen.setFood(chosen.getFood() + 1);
	}

}
