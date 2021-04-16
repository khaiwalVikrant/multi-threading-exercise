package com.thread.synchronization;

import java.util.LinkedList;
import java.util.Random;

public class Producer {
	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();
	
	public void produce() throws InterruptedException{
		int value = 0;
		while(true) {
			synchronized (lock) {
				while(list.size() == LIMIT) {
					lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}
	
	public void consume() throws InterruptedException{
		Random rand = new Random();
		while(true) {
			synchronized (lock) {
				while(list.size() == 0) {
					lock.wait();
				}
				System.out.print("List size: " + list.size());
				int value = list.removeFirst();
				System.out.println(" : value: " + value);
				lock.notify();
			}
			Thread.sleep(rand.nextInt(1000));
		}
	}
}
