package com.thread.synchronization;

import java.util.Scanner;

class Processor extends Thread{
	//We use volatile keyword so that thread can't cache variable
	public volatile boolean isRunning = true;
	public void run() {
		while(isRunning) {
			System.out.println("Child thread");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		isRunning = false;
	}
}
public class Example1 {

	public static void main(String[] args) {
		Processor p = new Processor();
		p.start();
		
		System.out.println("Enter any key to stop the running child thread");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		p.shutdown();
	}

}
