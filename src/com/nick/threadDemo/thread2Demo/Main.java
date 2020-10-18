package com.nick.threadDemo.thread2Demo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		Thread thread = new Thread(new DownloadFileTask());
		thread.start();
		
		thread.join(); // blocking other thread (main in this case)

		System.out.println("File ready to be scanned");
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
