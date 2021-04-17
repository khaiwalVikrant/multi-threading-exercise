package com.thread.create;

import java.util.concurrent.TimeUnit;

public class AppJava8V2 {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			public void run() {
				try {
					String name = Thread.currentThread().getName();
					System.out.println("Foo " + name);
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Bar " + name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
	}

}
