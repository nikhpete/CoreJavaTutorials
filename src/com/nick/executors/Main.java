package com.nick.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(2);

		try {
			executer.submit(()->{
				System.out.println(Thread.currentThread().getName());
			});
		} finally {
			executer.shutdown();
		}
	}

}

//executorService used to create a thread pool
//it needs to be shutdown
//solves thread haandling issues but concurrency problems