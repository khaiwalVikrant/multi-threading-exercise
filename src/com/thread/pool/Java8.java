package com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Java8 {

	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(() -> {
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello " + threadName);
		});
		
		try {
			System.out.println("attempt to shutdown service");
			service.shutdown();
			service.awaitTermination(5, TimeUnit.SECONDS);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(!service.isTerminated()) {
				System.err.print("Cancelling not-finished taks!!!");
			}
			service.shutdownNow();
			System.out.println("Shutdown finished!!!");
		}
	}

}
