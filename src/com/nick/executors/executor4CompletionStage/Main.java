package com.nick.executors.executor4CompletionStage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1);
		future.thenRun(()-> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Done");
		});
		// for baove main thread executes

		future.thenRunAsync(()-> {
			System.out.println(Thread.currentThread().getName());
			System.out.println("Done");
		});
		//for above side thread from threadpool executes

		future.thenAccept(res -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(res);
		});
		//takes in consumer and runs in main

		future.thenAcceptAsync(res -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(res);
		});
		Thread.sleep(2000); //need to be added as main thread finishes before side
		//takes in consumer and runs in side thread


		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Getting current weather");
			throw new IllegalStateException();
		});

		System.out.println(future2.exceptionally(ex -> 1).get());
		//to handle exceptions exceptionally is used

		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(()->20);
		Double temp = future3.thenApply(cel -> (cel*1.8) +32).get();
		System.out.println(temp);
		// using the return value from future we can do manipulations.
		
		//optimized way of above
		future3.thenApply(Main::toFahrenhit).thenAccept(System.out::println);
		
	}
	
	public static int toFahrenhit(int cel) {
		return (int)(cel*1.8) +32;
	}
}

//main
//Done
//ForkJoinPool.commonPool-worker-3
//Done
//main
//1
//ForkJoinPool.commonPool-worker-3
//1