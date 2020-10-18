package com.nick.executors.executor1Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(2);

		try {
			Future<Integer> future = executer.submit(()->{
				LongTask.simulate();
				return 1;
			});
			System.out.println("Submitted!!");
			try {
				Integer val = future.get();
				System.out.println(val);
			} catch (InterruptedException | ExecutionException e) {
				e.getStackTrace();
			}
		} finally {
			executer.shutdown();
		}
	}

}

//Callable similar to runnable-> task to return a value
// submit is returned immediately and the return procedure done in future