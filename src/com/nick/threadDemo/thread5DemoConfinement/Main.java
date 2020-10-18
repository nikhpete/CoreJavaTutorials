package com.nick.threadDemo.thread5DemoConfinement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		
		List<Thread> threads = new ArrayList<>();
		List<DownloadFileTask> tasks = new ArrayList<>();
		for(int i=0;i<10;++i) {
			DownloadFileTask task = new DownloadFileTask();
			tasks.add(task);
			Thread thread = new Thread(task);
			thread.start();
			threads.add(thread);
		}
		
		for(Thread thread :threads) {
			thread.join();
		}
		
		Optional<Integer> totalBytes = tasks
			.stream()
			.map(t-> t.getStatus().getTotalBytes())
			.reduce(Integer::sum);
		
		System.out.println(totalBytes);
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}

//confinement strategy, download status for each thread and in the last add them up.
