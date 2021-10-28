package com.revature;

public class ThreadDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable job = () -> {
			System.out.println("This is in a lambda expression.");
		};
		
		
		HelloThread t1 = new HelloThread();
		Thread t2 = new Thread(new GoodbyeThread());
		
		t1.start();
		t2.start();
		
		System.out.println("The state of t1 is: " + t1.getState());
		
		try {
			t1.join();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("The state of t1 is: " + t1.getState());
		
		System.out.println("End of the main method");
		
		

	}

}


class HelloThread extends Thread{
	
	@Override
	public void run() {
		
		System.out.println("Hello Thread has started!");
		
		
	}
	
}

class GoodbyeThread implements Runnable{
	
	
	public void run() {
		
		System.out.println("Goodbye Thread has started!");
	}
	
}