package com.revature.models;

public class BigAnimal extends Animal{
	
	int weight = 80;
	public BigAnimal() {
		super();
	}
	@Override
	public String whatDoesTheAnimalSay(String sound) {
		sound = sound.toUpperCase();
		return sound;
	}
	
	public int hungry() {
		int foodAmount = this.food(weight);
		foodAmount += 1;
		return foodAmount;
	}

}
