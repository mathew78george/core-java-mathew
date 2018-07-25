package com.mathew.corejava.threads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicWrapper implements Runnable {

	private AtomicInteger atInteger;
	private AtomicBoolean atBool;
	private AtomicLong atLong;

	public AtomicWrapper() {
		atInteger = new AtomicInteger();
		atBool = new AtomicBoolean();
		atLong = new AtomicLong();
	}

	public void run() {
		System.out.println("Inside Run");
		for (int ii = 0; ii < 100; ii++) {
			System.out.println(atInteger.incrementAndGet());
//			System.out.println(atBool.getAndSet(true));
//			System.out.println(atLong.incrementAndGet());
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AtomicWrapper wrapper = new AtomicWrapper();
		Thread t1 = new Thread(wrapper);
		Thread t2 = new Thread(wrapper);
		Thread t3 = new Thread(wrapper);
		Thread t4 = new Thread(wrapper);
		Thread t5 = new Thread(wrapper);
		Thread t6 = new Thread(wrapper);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
