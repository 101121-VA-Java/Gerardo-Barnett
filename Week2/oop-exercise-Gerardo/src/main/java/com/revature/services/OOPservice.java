package com.revature.services;

import com.revature.models.BigAnimal;
import com.revature.models.SmallAnimal;

public class OOPservice {
	
	    // Encapsulation is the separation of variables that are stored within methods and classes. ie: Pills are stored in a container.
		public void doEncapsulation() {
			BigAnimal bull = new BigAnimal();
			SmallAnimal bird = new SmallAnimal();
			
			bull.setNumberOfLegs(4);
			bird.setNumberOfLegs(2);
			
			System.out.println("The bull has: " + bull.getNumberOfLegs() + " legs");
			System.out.println("The bird has: " + bird.getNumberOfLegs() + " legs");
		}
		// Inheritance is getting the parameters and methods from a parent class to a child class.  
		public void doInheritance() {
			BigAnimal ba = new BigAnimal();
			int foodAmount = ba.hungry();
			System.out.println("The hungry animal gets: " + foodAmount + " food");
		}
		// Polymorphism means that it has many forms and it has two kinds of methods, method overloading and method overriding.
		public void doPolymorphism() {
			
			//Overloading 
			BigAnimal a = new BigAnimal();
			SmallAnimal a1 = new SmallAnimal();
			a.setName("Lion");
			a.setType("Mamal");
			a.setNumberOfLegs(4);
			a.setCanFly(false);
			
			System.out.println("BigAnimal class: " + a);
			System.out.println("SmallAnimal class: " + a1);
			
			//Overriding
			String sound = a1.whatDoesTheAnimalSay("Rawr");
			
			System.out.println("The sound of the animal is : " + sound);	
		}
		// Abstraction is the process of identifying only the required characteristics of an object (hiding the parent class)
		public void doAbstraction() {
			BigAnimal ba = new BigAnimal();
			SmallAnimal sa = new SmallAnimal();
			
			String bigNoise = ba.whatDoesTheAnimalSay("Rawr");
			String littleNoise = sa.whatDoesTheAnimalSay("Tweet");
			
			System.out.println("The bull says: " + bigNoise);
			System.out.println("The bird says: " + littleNoise);
		}
		
		public void doException() {
			try {
				// The risky code goes here and the code can throw an exception
				int b = 1/0;
				System.out.println(b);
				
			} catch (Exception e) {
				// An exception is catched
				System.out.println("This is the problem:\n");
				e.printStackTrace();
			}
		}

}
