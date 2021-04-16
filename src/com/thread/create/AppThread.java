package com.thread.create;

class Runner extends Thread{

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Child thread - " + i);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class AppThread {

	public static void main(String[] args) {
		Runner r1 = new Runner();
		r1.start(); // Start Child Thread
		
		for(int i=0; i<5; i++) {
			System.out.println("Main thread - " + i);
		}
	}

}
