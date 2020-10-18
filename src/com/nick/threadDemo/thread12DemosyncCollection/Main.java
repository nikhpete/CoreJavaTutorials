package com.nick.threadDemo.thread12DemosyncCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		
		syncCollection();
		concurrentCollection();
		
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
	//uses the locks
	//-ve impact on performance and scalability
	public static void syncCollection() throws InterruptedException {
		Collection<Integer> collection = 
				Collections.synchronizedCollection(new ArrayList<>());
		
		Thread th1 = new Thread(()->{
			collection.addAll(Arrays.asList(1,2,3));
		});
		
		Thread th2 = new Thread(()->{
			collection.addAll(Arrays.asList(4,5,6));
		});
		
		th1.start();
		th2.start();
		
		th1.join();
		th2.join();
		
		System.out.println(collection);
	}
	
	
	public static void concurrentCollection() {
		
		Map<Integer, String> map = new ConcurrentHashMap<>(); //for achieving concurrency
		map.put(1,"a");
		map.get(1);
		map.remove(1);
	}

}


