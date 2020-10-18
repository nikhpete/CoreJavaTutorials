package com.nick.threadDemo.thread6DemoWaitAndNotify;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());

		DownloadStatus status = new DownloadStatus();

		Thread thread = new Thread(new DownloadFileTask(status));
		Thread thread2 = new Thread(()->{
			while(!status.isDone()) {
				synchronized (status) {
					try {
						status.wait();   ///made to wait until the other thread wakes it up
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println(status.getTotalBytes());
		});

		thread.start();
		thread2.start();

		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}