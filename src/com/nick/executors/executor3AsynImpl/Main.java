package com.nick.executors.executor3AsynImpl;

import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		MailService svc = new MailService();
		svc.sendAsync();
		System.out.println("Hello world");
		
		Thread.sleep(5000);  //need to be added as main thread closes before side thread
	}
}