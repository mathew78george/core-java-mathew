package com.mathew.corejava.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {

	public static void testCallable() {
		ExecutorService executer = Executors.newSingleThreadExecutor();
		MyCallable call1 = new MyCallable();
		Future<String> future1 = executer.submit(call1);
		while (!future1.isDone()) {
			System.out.println("Waiting for task completion");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			String result = future1.get();
			System.out.println(result);
			executer.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tesExecute() {
		ExecutorService executer = Executors.newFixedThreadPool(5);
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		MyRunnable r3 = new MyRunnable();
		MyRunnable r4 = new MyRunnable();
		MyRunnable r5 = new MyRunnable();
		executer.execute(r1);
		executer.execute(r2);
		executer.execute(r3);
		executer.execute(r4);
		executer.execute(r5);
		executer.shutdown();
	}

	public static void testSubmit() {
		ExecutorService executer = Executors.newFixedThreadPool(5);
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		MyRunnable r3 = new MyRunnable();
		MyRunnable r4 = new MyRunnable();
		MyRunnable r5 = new MyRunnable();
		executer.submit(r1);
		executer.submit(r2);
		executer.submit(r3);
		executer.submit(r4);
		executer.submit(r5);
		executer.shutdown();
	}

	public static void main(String[] args) {
		testCallable();
	}

}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Inside Runnable of My Runnbale. Thread name is " + Thread.currentThread().getName());

	}

}

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done Sleeping");
		return "Done";
	}

}
