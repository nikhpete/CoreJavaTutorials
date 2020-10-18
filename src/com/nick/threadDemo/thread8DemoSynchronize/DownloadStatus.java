package com.nick.threadDemo.thread8DemoSynchronize;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {

	private int totalBytes;
	private int totalfiles;
	private Object totalByteLock = new Object();
	private Object totalFileLock = new Object();

	public void incrementTotalBytes() {
		synchronized(totalByteLock) {         //built in block, monitor object in 
									 //and this is never recommended
			this.totalBytes++;
		}
	}

	public void incrementTotalfiles() {
		synchronized(totalFileLock) {         // since this monitor both only thread ata time for both methods
			this.totalBytes++;
		}
	}

	public int getTotalBytes() {
		return this.totalBytes;
	}

	public int getTotalfiles() {
		return totalfiles;
	}
}
