package com.nick.threadDemo.thread9DemoVolatile;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());

		DownloadStatus status = new DownloadStatus();

		Thread thread = new Thread(new DownloadFileTask(status));
		Thread thread2 = new Thread(()->{
			while(!status.isDone()) {}
			System.out.println(status.getTotalBytes());
		});
		
		thread.start();
		thread2.start();

		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}