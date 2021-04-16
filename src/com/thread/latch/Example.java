package com.thread.latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable{
	private CountDownLatch latch;
	Processor(CountDownLatch latch){
		this.latch = latch;
	}
	
	public void run() {
		System.out.println("Starting...");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		
		latch.countDown();
	}
}
public class Example {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch count = new CountDownLatch(3);
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++) {
			service.execute(new Processor(count));
		}
		
		count.await();
		
		System.out.println("Comleted...");
	}

}
