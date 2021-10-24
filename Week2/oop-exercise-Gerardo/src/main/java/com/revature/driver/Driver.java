package com.revature.driver;


import java.util.Scanner;

import com.revature.services.OOPservice;

public class Driver {
//encapsulation, inheritance, polymorphism, abstraction
	
	private static Scanner val = new Scanner(System.in);
	public static void main(String[] args) {
		int value = val.nextInt();;
		
		OOPservice oop = new OOPservice();
		
		System.out.println("Select an option from 1 to 5");
		System.out.println("1: encapsulation");
		System.out.println("2: inheritance");
		System.out.println("3: polymorphism");
		System.out.println("4: abstraction");
		System.out.println("5: exception");
		
		switch(value) {
		    case 1: //encapsulation
		    	oop.doEncapsulation();
			    break;
		    case 2: //inheritance
			    oop.doInheritance();
			    break;
		    case 3: //polymorphism
			    oop.doPolymorphism();
			    break;
		    case 4: //abstraction
				oop.doAbstraction();
				break;
			case 5: //TryCatch
				oop.doException();
				break;
		    default:
		    	System.out.println("Option not available.");
		    	break;
		
		}
		val.close();
		
		
		
	}
	
}
