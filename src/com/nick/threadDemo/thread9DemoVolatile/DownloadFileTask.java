package com.nick.threadDemo.thread9DemoVolatile;

public class DownloadFileTask implements Runnable{

	private DownloadStatus status;
	public DownloadFileTask(DownloadStatus status) {
		this.status = status;
	}

	@Override
	public void run() {
		System.out.println("Downloading a file: "+Thread.currentThread().getName());
		for(int i =0;i<1_000_000&& !Thread.currentThread().isInterrupted();++i) {
			status.incrementTotalBytes();
		}

		status.done();
		System.out.println("Download complete: "+ Thread.currentThread().getName());
	}

}
