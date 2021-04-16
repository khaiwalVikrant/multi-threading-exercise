package com.thread.wait.notify;

import java.util.Scanner;

public class Producer {
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread running ....");
			wait();
			System.out.println("Resumed...");
		}
	}
	
	public void consume() throws InterruptedException{
		Scanner sc = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key ...");
			sc.nextLine();
			sc.close();
			System.out.println("Return key pressed.");
			notify();
			Thread.sleep(5000);
		}
	}
}
