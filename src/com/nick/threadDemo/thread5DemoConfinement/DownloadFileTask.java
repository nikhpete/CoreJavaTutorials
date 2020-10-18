package com.nick.threadDemo.thread5DemoConfinement;

public class DownloadFileTask implements Runnable{

	private DownloadStatus status;
	public DownloadFileTask() {
		this.status = new DownloadStatus();
	}

	@Override
	public void run() {
		System.out.println("Downloading a file: "+Thread.currentThread().getName());
		for(int i =0;i<10_000&& !Thread.currentThread().isInterrupted();++i) {
			status.incrementStatus();
		}

		System.out.println("Download complete: "+ Thread.currentThread().getName());
	}

	public DownloadStatus getStatus() {
		return status;
	}
}
