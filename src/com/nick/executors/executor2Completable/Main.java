package com.nick.executors.executor2Completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable task = () -> System.out.println("a");
		CompletableFuture<Void> future = CompletableFuture.runAsync(task);
		
		Supplier<Integer> task2 = () -> 1;
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(task2);
		System.out.println(future2.get());
	}

}

//done in async fashion don't need to create executor object and shut it down