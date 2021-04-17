package com.trhread.callable_future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) throws InterruptedException{
		ExecutorService service = Executors.newCachedThreadPool();
		
//		service.submit(new Runnable() {
//			public void run() {
//				Random random = new Random();
//				System.out.println("Starting...");
//				
//				int duration = random.nextInt(4000);
//				
//				try {
//					Thread.sleep(duration);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//				System.out.println("Finished.");
//			}
//		});
		
		Future<Integer> futu = service.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				System.out.println("Starting...");
				
				int duration = random.nextInt(4000);
				
				if(duration > 2000)
					throw new IOException("Sleeping for too long... .");
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finished.");
				
				return duration;
			}
		});
		
		service.shutdown();
		
		try {
			System.out.println("Result: " + futu.get());
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
