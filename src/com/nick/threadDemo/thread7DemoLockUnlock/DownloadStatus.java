package com.nick.threadDemo.thread7DemoLockUnlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {

	private int totalBytes;
	private Lock lock = new ReentrantLock();

	public void incrementStatus() {
		lock.lock();
		try {
			this.totalBytes++;
		} finally {   
			lock.unlock();    //definitely need to unlock when locked if exception comes
		}
	}

	public int getTotalBytes() {
		return this.totalBytes;
	}
}
