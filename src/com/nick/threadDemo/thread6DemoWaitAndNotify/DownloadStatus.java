package com.nick.threadDemo.thread6DemoWaitAndNotify;

public class DownloadStatus {

	private volatile boolean isDone; //unstable.. dont depend on cache value
									 // changes are visible across threads.
	private int totalBytes;
	private int totalfiles;
	private Object totalByteLock = new Object();

	public void incrementTotalBytes() {
		synchronized(totalByteLock) {         //built in block, monitor object in 
									 //and this is never recommended
			this.totalBytes++;
		}
	}

	public synchronized void incrementTotalfiles() {
			this.totalBytes++;
	}

	public int getTotalBytes() {
		return this.totalBytes;
	}

	public int getTotalfiles() {
		return totalfiles;
	}

	public boolean isDone() {   //adding synchronized would help but monitored by this
		return isDone;
	}

	public void done() {
		this.isDone = true;  //change done by thread1 is not visible to thread2 due to visibility.
							 // values stored is local to thread by cache
	}
}
