package com.nick.threadDemo.thread3Demo;

public class DownloadFileTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Downloading a file: "+Thread.currentThread().getName());

		for(int i =0;i<Integer.MAX_VALUE&& !Thread.currentThread().isInterrupted();++i)
			System.out.println("Downloading:"+i);
		System.out.println("Download complete: "+ Thread.currentThread().getName());
	}

}
