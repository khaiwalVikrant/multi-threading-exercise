package com.thread.create;

class Runner1 implements Runnable{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Child thread - " + i);
		}
	}
}
public class AppRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner1());
		t1.start();
		t2.start();
		
		//Another way of Runnable
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				System.out.println("Inner Class Thread Creation");
			}
		});
		t3.start();
		for(int i=0; i<5; i++) {
			System.out.println("Main thread - " + i);
		}
	}

}
