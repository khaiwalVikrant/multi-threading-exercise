package com.thread.synchronize;

public class Example {
	private int count = 0;
	public static void main(String[] args) {
		Example e = new Example();
		e.doSomeTask();
//		e.doSomeTaskWithOldWay();
	}
	
	//Solution of this problem we'll use synchronzed keyword - in this case at one point of time one thread has access of count variable
	private synchronized void increment() {
		count++;
	}
	
	private void doSomeTaskWithOldWay() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				for(int i=0; i<1000; i++) {
//					count++;
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				for(int i=0; i<1000; i++) {
//					count++;
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Count value with old way: " + count);
	}

	private void doSomeTask() {
		Runnable r1 = () -> {
			for(int i=0; i<1000; i++) {
				count++;
			}
		};
		
		Runnable r2 = () -> {
			for(int i=0; i<1000; i++) {
				count++;
			}
		};
		
		r1.run();
		r2.run();
		
		System.out.println("Count value: " + count);
	}

}
