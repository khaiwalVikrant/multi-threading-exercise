package com.thread.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	Random random = new Random();
	/* Approach 1*/
//	private void stageOne() throws InterruptedException{
//	private synchronized void stageOne() throws InterruptedException{
//		Thread.sleep(1);
//		list1.add(random.nextInt(100));
//	}
	
	private void stageOne() throws InterruptedException{
		synchronized(lock1) {
			Thread.sleep(1);
			list1.add(random.nextInt(100));
		}
	}
	
//	private void stageTwo() throws InterruptedException{
//	private synchronized void stageTwo() throws InterruptedException{
//		Thread.sleep(1);
//		list2.add(random.nextInt(100));
//	}
	
	private void stageTwo() throws InterruptedException{
		synchronized(lock2) {
			Thread.sleep(1);
			list2.add(random.nextInt(100));
		}
	}
	
	private void process() throws InterruptedException{
		for(int i=0; i<1000; i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main() throws InterruptedException {
		System.out.println("Starting...");
		
		long startTime = System.currentTimeMillis();
		
		//process();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					process();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		long endTime = System.currentTimeMillis();
		
		System.out.println("Calculated time: " + (endTime - startTime));
		
		System.out.println("List1: " + list1.size() + " List2: " + list2.size());
	}
}
