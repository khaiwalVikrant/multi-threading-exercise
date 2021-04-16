package com.thread.wait.notify;

public class App {

	public static void main(String[] args) throws InterruptedException {
		final Producer producer = new Producer();
		Thread t1 =new Thread(new Runnable() {
			public void run() {
				try {
					producer.produce();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 =new Thread(new Runnable() {
			public void run() {
				try {
					producer.consume();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

}
