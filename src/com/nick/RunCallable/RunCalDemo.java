package com.nick.RunCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunCalDemo {

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService svc = Executors.newSingleThreadExecutor();
		svc.submit(new RunSubClass());
		
		Future<Integer> future = svc.submit(new CallSubClass());
		System.out.println(future.get());
		svc.shutdown();
	}
}

class RunSubClass implements Runnable{

	@Override
	public void run() {
		System.out.println("Runnable executing");
	}
	
}

class CallSubClass implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		return 1;
	}
	
}
