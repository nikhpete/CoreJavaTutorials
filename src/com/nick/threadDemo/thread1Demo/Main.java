package com.nick.threadDemo.thread1Demo;

public class Main {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());

		for(int i=0;i<10;++i) {  //on;y 4 threads
			Thread thread = new Thread(new DownloadFileTask());
			thread.start();
		}

		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}

//if available > required thread then thread scheduling is done.
