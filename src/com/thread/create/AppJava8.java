package com.thread.create;

@FunctionalInterface
interface Runnable1{
	public void run();
}
public class AppJava8 {

	public static void main(String[] args) {
		
		Runnable r = new Runnable() {
			public void run() {
				for(int i=0;i<=4;i++)
					System.out.println("Child Thread Type 2 - " + i);
			}
		};
		Thread t2 = new Thread(r);
		t2.start();
		
		//With the help of @FunctionInterface
		Thread t3 = new Thread(new Runner1() {
			@Override
			public void run() {
				for(int i=0;i<=4;i++)
					System.out.println("Child Thread Type 3 - " + i);
			}
		});
		t3.start();
		
		Runnable1 r2 = () ->{
			for(int i=0;i<=4;i++)
				System.out.println("Child Thread Type 4 - " + i);
		};
		r2.run();
	}

}
