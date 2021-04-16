package com.thread.prod.cons;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			queue.put(random.nextInt(100));
		}
	}

	private static void consumer() throws InterruptedException {
		Random rand = new Random();
		while(true) {
			if(rand.nextInt() == 10) {
				Integer value = queue.take();
				System.out.println("Value: " + value + " : Size: " + queue.size());
			}
		}
	}
}
