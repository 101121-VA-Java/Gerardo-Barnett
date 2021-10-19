
import java.util.Scanner;

public class ScannerDriver {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
//		System.out.println("Hello World!");
//		System.out.println("What's your name?");
		
//		String name = sc.nextLine();
		
//		System.out.println("Hello " + name);
//		System.out.println("Pick a number:");
		
//		String number = sc.nextLine();
		
//		int num = Integer.parseInt(number);
		
//		System.out.println("You picked " + num);
		
//		ScannerDriver.loginScreen();
		ScannerDriver.menu();
		
		sc.close();
		
	}
	
	public static void loginScreen() {
		String uname = "admin";
		String pass = "pass";
		
		System.out.println("Please enter your username: ");
		String username = sc.nextLine();
		System.out.println("Please enter your password: ");
		String password = sc.nextLine();
		
		if(uname.equals(username) && pass.equals(password)) {
			System.out.println("You're logged in.");
		}
		else {
			System.out.println("Sorry, you can't login in.");
		}
	}
	
	public static void menu() {
		
		System.out.println("Enter a number from 1 to 3.");
		System.out.println("-1: Get a random number");
		System.out.println("-2: Using StringBuffer, reverse a word of the user's choice");
		System.out.println("-3: Exit the program");
		
		int choice = sc.nextInt();
		sc.nextLine();
		
		while(choice != 3) {
			switch(choice) {
			    case 1:
			    	double number = Math.round(Math.random()*1000);
					System.out.println("The random number is: " + (int) number + "\n");
					System.out.println("Enter a number from 1 to 3.");
					System.out.println("-1: Get a random number");
					System.out.println("-2: Using StringBuffer, reverse a word of the user's choice");
					System.out.println("-3: Exit the program");
					break;
			    case 2:
			    	System.out.println("Please enter a word.");
			    	StringBuffer sb = new StringBuffer(sc.nextLine());
					System.out.println("Your word in reverse is: " + sb.reverse() + "\n");
					System.out.println("Enter a number from 1 to 3.");
					System.out.println("-1: Get a random number");
					System.out.println("-2: Using StringBuffer, reverse a word of the user's choice");
					System.out.println("-3: Exit the program");
					break;
			    case 3:
			    	System.out.println("Goodbye");
			    	break;
				
			    default:	
				    System.out.println("Invalid option. Please try again!");
			
			}
			choice = sc.nextInt();
			sc.nextLine();
			
		
	}
	}

}
