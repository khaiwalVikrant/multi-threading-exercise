package com.thread.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) throws InterruptedException {
//		Semaphore sem = new Semaphore(1);
//		sem.acquire();
//		sem.release();
//		System.out.println("Available permits: " + sem.availablePermits());
		
//		Connection.getConnection().connect();
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i=0; i<200; i++) {
			service.submit(new Runnable() {
				public void run() {
					Connection.getConnection().connect();
				}
			});
		}
		
		service.shutdown();
		
		service.awaitTermination(1, TimeUnit.DAYS);
	}

}
