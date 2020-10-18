package com.nick.threadDemo.thread7DemoLockUnlock;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		
		DownloadStatus status = new DownloadStatus();
		
		List<Thread> threads = new ArrayList<>();
		for(int i=0;i<10;++i) {
			Thread thread = new Thread(new DownloadFileTask(status));
			thread.start();
			threads.add(thread);
		}
		
		for(Thread thread :threads) {
			thread.join();
		}
		
		System.out.println(status.getTotalBytes());
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
