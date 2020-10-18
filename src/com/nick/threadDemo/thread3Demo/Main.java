package com.nick.threadDemo.thread3Demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread thread = new Thread(new DownloadFileTask());
		thread.start();
		
		Thread.sleep(1000);
		
		thread.interrupt();
		thread.join(); //if kept above main will wait for thread-0 to complete.
		
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
