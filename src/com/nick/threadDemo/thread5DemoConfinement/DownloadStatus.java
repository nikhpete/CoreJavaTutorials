package com.nick.threadDemo.thread5DemoConfinement;

public class DownloadStatus {

	private int totalBytes;
	
	public void incrementStatus() {
		this.totalBytes++;
	}
	
	public int getTotalBytes() {
		return this.totalBytes;
	}
}
