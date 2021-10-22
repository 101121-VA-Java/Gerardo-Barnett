package com.revature.driver;


import java.util.Scanner;

import com.revature.services.OOPservice;

public class Driver {
//encapsulation, inheritance, polymorphism, abstraction
	
	private static Scanner val = new Scanner(System.in);
	public static void main(String[] args) {
		String value = val.nextLine();;
		
		OOPservice oop = new OOPservice();
		switch(value) {
		    case "1": //encapsulation
		    	oop.doEncapsulation();
			    break;
		    case "2": //inheritance
			    oop.doInheritance();
			    break;
		    case "3": //polymorphism
			    oop.doPolymorphism();
			    break;
		    default:
		    	System.out.println("Option not available.");
		
		}
		val.close();
		
		
		
	}
	
}
