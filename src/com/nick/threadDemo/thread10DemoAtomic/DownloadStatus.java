package com.nick.threadDemo.thread10DemoAtomic;

import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {

	private AtomicInteger totalBytes = new AtomicInteger();
	// compare and swap is used.
	public void incrementStatus() {
		this.totalBytes.incrementAndGet();
	}
	
	public int getTotalBytes() {
		return this.totalBytes.get();
	}
}
