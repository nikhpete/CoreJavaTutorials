package com.nick.executors.executor3AsynImpl;

import java.util.concurrent.CompletableFuture;

public class MailService {

	public void send() throws InterruptedException {
		LongTask.simulate();
		System.out.println("Mail Sent..");
	}
	
	public CompletableFuture<Void> sendAsync() {
		return CompletableFuture.runAsync(()->{
			try {
				send();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}
