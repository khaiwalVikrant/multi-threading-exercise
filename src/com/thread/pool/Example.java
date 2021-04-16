package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	Processor(int id){
		this.id = id;
	}
	public void run() {
		System.out.println("Starting - " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("Completed - " + id);
	}
}
public class Example {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++) {
			service.execute(new Processor(i));
		}
		
		service.shutdown();
		
		System.out.println("All tasks submitted...");
		
		service.awaitTermination(1, TimeUnit.HOURS);
		
		System.out.println("All tasks completed.");
	}

}
