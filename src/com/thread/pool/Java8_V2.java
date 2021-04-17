package com.thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java8_V2 {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newWorkStealingPool();
		
		List<Callable<String>> list = Arrays.asList(
				() -> "task1",
				() -> "task2",
				() -> "task3");
		
		service.invokeAll(list)
		.stream()
		.map(future -> {
			try {
				return future.get();
			} catch(Exception e) {
	            throw new IllegalStateException(e);
			}
		})
		.forEach(System.out::println);

	}

}
