package com.nick.threadDemo.thread11DemoAdders;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {

	private LongAdder totalBytes = new LongAdder(); //prefer than atomic
	public void incrementStatus() {
		this.totalBytes.increment();;   
	}
	
	public int getTotalBytes() {
		return this.totalBytes.intValue(); //array of counters grow on demand, threads alter counters
										   // and last these counters are added and returned
	}
}
