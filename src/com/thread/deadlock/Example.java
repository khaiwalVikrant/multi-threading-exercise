package com.thread.deadlock;

public class Example {

	public static void main(String[] args) throws InterruptedException {
		final Runner producer = new Runner();
		Thread t1 =new Thread(new Runnable() {
			public void run() {
				try {
					producer.firstThread();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			public void run() {
				try {
					producer.otherThread();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		producer.finished();
	}

}
